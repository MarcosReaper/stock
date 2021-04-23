package com.marcoscervera.stock.core.entity;

public class Product {
    private Long id;
    private Long Sequence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSequence() {
        return Sequence;
    }

    public void setSequence(Long sequence) {
        Sequence = sequence;
    }
}
