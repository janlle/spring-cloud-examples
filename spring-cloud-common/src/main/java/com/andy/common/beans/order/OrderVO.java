package com.andy.common.beans.order;

import com.andy.common.beans.goods.GoodsVO;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * @author leone
 * @since 2019-01-22
 **/
public class OrderVO {

    private Long orderId;

    private Long userId;

    private Integer totalAmount;

    private String remark;

    private String tradeNo;

    private Date createTime;

    private Date payTime;

    private String userAccount;

    private Integer userAge;

    private String userDescription;

    private List<GoodsVO> goodsVOList;

    public List<GoodsVO> getGoodsVOList() {
        return goodsVOList;
    }

    public void setGoodsVOList(List<GoodsVO> goodsVOList) {
        this.goodsVOList = goodsVOList;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}
