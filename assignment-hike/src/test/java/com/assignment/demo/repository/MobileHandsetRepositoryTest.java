package com.assignment.demo.repository;

import com.assignment.demo.data.domain.MobileHandset;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class MobileHandsetRepositoryTest {
    @Mock
    private MobileHandsetRepository mobileHandsetRepository;


    @Test
    public void test_save() throws JsonProcessingException {
        final String json = "{\"id\":25846,\"brand\":\"Apple\",\"phone\":\"Apple iPad Pro 12.9 (2018)\",\"picture\":\"https:\\/\\/cdn2.gsmarena.com\\/vv\\/bigpic\\/apple-ipad-pro-129-2018.jpg\",\"release\":{\"announceDate\":\"2018 October\",\"priceEur\":1100},\"sim\":\"Nano-SIM eSIM\",\"resolution\":\"2048 x 2732 pixels\",\"hardware\":{\"audioJack\":\"No\",\"gps\":\"Yes with A-GPS\",\"battery\":\"Li-Po 9720 mAh battery (36.71 Wh)\"}}";
        MobileHandset handset = doDeserialization(json, MobileHandset.class);
        assertTrue(Objects.nonNull(handset));
        Mockito.when(mobileHandsetRepository.save(ArgumentMatchers.any(MobileHandset.class))).thenReturn(handset);
        MobileHandset save = mobileHandsetRepository.save(handset);
        assertEquals(handset, save);
        Mockito.verify(mobileHandsetRepository, Mockito.times(1)).save(handset);
    }

    private  <T> T  doDeserialization(String json,Class<T> cls) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json,cls);
    }

}