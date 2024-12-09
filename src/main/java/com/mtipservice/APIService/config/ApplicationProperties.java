package com.mtipservice.APIService.config;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import com.mtipservice.APIService.Constants;


@Configuration
@RefreshScope
public class ApplicationProperties {
	
	/*
	@Value(Constants.CONNECTION_TIMEOUT)
	private int timeout;


	@Value(Constants.SERVER_SSL_CERT_PATH)
	private String sslCertPath;

	@Value(Constants.SERVER_SSL_TRUST_PATH)
	private String sslTrustPath;

	@Value(Constants.SERVER_SSL_CERT_PASSWORD)
	private String sslCertPassword;

	@Value(Constants.SERVER_SSL_TRUST_PASSWORD)
	private String sslTrustPassword;
	


	@RefreshScope
	@Bean(name = "restTemplate")
	public RestTemplate restTemplateOrderDetails() throws Exception {

		SSLContext sslContext = new SSLContextBuilder().loadKeyMaterial(keyStore(sslCertPath, sslCertPassword), sslCertPassword.toCharArray())
				.loadTrustMaterial(new File(sslTrustPath), sslTrustPassword.toCharArray()).build();
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
		
		HttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
				.setSSLSocketFactory(socketFactory)
				.build();
		
		CloseableHttpClient c5 = HttpClients.custom()
				.setConnectionManager(connectionManager)
				.evictExpiredConnections()
				.build();

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(c5);

		clientHttpRequestFactory.setConnectTimeout(timeout);
		clientHttpRequestFactory.setConnectionRequestTimeout(timeout);

		return new RestTemplate(clientHttpRequestFactory);
	}
	

	private KeyStore keyStore(String file, String password) throws Exception {
		KeyStore keyStore = KeyStore.getInstance("JKS");
		File key = ResourceUtils.getFile(file);
		try (InputStream in = new FileInputStream(key)) {
			keyStore.load(in, password.toCharArray());
		}
		return keyStore;
	}*/	
}
