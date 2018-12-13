package com.iking.module.enums;

/****
 * 订单状态
 * @author tjw
 * @versuion 1.0
 * @date 2018/12/5 15:58
 */
public enum OrderStatus {

    /**
     * Not pay order status enum.
     */
    NOT_PAY(1, "未支付"),

    /**
     * Paying order status enum.
     */
    PAYING(2, "支付中"),

    /**
     * Pay fail order status enum.
     */
    PAY_FAIL(3, "支付失败"),
    /**
     * Pay success order status enum.
     */
    PAY_SUCCESS(4, "支付成功");

    private Integer code;
    private String desc;

    OrderStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
