package com.marcoscervera.stock.repository;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.marcoscervera.stock.core.entity.Product;
import com.marcoscervera.stock.core.exception.RepositoryException;
import com.marcoscervera.stock.core.repository.GetProductsRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class GetProductsCsvRepository implements GetProductsRepository {

    @Override
    public List<Product> execute() {
        CsvSchema productSchema = CsvSchema.emptySchema().withHeader();
        try {
            MappingIterator<Product> products = new CsvMapper().readerFor(Product.class)
                    .with(productSchema)
                    .readValues(new File("src/main/resources/csv/product.csv"));
            return products.readAll();
        } catch (IOException e) {
            throw new RepositoryException("error trying to get products from csv. ",e);
        }
    }
}
