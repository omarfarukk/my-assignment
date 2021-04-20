package com.assignment.demo.client;

import com.assignment.demo.data.domain.MobileHandset;

import java.util.List;

public interface IProductCatalogClient {
    List< MobileHandset > getMobileHandsetsFromCatalog();

}
