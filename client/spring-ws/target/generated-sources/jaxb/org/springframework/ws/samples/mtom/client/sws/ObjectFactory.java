//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.07.30 at 05:01:48 PM AEST 
//


package org.springframework.ws.samples.mtom.client.sws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.springframework.ws.samples.mtom.client.sws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.springframework.ws.samples.mtom.client.sws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StoreContentRequest }
     * 
     */
    public StoreContentRequest createStoreContentRequest() {
        return new StoreContentRequest();
    }

    /**
     * Create an instance of {@link StoreContentResponse }
     * 
     */
    public StoreContentResponse createStoreContentResponse() {
        return new StoreContentResponse();
    }

    /**
     * Create an instance of {@link LoadContentRequest }
     * 
     */
    public LoadContentRequest createLoadContentRequest() {
        return new LoadContentRequest();
    }

    /**
     * Create an instance of {@link LoadContentResponse }
     * 
     */
    public LoadContentResponse createLoadContentResponse() {
        return new LoadContentResponse();
    }

}
