package com.marcoscervera.stock.core.usecase;

import com.marcoscervera.stock.core.entity.Product;
import com.marcoscervera.stock.core.entity.Size;
import com.marcoscervera.stock.core.entity.Stock;
import com.marcoscervera.stock.core.repository.GetProductsRepository;
import com.marcoscervera.stock.core.repository.GetSizesRepository;
import com.marcoscervera.stock.core.repository.GetStocksRepository;

import java.util.List;

public class CalculateStock {
    private GetProductsRepository getProductsRepository;
    private GetSizesRepository getSizesRepository;
    private GetStocksRepository getStocksRepository;

    public CalculateStock(final GetProductsRepository getProductsRepository,
                          final GetSizesRepository getSizesRepository,
                          final GetStocksRepository getStocksRepository) {
        this.getProductsRepository = getProductsRepository;
        this.getSizesRepository = getSizesRepository;
        this.getStocksRepository = getStocksRepository;
    }

    public void execute(){
        List<Product> products = getProductsRepository.execute();
        List<Size> sizes = getSizesRepository.execute();
        List<Stock> stocks = getStocksRepository.execute();
        products.forEach(p-> System.out.println(p.toString()));
        sizes.forEach(s-> System.out.println(s.toString()));
        stocks.forEach(s -> System.out.println(s.toString()));
        
    }
}
