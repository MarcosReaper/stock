package com.marcoscervera.stock.core.repository;

import com.marcoscervera.stock.core.entity.Product;
import java.util.List;

public interface GetProductsRepository {
    List<Product> execute();
}
