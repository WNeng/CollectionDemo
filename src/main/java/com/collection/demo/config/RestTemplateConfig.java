package com.collection.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author li
 * @Title: RestTemplateConfig
 * @ProjectName collection_api
 * @Description: TODO
 * @date 2019/2/24- 17:11
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate() {

//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setBufferRequestBody(false);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }


}
