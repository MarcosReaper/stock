package com.marcoscervera.stock.core.usecase;

import com.marcoscervera.stock.core.entity.Product;
import com.marcoscervera.stock.core.repository.GetProductsRepository;

import java.util.List;

public class CalculateStock {
    private GetProductsRepository getProductsRepository;

    public CalculateStock(GetProductsRepository getProductsRepository) {
        this.getProductsRepository = getProductsRepository;
    }

    public void execute(){
        List<Product> products = getProductsRepository.execute();
        products.forEach(p-> System.out.println(p.getId() + " - " + p.getSequence()));
    }
}
