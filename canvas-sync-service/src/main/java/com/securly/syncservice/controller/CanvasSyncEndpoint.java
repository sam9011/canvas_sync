package com.securly.syncservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.web.bind.annotation.RestController;

import com.securly.syncservice.service.CanvasSyncService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Endpoint(id = "canvas-sync")
@Slf4j
public class CanvasSyncEndpoint {

	
	@Autowired
	@Qualifier("canvasSyncService")
	private CanvasSyncService canvasSyncService;
	
	@WriteOperation
	public String syncWithCanvas() {

		log.info("account and cource sync initiated");
		canvasSyncService.sync();
		
		
		
		return "{\"temp\":\"Sync with Canvas initiated\"}";
	}
}
