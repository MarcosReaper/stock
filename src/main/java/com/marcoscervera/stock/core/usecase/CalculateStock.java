package com.marcoscervera.stock.core.usecase;

import com.marcoscervera.stock.core.entity.Product;
import com.marcoscervera.stock.core.entity.Size;
import com.marcoscervera.stock.core.entity.Stock;
import com.marcoscervera.stock.core.repository.GetProductsRepository;
import com.marcoscervera.stock.core.repository.GetSizesRepository;
import com.marcoscervera.stock.core.repository.GetStocksRepository;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<Product> execute(){
        List<Size> sizes = getSizesRepository.execute();
        List<Stock> stocks = getStocksRepository.execute();
        SortedSet<Product> orderedProducts = new TreeSet<>(getProductsRepository.execute());
        return getProductsWithStock(orderedProducts,sizes,stocks);
    }

    private List<Product> getProductsWithStock(SortedSet<Product> orderedProducts, List<Size> sizes, List<Stock> stocks){
        List<Product> productsWithStock = new ArrayList<>();
        orderedProducts.forEach(p -> {
            Set<Size> filteredSizes = sizes.stream().filter(s-> s.getProductId().equals(p.getId())).collect(Collectors.toSet());
            if(calculate(filteredSizes, stocks)) {
                System.out.println(" " + p.getId());
                productsWithStock.add(p);
            }
        });
        return productsWithStock;
    }

    private boolean calculate(Set<Size> sizes, List<Stock> stocks){
        boolean hasSpecial = sizes.stream().anyMatch(size -> size.getSpecial());
        boolean anySpecialHasStockOrBackSoon = false;
        boolean anyNoSpecialHasStockOrBackSoon = false;
        for(Size size: sizes){
            boolean hasStockOrBackSoon = size.getBacksoon()
                    || stocks.stream()
                            .anyMatch(stock -> stock.getSizeId().equals(size.getId()) && stock.getQuantity() > 0L);
            if(hasStockOrBackSoon){
                if(hasSpecial && size.getSpecial()){
                    anySpecialHasStockOrBackSoon = true;
                }else if(!size.getSpecial()){
                    anyNoSpecialHasStockOrBackSoon = true;
                }
            }
        }
        return (hasSpecial && anySpecialHasStockOrBackSoon && anyNoSpecialHasStockOrBackSoon)
                || (!hasSpecial && anyNoSpecialHasStockOrBackSoon);
    }

}
