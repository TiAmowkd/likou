package com.ballot.rigging.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: wkd
 * @Date: 2020/1/8 11:13
 * @Description:
 */
@Data
public class ProductSend {

    private String productId;
    private String productName;
    private Date createTime;
    private Date updateTime;

}
