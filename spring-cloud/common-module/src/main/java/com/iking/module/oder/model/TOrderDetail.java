package com.iking.module.oder.model;

import java.util.Date;
/**
 * 订单详情
 * @auther: tjw
 * @date: 2018/12/5 12:33
 */
public class TOrderDetail {
    private String fId;

    private String fOrderId;// 订单id

    private String fGoodsId;// 商品id

    private Integer fBuyCount;// 购买数量

    private Double fBuyPrice;// 购买单价

    private Double fSumPrice;// 总价

    private Date fCreateTime;// 创建时间

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId == null ? null : fId.trim();
    }

    public String getfOrderId() {
        return fOrderId;
    }

    public void setfOrderId(String fOrderId) {
        this.fOrderId = fOrderId == null ? null : fOrderId.trim();
    }

    public String getfGoodsId() {
        return fGoodsId;
    }

    public void setfGoodsId(String fGoodsId) {
        this.fGoodsId = fGoodsId == null ? null : fGoodsId.trim();
    }

    public Integer getfBuyCount() {
        return fBuyCount;
    }

    public void setfBuyCount(Integer fBuyCount) {
        this.fBuyCount = fBuyCount;
    }

    public Double getfBuyPrice() {
        return fBuyPrice;
    }

    public void setfBuyPrice(Double fBuyPrice) {
        this.fBuyPrice = fBuyPrice;
    }

    public Double getfSumPrice() {
        return fSumPrice;
    }

    public void setfSumPrice(Double fSumPrice) {
        this.fSumPrice = fSumPrice;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }
}