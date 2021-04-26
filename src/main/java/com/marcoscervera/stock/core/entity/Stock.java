package com.marcoscervera.stock.core.entity;

public class Stock {
    private Long sizeId;
    private Long quantity;

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Stock(Long sizeId, Long quantity) {
        this.sizeId = sizeId;
        this.quantity = quantity;
    }

    public Stock() {
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "sizeId=" + sizeId +
                ", quantity=" + quantity +
                '}';
    }
}
