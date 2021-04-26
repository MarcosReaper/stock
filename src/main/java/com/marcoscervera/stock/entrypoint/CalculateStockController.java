package com.marcoscervera.stock.entrypoint;

import com.marcoscervera.stock.core.entity.Product;
import com.marcoscervera.stock.core.usecase.CalculateStock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculateStockController {
    private CalculateStock calculateStock;

    public CalculateStockController(CalculateStock calculateStock) {
        this.calculateStock = calculateStock;
    }

    @GetMapping("stock/products/available")
    public List<Product> getProductsWithStock(){
        return calculateStock.execute();
    }
}
