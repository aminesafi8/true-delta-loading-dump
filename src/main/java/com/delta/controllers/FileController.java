package com.delta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.delta.payload.Dump;
import com.delta.service.FileStorageService;

/**
 * 
 * @author AMINE SAFI
 * 
 */
@RestController
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;

	/**
	 * Use the dedicated service and inject it to upload the file to the location 
	 * which is mentioned in the application.properties file 
	 * @param  file the file that the user want to upload to the server to continue the rest of the operations on it
	 * @return a simple message to indicate that the operation was completed successfully
	 * by showing the file name, the download URI, the content type and the size
	 */
	
	@PostMapping("/uploadFile")
	public Dump uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		return new Dump(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}

}