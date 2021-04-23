package com.marcoscervera.stock.repository;

import com.marcoscervera.stock.core.entity.Product;
import com.marcoscervera.stock.core.repository.GetProductsRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetProductsCsvRepository implements GetProductsRepository {

    @Override
    public List<Product> execute() {
        return null;
    }
}
