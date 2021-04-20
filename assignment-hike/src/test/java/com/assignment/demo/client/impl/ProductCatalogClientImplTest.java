package com.assignment.demo.client.impl;

import com.assignment.demo.data.domain.MobileHandset;
import com.assignment.demo.util.TestUtil;
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

    private RestTemplate restTemplate = new RestTemplate();
    private String baseURL = "https://run.mocky.io/v3/b755c334-9627-4b09-84f2-548cb1918184";
    private ProductCatalogClientImpl productCatalogClient = new ProductCatalogClientImpl(restTemplate);

    @Test
    public void test_getMobileHandsetsFromCatalog() {
        List<MobileHandset> handSets = Arrays.asList(TestUtil.getMobileHandSet());
        productCatalogClient.setMobileHandsetCatalogBaseUrl(baseURL);
        List<MobileHandset> mobileHandsetsFromCatalog = productCatalogClient.getMobileHandsetsFromCatalog();
        assertTrue(Objects.nonNull(mobileHandsetsFromCatalog));
        assertNotEquals(handSets, mobileHandsetsFromCatalog);
    }

}