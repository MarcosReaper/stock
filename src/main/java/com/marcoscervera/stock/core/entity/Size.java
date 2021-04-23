package com.marcoscervera.stock.core.entity;

public class Size {
    private Long id;
    private Long productId;
    private Boolean backsoon;
    private Boolean special;

    public Long getId() {
        return id;
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
}
