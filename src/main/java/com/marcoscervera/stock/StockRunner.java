package com.marcoscervera.stock;

import com.marcoscervera.stock.core.usecase.CalculateStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockRunner implements CommandLineRunner {

    @Autowired
    private CalculateStock calculateStock;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-- start up stock calculate --");
        calculateStock.execute();
        System.out.println("-- end stock calculate --");
    }
}
