package com.assignment.demo.client.impl;

import com.assignment.demo.client.IProductCatalogClient;
import com.assignment.demo.data.domain.MobileHandset;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductCatalogClientImpl implements IProductCatalogClient {

    private final RestTemplate restTemplate;

    @Setter
    @Value("${product.mobile.handset.base-uri}")
    private String mobileHandsetCatalogBaseUrl;

    @Override
    public List< MobileHandset > getMobileHandsetsFromCatalog() {
        return restTemplate.exchange(
                        mobileHandsetCatalogBaseUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<MobileHandset>>() {}
                ).getBody();
    }



}
