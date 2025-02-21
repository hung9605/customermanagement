package com.app.customermanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data  
public class ParamConfig {
	@Value("${spring.datasource.username}")
    public String user;
	@Value("${spring.datasource.password}")
	public String pazzword;
	@Value("${urlDumpMac}")
	public String urlDumpMac;
	@Value("${urlDumpWin}")
	public String urlDumpWin;
	@Value("${urlUpload}")
	public String urlUpload;
	
	

}
