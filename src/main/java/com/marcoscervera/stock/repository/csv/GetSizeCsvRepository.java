package com.marcoscervera.stock.repository.csv;

import com.marcoscervera.stock.core.entity.Size;
import com.marcoscervera.stock.core.exception.RepositoryException;
import com.marcoscervera.stock.core.repository.GetSizesRepository;
import com.marcoscervera.stock.repository.commons.CsvMap;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GetSizeCsvRepository extends CsvMap<Size> implements GetSizesRepository {
    public GetSizeCsvRepository() {
        super(Size.class);
    }

    @Override
    public List<Size> execute() {
        try {
            return parse("src/main/resources/csv/size.csv");
        } catch (IOException e) {
            throw new RepositoryException("error trying to get sizes from csv. ",e);
        }
    }
}
