package com.marcoscervera.stock.config;

import com.marcoscervera.stock.core.repository.GetProductsRepository;
import com.marcoscervera.stock.core.usecase.CalculateStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesModule {

    @Bean
    public CalculateStock newCalculateStock(GetProductsRepository getProductsRepository){
        return new CalculateStock(getProductsRepository);
    }
}
