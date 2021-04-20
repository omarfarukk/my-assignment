package com.assignment.demo.listeners;

import com.assignment.demo.repository.MobileHandsetRepository;
import com.assignment.demo.service.IProductCatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class HikeApplicationListener {

    private final IProductCatalogService productCatalogService;

    @EventListener(ApplicationReadyEvent.class)
    public void handleEvent(ApplicationReadyEvent event){
        productCatalogService.saveMobileHandsetsFromCatalog();
        log.info("Data got successfully inserted");
    }
}
