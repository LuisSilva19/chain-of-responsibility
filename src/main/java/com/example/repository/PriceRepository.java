package com.example.repository;

import com.example.entite.Price;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PriceRepository {
    private final Map<Long, Price> priceMap;

    public Price getPrice(Long productId){
        log.info("Getting Price from Price Repo With Product Id {}", productId);
        getMap();
        if(!priceMap.containsKey(productId)){
            log.error("Price Not Found for Product Id {}", productId);
            throw new RuntimeException();
        }
        return priceMap.get(productId);
    }

    Map<Long, Price> getMap(){
        priceMap.put(1L, new Price());
        return priceMap;
    }
}
