package com.assignment.demo.service.impl;

import com.assignment.demo.client.IProductCatalogClient;
import com.assignment.demo.data.domain.MobileHandset;
import com.assignment.demo.repository.MobileHandsetRepository;
import com.assignment.demo.service.IProductCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ProductCatalogServiceImpl implements IProductCatalogService {

    private final MobileHandsetRepository mobileHandsetRepository;
    private final IProductCatalogClient productCatalogClient;
    private final MobileHandset emptyObject = new MobileHandset();
    private final ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

    @Override
    public List<MobileHandset> saveMobileHandsetsFromCatalog(){
        return mobileHandsetRepository.saveAll(readMobileHandsetsFromCatalog());
    }

    @Override
    public List<MobileHandset> saveAll(Iterable<MobileHandset> iterables){
        return mobileHandsetRepository.saveAll(iterables);
    }
    @Override
    public List<MobileHandset> readMobileHandsetsFromCatalog(){
        return productCatalogClient.getMobileHandsetsFromCatalog();
    }


    @Override
    public List<MobileHandset> search(MobileHandset mobileHandset){
        return Objects.isNull(mobileHandset) ?
                Collections.emptyList() :
                mobileHandsetRepository.findAll(Example.of(mobileHandset,exampleMatcher));
    }

}
