package com.assignment.demo.data;

import com.assignment.demo.util.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MobileHandsetTest {

    @Test
    public void test_NoArgConstructor(){
        final MobileHandset handset = new MobileHandset();
        assertTrue(Objects.nonNull(handset));
    }

    @Test
    public void test_Json_Deserialization() {
        final String json = "{\"id\":25846,\"brand\":\"Apple\",\"phone\":\"Apple iPad Pro 12.9 (2018)\",\"picture\":\"https:\\/\\/cdn2.gsmarena.com\\/vv\\/bigpic\\/apple-ipad-pro-129-2018.jpg\",\"release\":{\"announceDate\":\"2018 October\",\"priceEur\":1100},\"sim\":\"Nano-SIM eSIM\",\"resolution\":\"2048 x 2732 pixels\",\"hardware\":{\"audioJack\":\"No\",\"gps\":\"Yes with A-GPS\",\"battery\":\"Li-Po 9720 mAh battery (36.71 Wh)\"}}";
        MobileHandset handset = TestUtil.doDeserialization(json, MobileHandset.class);
        assertTrue(Objects.nonNull(handset));
        assertTrue(Objects.nonNull(handset.getRelease()));
        assertTrue(Objects.nonNull(handset.getHardware()));
        assertEquals("Apple iPad Pro 12.9 (2018)",handset.getPhone());
        assertEquals("2018 October",handset.getRelease().getAnnounceDate());
        assertEquals("Li-Po 9720 mAh battery (36.71 Wh)",handset.getHardware().getBattery());
    }

    @Test
    public void test_Json_Serialization() {
        final String json = "{\"id\":25846,\"brand\":\"Apple\",\"phone\":\"Apple iPad Pro 12.9 (2018)\",\"picture\":\"https:\\/\\/cdn2.gsmarena.com\\/vv\\/bigpic\\/apple-ipad-pro-129-2018.jpg\",\"release\":{\"announceDate\":\"2018 October\",\"priceEur\":1100},\"sim\":\"Nano-SIM eSIM\",\"resolution\":\"2048 x 2732 pixels\",\"hardware\":{\"audioJack\":\"No\",\"gps\":\"Yes with A-GPS\",\"battery\":\"Li-Po 9720 mAh battery (36.71 Wh)\"}}";
        MobileHandset mobileHandset = TestUtil.doDeserialization(json, MobileHandset.class);
        String string = doSerialization(mobileHandset);
        assertNotNull(string);
        assertTrue(string.length() > 0);

    }


    private  String doSerialization(Object object)  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

}