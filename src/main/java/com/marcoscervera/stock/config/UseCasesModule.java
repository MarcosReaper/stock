package com.marcoscervera.stock.config;

import com.marcoscervera.stock.core.repository.GetProductsRepository;
import com.marcoscervera.stock.core.repository.GetSizesRepository;
import com.marcoscervera.stock.core.repository.GetStocksRepository;
import com.marcoscervera.stock.core.usecase.CalculateStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesModule {

    @Bean
    public CalculateStock newCalculateStock(final GetProductsRepository getProductsRepository,
                                            final GetSizesRepository getSizesRepository,
                                            final GetStocksRepository getStocksRepository){
        return new CalculateStock(getProductsRepository, getSizesRepository, getStocksRepository);
    }
}
