package com.assignment.demo.controllers;

import com.assignment.demo.data.domain.MobileHandset;
import com.assignment.demo.service.IProductCatalogService;
import com.assignment.demo.util.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MobileHandsetControllerTest {
    @Mock
    IProductCatalogService productCatalogService;
    @InjectMocks
    MobileHandsetController controller;

    @Test
    void searchMobileHandsets() {
        List<MobileHandset> handsetList = Arrays.asList(TestUtil.getMobileHandSet());
        Mockito.when(productCatalogService.search(any(MobileHandset.class))).thenReturn(handsetList);
        MobileHandset searchParameter = new MobileHandset();
        searchParameter.setSim("esim");
        List<MobileHandset> mobileHandsets = controller.searchMobileHandsets(searchParameter);
        assertEquals(mobileHandsets,handsetList);
        Mockito.verify(productCatalogService, Mockito.times(1)).search(any(MobileHandset.class));
    }

}