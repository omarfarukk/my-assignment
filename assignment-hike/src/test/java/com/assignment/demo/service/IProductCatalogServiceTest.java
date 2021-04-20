package com.assignment.demo.service;

import com.assignment.demo.data.domain.MobileHandset;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IProductCatalogServiceTest {
    @Mock
    private IProductCatalogService productCatalogService;

    @Test
    public void test_findMobileHandsets_positive_case() throws JsonProcessingException {
        MobileHandset handset = getMobileHandSet();
        assertTrue(Objects.nonNull(handset));
        List<MobileHandset> handSets = Arrays.asList(handset);
        Mockito.when(productCatalogService.findMobileHandsets(ArgumentMatchers.any(MobileHandset.class))).thenReturn(handSets);
        List<MobileHandset> returnedHandSets = productCatalogService.findMobileHandsets(handset);
        assertTrue(Objects.nonNull(returnedHandSets));
        assertEquals(handSets.size(), returnedHandSets.size());
        assertEquals(handSets,returnedHandSets);
        Mockito.verify(productCatalogService, Mockito.times(1)).findMobileHandsets(handset);
    }

    @Test
    public void test_findMobileHandsets_negative_case() throws JsonProcessingException {
        MobileHandset handset = getMobileHandSet();
        assertTrue(Objects.nonNull(handset));
        List<MobileHandset> handSets = Arrays.asList(handset);
        Mockito.when(productCatalogService.findMobileHandsets(ArgumentMatchers.any(MobileHandset.class))).thenReturn(null);
        List<MobileHandset> returnedHandSets = productCatalogService.findMobileHandsets(handset);
        assertTrue(Objects.isNull(returnedHandSets));
        assertNotEquals(handSets,returnedHandSets);
        Mockito.verify(productCatalogService, Mockito.times(1)).findMobileHandsets(handset);
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