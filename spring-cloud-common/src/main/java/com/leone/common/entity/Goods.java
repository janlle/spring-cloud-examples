package com.leone.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * @author leone
 * @since 2019-01-22
 **/
public class Goods implements Serializable {

    private Long goodsId;

    private String name;

    private Integer price;

    private String picture;

    private Integer stock;

    private Date createTime;

    private Boolean deleted;

    public Goods() {
    }

    public Goods(Long goodsId, String name, Integer price, String picture, Integer stock, Date createTime, Boolean deleted) {
        this.goodsId = goodsId;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.stock = stock;
        this.createTime = createTime;
        this.deleted = deleted;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
