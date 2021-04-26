package com.marcoscervera.stock.repository.csv;

import com.marcoscervera.stock.core.entity.Stock;
import com.marcoscervera.stock.core.exception.RepositoryException;
import com.marcoscervera.stock.core.repository.GetStocksRepository;
import com.marcoscervera.stock.repository.commons.CsvMap;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GetStockCsvRepository extends CsvMap<Stock> implements GetStocksRepository {

    public GetStockCsvRepository() {
        super(Stock.class);
    }

    @Override
    public List<Stock> execute() {
        try {
            return parse("src/main/resources/csv/stock.csv");
        } catch (IOException e) {
            throw new RepositoryException("error trying to get Stocks from csv. ",e);
        }
    }
}
