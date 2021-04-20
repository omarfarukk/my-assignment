package com.assignment.demo.service;

import com.assignment.demo.data.domain.MobileHandset;
import com.assignment.demo.util.TestUtil;
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
    public void test_findMobileHandsets_positive_case() {
        MobileHandset handset = TestUtil.getMobileHandSet();
        assertTrue(Objects.nonNull(handset));
        List<MobileHandset> handSets = Arrays.asList(handset);
        Mockito.when(productCatalogService.search(ArgumentMatchers.any(MobileHandset.class))).thenReturn(handSets);
        List<MobileHandset> returnedHandSets = productCatalogService.search(handset);
        assertTrue(Objects.nonNull(returnedHandSets));
        assertEquals(handSets.size(), returnedHandSets.size());
        assertEquals(handSets,returnedHandSets);
        Mockito.verify(productCatalogService, Mockito.times(1)).search(handset);
    }

    @Test
    public void test_findMobileHandsets_negative_case()  {
        MobileHandset handset = TestUtil.getMobileHandSet();
        assertTrue(Objects.nonNull(handset));
        List<MobileHandset> handSets = Arrays.asList(handset);
        Mockito.when(productCatalogService.search(ArgumentMatchers.any(MobileHandset.class))).thenReturn(null);
        List<MobileHandset> returnedHandSets = productCatalogService.search(handset);
        assertTrue(Objects.isNull(returnedHandSets));
        assertNotEquals(handSets,returnedHandSets);
        Mockito.verify(productCatalogService, Mockito.times(1)).search(handset);
    }



}