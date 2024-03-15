package com.knit.mca.krcube.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Service
public class ConversionServiceImpl implements ConversionService {

	@Override
	public String convertcsvTojson(MultipartFile csvFile) {

		String jsonString = null;

		try {
			CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
			CsvMapper csvMapper = new CsvMapper();

			List<Map<?, ?>> list;

			MappingIterator<Map<?, ?>> mappingItertor = csvMapper.reader().forType(Map.class).with(csvSchema)
					.readValues(csvFile.getInputStream());
			list = mappingItertor.readAll();
			
			ObjectMapper objectMapper = new ObjectMapper();			
			jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonString;
	}

	@Override
	public String convertcsvTojson2(MultipartFile csvFile) {
		// TODO Auto-generated method stub
		return null;
	}
}

	
	/*@Override
	public List<DTO> convertcsvTojson2(MultipartFile csvFile) {

		String jsonString = null;

		try {
			CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
			CsvMapper csvMapper = new CsvMapper();

			List<Map<?, ?>> list;

			MappingIterator<Map<?, ?>> mappingItertor = csvMapper.reader().forType(Map.class).with(csvSchema)
					.readValues(csvFile.getInputStream());
			
			list = mappingItertor.readAll();
				
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonString;
	}

}*/
