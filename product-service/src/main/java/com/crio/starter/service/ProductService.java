package com.crio.starter.service;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.starter.data.Products;
import com.crio.starter.exception.PriceCannotBeNegativeException;
import com.crio.starter.exception.ProductNotFoundException;
import com.crio.starter.exchange.PriceUpdateRequest;
import com.crio.starter.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void processPriceUpdate(PriceUpdateRequest priceUpdateRequest) {
        String productId = priceUpdateRequest.getProductId();
        BigDecimal  newPrice = priceUpdateRequest.getPrice();

        // to Validate if the product with the given ID exists
        if (productRepository.findById(productId).isEmpty()) {
            throw new ProductNotFoundException("Product not found with ID: " + productId);
        }
        if(newPrice.floatValue()<0){
            throw new PriceCannotBeNegativeException("Price cannot be negative ");
        }

        // to Perform business logic to update the price in the database
        Products existingProduct = productRepository.findById(productId).orElseThrow();
        existingProduct.setPrice(newPrice);
        productRepository.save(existingProduct);
}
}