package com.knit.mca.krcube.service;

import org.springframework.web.multipart.MultipartFile;

public interface ConversionService {
	public String convertcsvTojson(MultipartFile csvFile);

	public String convertcsvTojson2(MultipartFile csvFile);



}
