package com.assignment.demo.service;

import com.assignment.demo.data.domain.MobileHandset;

import java.util.List;

public interface IProductCatalogService {
    List<MobileHandset> search(MobileHandset mobileHandset);
    List<MobileHandset> saveMobileHandsetsFromCatalog();
    List<MobileHandset> saveAll(Iterable<MobileHandset> iterables);
    List<MobileHandset> readMobileHandsetsFromCatalog();


}
