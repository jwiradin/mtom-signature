package org.springframework.ws.samples.mtom.client.sws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.support.CryptoFactoryBean;

import java.io.IOException;

/**
 * @author Arjen Poutsma
 */
@Configuration
public class MtomClientConfig {

	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() throws Exception {
		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();

		// set security actions
//		securityInterceptor.setSecurementActions("Timestamp Signature Encrypt");
		securityInterceptor.setSecurementActions("Timestamp Signature");
		// sign the request
		securityInterceptor.setSecurementUsername("client");
		securityInterceptor.setSecurementPassword("install");
		securityInterceptor.setSecurementSignatureCrypto(getCryptoFactoryBean().getObject());

		// encrypt the request
		securityInterceptor.setSecurementEncryptionUser("server-public");
		securityInterceptor.setSecurementEncryptionCrypto(getCryptoFactoryBean().getObject());
		securityInterceptor.setSecurementEncryptionParts("{Content}{http://www.springframework.org/spring-ws/samples/mtom}StoreContentRequest");
		securityInterceptor.setSecurementSignatureKeyIdentifier("DirectReference");

		return securityInterceptor;
	}

	@Bean
	public CryptoFactoryBean getCryptoFactoryBean() throws IOException {
		CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
		cryptoFactoryBean.setKeyStorePassword("install");
		cryptoFactoryBean.setKeyStoreLocation(new ClassPathResource("keystore.jks"));
		return cryptoFactoryBean;
	}

	@Bean
	public SaajMtomClient saajClient(SaajSoapMessageFactory messageFactory, Jaxb2Marshaller marshaller) {

		SaajMtomClient client = new SaajMtomClient(messageFactory);
		client.setDefaultUri("http://localhost:8080/mtom-server/services");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public SaajSoapMessageFactory saajSoapMessageFactory() {
		return new SaajSoapMessageFactory();
	}

	@Bean
	public Jaxb2Marshaller marshaller() {

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("org.springframework.ws.samples.mtom.client.sws");
		marshaller.setMtomEnabled(true);
		return marshaller;
	}

}
