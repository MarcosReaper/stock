package com.marcoscervera.stock.entrypoint;

import com.marcoscervera.stock.core.entity.Product;
import com.marcoscervera.stock.core.usecase.CalculateStock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CalculateStockController {
    private CalculateStock calculateStock;

    public CalculateStockController(CalculateStock calculateStock) {
        this.calculateStock = calculateStock;
    }

    @GetMapping("stock/products/available")
    public List<Long> getProductsWithStock(){
        return calculateStock.execute().stream().map(p -> p.getId()).collect(Collectors.toList());
    }
}
