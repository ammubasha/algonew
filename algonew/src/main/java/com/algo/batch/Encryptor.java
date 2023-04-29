package com.algo.batch;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Encryptor {
	private final String  ENCRYPTION_KEY= "";

	@Value("${datasource.password}")
    private String dbPassword;
	

	
	@Value("#{new Boolean('${db.encryption.flag:true}')}")
	private boolean encryptionFlag;
	
	private String encryptedPassword;
	
	

   

    public String getEncryptedPassword() {
    	if(encryptionFlag) {
	    	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
	        encryptor.setPassword(ENCRYPTION_KEY);
	        encryptedPassword = encryptor.decrypt(dbPassword);
			return encryptedPassword;
    	}
    	else {
    		return dbPassword;
    	}
	}

}
