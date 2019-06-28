package com.collection.demo;

import com.collection.demo.constant.Constants;
import com.collection.demo.utils.SignUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

    }


    /**
     * 获取
     */
    @Test
    public void testGetOrderByOrderNo() {
        String url = "http://localhost:8600/order/getOrderByOrderNo";
        Map paramsMap = new HashMap();
        paramsMap.put("orderNo", "181217095411259");
//        paramsMap.put("sign", "0UuhqL7uqBmo1pX4p9DPuD3e5K5g6FO0G2dWhZrYEXk=");
        try {
            String sign = SignUtil.createSign(paramsMap, Constants.APP_KEY, true);
            paramsMap.put("sign", sign);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.setAll(paramsMap);
        HttpHeaders headers = new HttpHeaders();
        headers.add("appid", Constants.APP_ID);
        HttpEntity<MultiValueMap<String, Object>> paramsEntiry = new HttpEntity<>(postParameters, headers);
        String data = restTemplate.postForObject(url, paramsEntiry, String.class);
        System.out.println(data);





    }
}
