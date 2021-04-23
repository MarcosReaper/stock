package com.marcoscervera.stock.core.repository;

import com.marcoscervera.stock.core.entity.Size;

import java.util.List;

public interface GetSizesRepository {
    List<Size> execute();
}
