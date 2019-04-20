package com.leone.common.entity;

import java.util.Date;

/**
 * <p>
 *
 * @author leone
 * @since 2019-02-22
 **/
public class OrderItem {

    private Long orderItemId;

    private Long goodsId;

    private Long orderId;

    private String goodsName;

    private Integer goodsPrice;

    private String goodsPicture;

    private Integer goodsCount;

    private Date createTime;

    public OrderItem() {
    }

    public OrderItem(Long orderItemId, Long goodsId, Long orderId, String goodsName, Integer goodsPrice, String goodsPicture, Integer goodsCount, Date createTime) {
        this.orderItemId = orderItemId;
        this.goodsId = goodsId;
        this.orderId = orderId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsPicture = goodsPicture;
        this.goodsCount = goodsCount;
        this.createTime = createTime;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
