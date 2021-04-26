package com.marcoscervera.stock.core.entity;

public class Stock implements Comparable<Long>{
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

    @Override
    public int compareTo(Long sizeId) {
        if(this.getSizeId() < sizeId) return -1;
        else if(this.getSizeId() > sizeId) return 1;
        return 0;
    }
}
