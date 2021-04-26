package com.marcoscervera.usecase;

import com.marcoscervera.stock.core.entity.Product;
import com.marcoscervera.stock.core.entity.Size;
import com.marcoscervera.stock.core.entity.Stock;
import com.marcoscervera.stock.core.repository.GetProductsRepository;
import com.marcoscervera.stock.core.repository.GetSizesRepository;
import com.marcoscervera.stock.core.repository.GetStocksRepository;
import com.marcoscervera.stock.core.usecase.CalculateStock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class CalculateStockTest {

    private CalculateStock calculateStock;
    private GetProductsRepository getProductsRepository;
    private GetSizesRepository getSizesRepository;
    private GetStocksRepository getStocksRepository;

    @BeforeEach
    public void init(){
        getProductsRepository = mock(GetProductsRepository.class);
        getSizesRepository = mock(GetSizesRepository.class);
        getStocksRepository = mock(GetStocksRepository.class);
        calculateStock = new CalculateStock(getProductsRepository, getSizesRepository, getStocksRepository);
    }

    @Test
    public void when_calculate_stock_and_return_products_ok(){
        //A
        List<Product> expected =  Arrays.asList(new Product(1L,10L));
        when(getProductsRepository.execute()).thenReturn(
                Arrays.asList(new Product(1L,10L), new Product(2L,20L)));
        when(getSizesRepository.execute()).thenReturn(Arrays.asList(new Size(1L,1L,false,false)));
        when(getStocksRepository.execute()).thenReturn(Arrays.asList(new Stock(1L,1L)));
        //A
        List<Product> result = calculateStock.execute();
        //A
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void when_calculate_stock_and_return_products_backsoon_ok(){
        //A
        List<Product> expected =  Arrays.asList(new Product(1L,10L));
        when(getProductsRepository.execute()).thenReturn(
                Arrays.asList(new Product(1L,10L), new Product(2L,20L)));
        when(getSizesRepository.execute()).thenReturn(Arrays.asList(new Size(1L,1L,true,false)));
        when(getStocksRepository.execute()).thenReturn(Arrays.asList(new Stock(1L,0L)));
        //A
        List<Product> result = calculateStock.execute();
        //A
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void when_calculate_stock_and_return_products_special_ok(){
        //A
        List<Product> expected =  Arrays.asList(new Product(1L,10L));
        when(getProductsRepository.execute()).thenReturn(
                Arrays.asList(new Product(1L,10L), new Product(2L,20L)));
        when(getSizesRepository.execute()).thenReturn(Arrays.asList(new Size(1L,1L,true,true),
                                                                    new Size(2L,1L,false,false)));
        when(getStocksRepository.execute()).thenReturn(Arrays.asList(new Stock(2L,10L)));
        //A
        List<Product> result = calculateStock.execute();
        //A
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void when_calculate_stock_and_products_special_without_stock(){
        //A
        when(getProductsRepository.execute()).thenReturn(
                Arrays.asList(new Product(1L,10L)));
        when(getSizesRepository.execute()).thenReturn(Arrays.asList(new Size(1L,1L,false,true),
                new Size(2L,1L,false,false)));
        when(getStocksRepository.execute()).thenReturn(Arrays.asList(new Stock(2L,10L),
                new Stock(1L,0L)));
        //A
        List<Product> result = calculateStock.execute();
        //A
        Assertions.assertTrue(result.isEmpty());

    }
}
