package com.csu.service;

import com.csu.exception.ProductionNotFoundException;
import com.csu.model.Production;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductionService {

    private static final Map<String, Production> PRODUCTION_MAP = new ConcurrentHashMap<>();

    static {
        Production production1 = new Production("production1");
        Production production2 = new Production("production2");
        Production production3 = new Production("production3");
        PRODUCTION_MAP.put(production1.getCode(), production1);
        PRODUCTION_MAP.put(production2.getCode(), production2);
        PRODUCTION_MAP.put(production3.getCode(), production3);
    }

    public Collection<Production> getAllProductions() {
        return PRODUCTION_MAP.values();
    }

    public Production getProductionByCode(String code) {
        return Optional.ofNullable(PRODUCTION_MAP.get(code)).orElseThrow(() -> new ProductionNotFoundException(code));
    }
}
