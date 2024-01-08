package com.example.repository;

import com.example.entite.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Repository
public class ProductRepository {

    private final Map<Long, Product> productMap;

    public Product getProduct(Long productId){
        log.info("Getting Product from Product Repo With Product Id {}", productId);
        getMap();
        if(!productMap.containsKey(productId)){
            log.error("Product Not Found for Product Id {}", productId);
            throw new RuntimeException("Product Not Found");
        }
        return productMap.get(productId);
    }

    void getMap(){
        productMap.put(1L, new Product());
    }
}
