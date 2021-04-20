package com.assignment.demo.listeners;

import com.assignment.demo.data.domain.MobileHandset;
import com.assignment.demo.service.IProductCatalogService;
import com.assignment.demo.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class HikeApplicationListenerTest {
    @Mock
    IProductCatalogService productCatalogService;
    @InjectMocks
    HikeApplicationListener applicationListener;
    @Test
    void handleEvent(){
        List<MobileHandset> handsetList = Arrays.asList(TestUtil.getMobileHandSet());
        Mockito.when(productCatalogService.saveMobileHandsetsFromCatalog()).thenReturn(handsetList);
        applicationListener.handleEvent(new ApplicationReadyEvent(new SpringApplication(),null,null));
        Mockito.verify(productCatalogService, Mockito.times(1)).saveMobileHandsetsFromCatalog();
    }

}