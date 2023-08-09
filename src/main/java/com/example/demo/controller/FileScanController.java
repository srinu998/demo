package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.UploadService;

@RestController
public class FileScanController {
	
	@Autowired
	private UploadService uploadServiceImpl;

	
	@PostMapping("/upload/filescan")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		String response = uploadServiceImpl.scanFile(file);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
