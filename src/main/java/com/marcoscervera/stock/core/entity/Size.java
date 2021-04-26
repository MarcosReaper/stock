package com.marcoscervera.stock.core.entity;

public class Size {
    private Long id;
    private Long productId;
    private Boolean backsoon;
    private Boolean special;

    public Long getId() {
        return id;
    }

    public Size(Long id, Long productId, Boolean backsoon, Boolean special) {
        this.id = id;
        this.productId = productId;
        this.backsoon = backsoon;
        this.special = special;
    }

    public Size() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Boolean getBacksoon() {
        return backsoon;
    }

    public void setBacksoon(Boolean backsoon) {
        this.backsoon = backsoon;
    }

    public Boolean getSpecial() {
        return special;
    }

    public void setSpecial(Boolean special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", productId=" + productId +
                ", backsoon=" + backsoon +
                ", special=" + special +
                '}';
    }
}
