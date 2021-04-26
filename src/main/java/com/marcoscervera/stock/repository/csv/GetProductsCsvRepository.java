package com.marcoscervera.stock.repository.csv;

import com.marcoscervera.stock.core.entity.Product;
import com.marcoscervera.stock.core.exception.RepositoryException;
import com.marcoscervera.stock.core.repository.GetProductsRepository;
import com.marcoscervera.stock.repository.commons.CsvMap;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GetProductsCsvRepository extends CsvMap<Product> implements GetProductsRepository {

    public GetProductsCsvRepository() {
        super(Product.class);
    }

    @Override
    public List<Product> execute() {
        try {
            return parse("src/main/resources/csv/product.csv");
        } catch (IOException e) {
            throw new RepositoryException("error trying to get products from csv. ",e);
        }
    }
}
