package com.securly.syncservice.invoker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.securly.syncservice.controller.exception.CanvasAccountException;
import com.securly.syncservice.controller.exception.CanvasCourseException;
import com.securly.syncservice.model.CanvasAcount;

@Component("canvasAccountInvoker")
public class CanvasAccountInvoker {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${canvas.api.token}") // Token value for authorization
	private String canvasApiToken;

	@Value("${canvas.api.base-url}")
	private String canvasBaseUrl;

	@Value("${canvas.api.account-endpoint}")
	private String canvasAccountEndPoint;

	public List<CanvasAcount> getAllCanvasAccounts() {

		List<CanvasAcount> response = null;

		try {
			String url = prepareRequest();

			// Set headers including authorization token
			restTemplate.setInterceptors(List.of((request, body, execution) -> {
				HttpHeaders headers = request.getHeaders();
				headers.set("Authorization", "Bearer " + canvasApiToken);
				// Add other headers if needed
				return execution.execute(request, body);
			}));

			ResponseEntity<List<CanvasAcount>> responseEntity = restTemplate.exchange(url,
					org.springframework.http.HttpMethod.GET, null,
					new ParameterizedTypeReference<List<CanvasAcount>>() {
					});

			if (responseEntity.getStatusCode().isSameCodeAs(HttpStatus.OK)) {
				response = responseEntity.getBody();
			}
		} catch (CanvasAccountException accountException) {
			throw accountException;
		} catch (CanvasCourseException courseException) {
			throw courseException;
		} catch (Exception exception) {
			throw new CanvasAccountException("Get Account Error",
					CanvasAccountException.ErrorCode.ACCOUNT_CREATION_FAILED);
		}
		return response;
	}

	private String prepareRequest() {

		// Set base URL for all requests
		return canvasBaseUrl + canvasAccountEndPoint;
	}

}
