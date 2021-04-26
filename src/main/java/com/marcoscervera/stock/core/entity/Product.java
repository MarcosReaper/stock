package com.marcoscervera.stock.core.entity;

import java.util.Objects;

public class Product implements Comparable<Product>{
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

    public Product() {
    }

    public Product(Long id, Long sequence) {
        this.id = id;
        Sequence = sequence;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Sequence=" + Sequence +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if(this.getSequence() < o.getSequence()) return -1;
        else if(this.getSequence() > o.getSequence()) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
