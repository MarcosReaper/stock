package com.marcoscervera.stock.repository.commons;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvMap<T> {
    private final Class<T> type;

    public CsvMap(Class<T> type) {
        this.type = type;
    }

    protected List<T> parse(String path) throws IOException {
        CsvSchema productSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<T> items =  new CsvMapper().readerFor(type)
                .with(productSchema)
                .readValues(new File(path));
        return items.readAll();
    }
}
