package com.delta.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delta.property.FileStorageProperties;
import com.delta.utils.Utils;

/**
 * 
 * @author AMINE SAFI
 * 
 */
@RestController
public class DumpLoaderController {

	@Autowired
	FileController fileController;

	@Autowired
	FileStorageProperties fileStorageProperties;

	/**
	 * Normalize the dump file path.
	 * Prepare the command to import the dump to a MongoDB database.
	 * Run the thread to execute the command.
	 * @param  database the database that the user want to import his collection to.
	 * @param  collection the collection name that the user want to create.
	 * @param fileName the dump file name that the user want to load it into the database.
	 * @return a simple message to indicate that the operation was completed successfully.
	 */
	@PostMapping("loaddump")
	public ResponseEntity<String> uploadDump(@RequestParam String database, @RequestParam String collection,
			@RequestParam String fileName) throws IOException, InterruptedException {
		Path BASE_URL = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		String command = Utils.shell + " --host " + Utils.host + " --port " + Utils.port + " --db " + database
				+ " --collection " + collection + " " + BASE_URL + "\\" + fileName;
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();
		return new ResponseEntity<String>("Dump loaded and imported to MongoDB Successfully [ Amine SAFI © ]",
				HttpStatus.OK);

	}

}
