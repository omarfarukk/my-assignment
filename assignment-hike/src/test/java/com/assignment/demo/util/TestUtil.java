package com.assignment.demo.util;

import com.assignment.demo.data.domain.MobileHandset;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface TestUtil {

    static MobileHandset getMobileHandSet() {
        final String json = "{\"id\":25846,\"brand\":\"Apple\",\"phone\":\"Apple iPad Pro 12.9 (2018)\",\"picture\":\"https:\\/\\/cdn2.gsmarena.com\\/vv\\/bigpic\\/apple-ipad-pro-129-2018.jpg\",\"release\":{\"announceDate\":\"2018 October\",\"priceEur\":1100},\"sim\":\"Nano-SIM eSIM\",\"resolution\":\"2048 x 2732 pixels\",\"hardware\":{\"audioJack\":\"No\",\"gps\":\"Yes with A-GPS\",\"battery\":\"Li-Po 9720 mAh battery (36.71 Wh)\"}}";
        return  doDeserialization(json, MobileHandset.class);
    }
     static <T> T  doDeserialization(String json,Class<T> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
         try {
             return objectMapper.readValue(json,cls);
         } catch (JsonProcessingException e) {
             return null;
         }
     }
}
