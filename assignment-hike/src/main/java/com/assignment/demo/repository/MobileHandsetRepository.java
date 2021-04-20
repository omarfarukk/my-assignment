package com.assignment.demo.repository;

import com.assignment.demo.data.domain.MobileHandset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileHandsetRepository extends MongoRepository<MobileHandset,Long> {
}
