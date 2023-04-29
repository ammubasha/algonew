package com.algo.batch;


import java.util.Arrays;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Component;
@Component
public class AlgoUtil {
	Integer sumno = 0;
	
	public String generatePassword(String plainTxt) {
		
	    StandardPBEStringEncryptor encrypt = new StandardPBEStringEncryptor();
		//System.out.println(encrypt.encrypt(""));
		
		encrypt.setPassword("");
		encrypt.setAlgorithm("PBEWithMD5AndDES");
		String encryptedpwd = encrypt.encrypt(plainTxt);
		
	//	StrongPasswordEncryptor encrypt = new 
		//		StrongPasswordEncryptor(); 
		
		//String encryptedpwd = encrypt.encryptPassword(plainTxt);
		
		//BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		//String encryptedpwd = passwordEncryptor.encryptPassword(plainTxt);
		
	/*	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		String privateData = "secret-data";
		encryptor.setPassword("abcd1234");
		encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
		privateData = encryptor.encrypt("");*/
		return encryptedpwd;
	
	}
	

}
