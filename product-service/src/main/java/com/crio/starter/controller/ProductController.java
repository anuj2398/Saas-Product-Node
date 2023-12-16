package com.crio.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crio.starter.service.ProductService;
import com.crio.starter.exchange.PriceUpdateRequest;


@RestController
public class ProductController {

  @Autowired
    private ProductService productService;

    @PostMapping("/process-price-update")
    public ResponseEntity<String> processPriceUpdate(@RequestBody PriceUpdateRequest priceUpdateRequest) {
        try {
            productService.processPriceUpdate(priceUpdateRequest);
            return ResponseEntity.ok("Price update processed successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing price update");
        }
    }

}
