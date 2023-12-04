package com.securly.syncservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.securly.syncservice.service.CanvasAuthService;

@RestController
@RequestMapping("/api/v1")
public class CanvasAuthController {

	@Autowired
	private CanvasAuthService canvasAuthService;
	
	@GetMapping("/auth")
	@ResponseStatus(value = HttpStatus.OK)
	public void auth() {
		canvasAuthService.authorize();
	}
}
