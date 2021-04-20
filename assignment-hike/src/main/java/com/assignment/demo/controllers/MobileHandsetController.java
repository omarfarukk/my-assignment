package com.assignment.demo.controllers;

import com.assignment.demo.data.domain.MobileHandset;
import com.assignment.demo.service.IProductCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("mobile")
public class MobileHandsetController {
    private final IProductCatalogService productCatalogService;

    @GetMapping("search")
    public List<MobileHandset> searchMobileHandsets(MobileHandset mobileHandset){
        return productCatalogService.search(mobileHandset);
    }

}
