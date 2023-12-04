package com.securly.syncservice.service;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service("canvasAuthService")
public class CanvasAuthService {

	@Autowired
	private RestTemplate restTempate;
	
	private String TOKEN_URL = "http://3.231.151.15/login/oauth2/auth";
	private String CLIENT_ID = "7qS91XoJ7I1QPOxPMO5wNcObSM6f9zxA0nEa16suhEaMsuclvNE75X6NtNZqxE8W";
	private String CLIENT_SECRET = "mAgVCJUInAHal0Vn42jl18GYOfkzJSR5uf1uSx6Sf2dQL3QwCC8GBAcATibIJ4PJ";
	private String USERNAME = "miken@bloove.com";
	private String PASSWORD = "testtest";
	private String GRANT_TYPE = "password";
	
	@Value("${canvas.develper.key}")
	private String existingKeystoreInputStream;

	@SuppressWarnings("deprecation")
	public void authorize() {
		ResponseEntity<String> response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TOKEN_URL).queryParam("grant_type", GRANT_TYPE)
					.queryParam("client_id", CLIENT_ID).queryParam("client_secret", CLIENT_SECRET)
					.queryParam("username", USERNAME).queryParam("password", PASSWORD);

			HttpEntity<String> request = new HttpEntity<>(headers);

			response = restTempate.exchange(builder.toUriString(), HttpMethod.GET, request,
					String.class);

			saveAuthToken(response);

			if (response.getStatusCode() == HttpStatus.OK) {
				extractAccessToken(response.getBody());
			} else {
				throw new RuntimeException("Failed to obtain access token. Status code: " + response.getStatusCodeValue());
			}
		}catch(Exception exception) {
			saveAuthToken(response);
		}
		
	}

	private void saveAuthToken(ResponseEntity<String> response) {

		try {
			// Create a new ByteArrayInputStream object, passing the string to be converted
			// as the argument to the constructor.
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					existingKeystoreInputStream.getBytes());

			// Call the read() method on the ByteArrayInputStream object to read the bytes
			// from the string.
			byte[] bytes = new byte[1024];
			int bytesRead;

			bytesRead = byteArrayInputStream.read(bytes);

			// Pass the bytes read from the ByteArrayInputStream object to the constructor
			// of a new InputStream object.
			InputStream inputStream = new ByteArrayInputStream(bytes, 0, bytesRead);

			KeyStore keyStore = KeyStore.getInstance("JKS"); // Or "PKCS12" for PKCS#12 format
			char[] password = "keystorePassword".toCharArray(); // Password to access the KeyStore

			// Load an existing KeyStore or create a new one
			keyStore.load(inputStream, password);
			
			
			KeyGenerator keyGen = KeyGenerator.getInstance("AES"); // Or any other algorithm
			keyGen.init(256); // Key size
			SecretKey secretKey = keyGen.generateKey();

			// Store the key in the KeyStore
			KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
			KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection("keyPassword".toCharArray());
			keyStore.setEntry("alias", secretKeyEntry, protectionParam);
			
//			SecretKey existingSecretKey = secretKey;
//			KeyStore.SecretKeyEntry secretKeyEntry1 = new KeyStore.SecretKeyEntry(existingSecretKey);
//			KeyStore.ProtectionParameter protectionParam1 = new KeyStore.PasswordProtection("keyPassword".toCharArray());
//			keyStore.setEntry("alias", secretKeyEntry1, protectionParam1); // Replace "alias" with your key's alias
			
			try (FileOutputStream fos = new FileOutputStream("/canvas-sync-service/src/main/resources/keystore.jks")) {
			    keyStore.store(fos, password);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String extractAccessToken(String responseBody) {
		return responseBody;
	}
}
