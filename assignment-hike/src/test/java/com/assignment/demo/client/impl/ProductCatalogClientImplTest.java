package com.assignment.demo.client.impl;

import com.assignment.demo.data.domain.MobileHandset;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ProductCatalogClientImplTest {

    @Mock
    private RestTemplate restTemplate;
    private String baseURL = "https://run.mocky.io/v3/b755c334-9627-4b09-84f2-548cb1918184";
    @InjectMocks
    private ProductCatalogClientImpl productCatalogClient;

    @Test
    public void test_getMobileHandsetsFromCatalog() throws JsonProcessingException {
        List<MobileHandset> handSets = Arrays.asList(getMobileHandSet());
        productCatalogClient.setMobileHandsetCatalogBaseUrl(baseURL);
        List<MobileHandset> mobileHandsetsFromCatalog = productCatalogClient.getMobileHandsetsFromCatalog();
        assertTrue(Objects.nonNull(mobileHandsetsFromCatalog));
        assertNotEquals(handSets, mobileHandsetsFromCatalog);
    }

    private  MobileHandset getMobileHandSet() throws JsonProcessingException {
        final String json = "{\"id\":25846,\"brand\":\"Apple\",\"phone\":\"Apple iPad Pro 12.9 (2018)\",\"picture\":\"https:\\/\\/cdn2.gsmarena.com\\/vv\\/bigpic\\/apple-ipad-pro-129-2018.jpg\",\"release\":{\"announceDate\":\"2018 October\",\"priceEur\":1100},\"sim\":\"Nano-SIM eSIM\",\"resolution\":\"2048 x 2732 pixels\",\"hardware\":{\"audioJack\":\"No\",\"gps\":\"Yes with A-GPS\",\"battery\":\"Li-Po 9720 mAh battery (36.71 Wh)\"}}";
        return  doDeserialization(json, MobileHandset.class);
    }

    private  <T> T  doDeserialization(String json,Class<T> cls) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json,cls);
    }

}