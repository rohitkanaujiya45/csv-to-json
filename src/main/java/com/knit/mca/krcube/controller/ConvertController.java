package com.knit.mca.krcube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.knit.mca.krcube.service.ConversionService;

@RestController
@RequestMapping("/ConvertController")
public class ConvertController {
	
	@Autowired
	ConversionService conversionService;

	@GetMapping(value = "/index", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> index() {
		return ResponseEntity.status(HttpStatus.OK).body("Books are usefull");
	}

	@PostMapping("/api/file-upload")
	public ResponseEntity<String> uploadCsvFile(@RequestParam("csvFile") MultipartFile csvFile) {
		try {
			
			String json =conversionService.convertcsvTojson(csvFile);
			return ResponseEntity.status(HttpStatus.OK).body(json);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File not uploaded");

		}

	}
}

	/*@PostMapping("/api/file-upload2")
	public ResponseEntity<List<DTO>> uploadCsvFile2(@RequestParam("csvFile") MultipartFile csvFile) {
		try {
			
			List<DTO> dto =conversionService.convertcsvTojson2(csvFile);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File not uploaded");

		}

	}
}*/
