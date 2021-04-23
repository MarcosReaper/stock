package com.marcoscervera.stock.core.repository;

import com.marcoscervera.stock.core.entity.Stock;

import java.util.List;

public interface GetStocksRepository {
    List<Stock> execute();
}
