package com.delta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.delta.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class TrueDeltaLoadingDumpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrueDeltaLoadingDumpApplication.class, args);
	}

}
