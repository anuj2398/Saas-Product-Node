package com.crio.starter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crio.starter.data.Products;

public interface ProductRepository extends MongoRepository<Products, String> {
}
