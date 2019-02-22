package com.andy.common.beans.goods;

import java.util.Date;

/**
 * <p>
 *
 * @author leone
 * @since 2019-02-22
 **/
public class GoodsVO {

    private Long goodsId;

    private String name;

    private Integer price;

    private String picture;

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

}
