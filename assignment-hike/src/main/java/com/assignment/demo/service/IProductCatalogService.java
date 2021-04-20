package com.assignment.demo.service;

import com.assignment.demo.data.domain.MobileHandset;

import java.util.List;

public interface IProductCatalogService {
    void refreshMobileHandsetCatalog();
    List<MobileHandset> findMobileHandsets(MobileHandset mobileHandset);

}
