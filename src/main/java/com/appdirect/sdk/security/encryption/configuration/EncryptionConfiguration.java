package com.appdirect.sdk.security.encryption.configuration;



import com.appdirect.sdk.security.encryption.EncryptDeserialize;
import com.appdirect.sdk.security.encryption.EncryptSerialize;
import com.appdirect.sdk.security.encryption.service.AESEncryptionServiceImpl;
import com.appdirect.sdk.security.encryption.service.EncryptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootConfiguration
public class EncryptionConfiguration {

	@Value("${encryption.key}")
	private String key;
	@Value("${encryption.initVector}")
	private String initVector;

	@Bean
	public EncryptDeserialize encryptDeserialize(EncryptionService encryptionService) {
		return new EncryptDeserialize(encryptionService);
	}

	@Bean
	public EncryptSerialize encryptSerialize(EncryptionService encryptionService) {
		return new EncryptSerialize(encryptionService);
	}

	@Bean
	public EncryptionService encryptionService() {
		return new AESEncryptionServiceImpl(key, initVector);
	}
}
