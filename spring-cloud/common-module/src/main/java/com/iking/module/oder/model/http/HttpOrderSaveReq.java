package com.iking.module.oder.model.http;

import com.iking.module.oder.model.TOrder;

import java.io.Serializable;

/****
 *
 * @author tjw
 * @versuion 1.0
 * @date 2018/12/5 12:31
 */
public class HttpOrderSaveReq extends TOrder implements Serializable {
    private static final long serialVersionUID = -2330851072302867833L;
    private String fOrderId;// 订单id

    private String fGoodsId;// 商品id

    private Integer fBuyCount;// 购买数量

    private Double fBuyPrice;// 购买单价

    public String getfOrderId() {
        return fOrderId;
    }

    public void setfOrderId(String fOrderId) {
        this.fOrderId = fOrderId;
    }

    public String getfGoodsId() {
        return fGoodsId;
    }

    public void setfGoodsId(String fGoodsId) {
        this.fGoodsId = fGoodsId;
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

    @Override
    public String toString() {
        return "HttpOrderSaveReq" + "[" +
                "fOrderId=" + fOrderId +
                ", fGoodsId=" + fGoodsId +
                ", fBuyCount=" + fBuyCount +
                ", fBuyPrice=" + fBuyPrice +
                "]";
    }
}

