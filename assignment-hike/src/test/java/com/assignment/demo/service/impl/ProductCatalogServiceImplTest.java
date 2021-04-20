package com.assignment.demo.service.impl;

import com.assignment.demo.client.IProductCatalogClient;
import com.assignment.demo.data.domain.MobileHandset;
import com.assignment.demo.repository.MobileHandsetRepository;
import com.assignment.demo.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProductCatalogServiceImplTest {

    @Mock
    private MobileHandsetRepository mobileHandsetRepository;
    @Mock
    private IProductCatalogClient productCatalogClient;
    @InjectMocks
    ProductCatalogServiceImpl productCatalogService;


    @BeforeEach
    public void beforeExecution(){
    }

    @Test
    void saveMobileHandsetsFromCatalog() {
        List<MobileHandset> handsetList = Arrays.asList(TestUtil.getMobileHandSet());
        Mockito.when(productCatalogClient.getMobileHandsetsFromCatalog()).thenReturn(handsetList);
        Mockito.when(mobileHandsetRepository.saveAll(any())).thenReturn(handsetList);
        List<MobileHandset> mobileHandsets = productCatalogService.saveMobileHandsetsFromCatalog();
        assertEquals(mobileHandsets,handsetList);
        Mockito.verify(productCatalogClient, Mockito.times(1)).getMobileHandsetsFromCatalog();
        Mockito.verify(mobileHandsetRepository, Mockito.times(1)).saveAll(any());
    }

    @Test
    void saveAll() {
        List<MobileHandset> handsetList = Arrays.asList(TestUtil.getMobileHandSet());
        Mockito.when(mobileHandsetRepository.saveAll(any())).thenReturn(handsetList);

        List<MobileHandset> mobileHandsets = productCatalogService.saveAll(handsetList);
        assertEquals(mobileHandsets,handsetList);
        Mockito.verify(mobileHandsetRepository, Mockito.times(1)).saveAll(any());
    }

    @Test
    void readMobileHandsetsFromCatalog() {
        List<MobileHandset> handsetList = Arrays.asList(TestUtil.getMobileHandSet());
        Mockito.when(productCatalogClient.getMobileHandsetsFromCatalog()).thenReturn(handsetList);
        List<MobileHandset> mobileHandsets = productCatalogService.readMobileHandsetsFromCatalog();
        assertEquals(mobileHandsets,handsetList);
        Mockito.verify(productCatalogClient, Mockito.times(1)).getMobileHandsetsFromCatalog();
    }

    @Test
    void search_positive_case() {
        List<MobileHandset> handsetList = Arrays.asList(TestUtil.getMobileHandSet());
        Mockito.when(mobileHandsetRepository.findAll(any(Example.class))).thenReturn(handsetList);
        MobileHandset searchParameter = new MobileHandset();
        searchParameter.setSim("esim");
        List<MobileHandset> search = productCatalogService.search(searchParameter);
        assertEquals(search,handsetList);
        Mockito.verify(mobileHandsetRepository, Mockito.times(1)).findAll(any(Example.class));
    }

    @Test
    void search_negetive_case_null() {
        MobileHandset searchParameter = null;
        List<MobileHandset> search = productCatalogService.search(searchParameter);
        assertEquals(Collections.EMPTY_LIST, search);
    }

    @Test
    void search_negetive_case_empty() {
        MobileHandset searchParameter = new MobileHandset();
        List<MobileHandset> search = productCatalogService.search(searchParameter);
        assertEquals(Collections.EMPTY_LIST, search);
    }

}