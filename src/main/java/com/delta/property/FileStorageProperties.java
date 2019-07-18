package com.delta.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 
 * @author AMINE SAFI
 * 
 * 
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}