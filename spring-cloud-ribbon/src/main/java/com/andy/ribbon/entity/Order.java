package com.andy.ribbon.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author Leone
 * @since 2018-06-21
 **/
@Data
@ApiModel("订单模型")
public class Order {

    private String orderId;

    private String userId;

    private Integer totalFee;

    private String remark;

    private String outTradeNum;

    private Date createTime;

    private Date closeTime;

    private Date payTime;

}
