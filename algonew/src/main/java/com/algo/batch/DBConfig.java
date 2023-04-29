package com.algo.batch;

import javax.sql.DataSource;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

//@Component
public class DBConfig {
	
	private final String  ENCRYPTION_KEY= "abced1234";
	
	@Value("${datasource.url}")
    private String dburl;
	
	@Value("${datasource.username}")
    private String dbUserName;
	
	@Value("${datasource.password}")
    private String dbPassword;
	
	private String encryptedPassword;
	
	

   

    public String getEncryptedPassword() {
    	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(ENCRYPTION_KEY);
        encryptedPassword = encryptor.decrypt(dbPassword);
		return encryptedPassword;
	}


	
}
