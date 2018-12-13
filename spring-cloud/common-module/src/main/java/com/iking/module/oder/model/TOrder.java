package com.iking.module.oder.model;

import java.util.Date;

public class TOrder {
    private String fId;

    private String fOrderUserId;

    private String fConcatUser;

    private Date fPhone;

    private String fAddress;

    private String fCreateTime;

    private Double fSumPrice;

    private Boolean fIsDelete;

    private Integer fState;

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId == null ? null : fId.trim();
    }

    public String getfOrderUserId() {
        return fOrderUserId;
    }

    public void setfOrderUserId(String fOrderUserId) {
        this.fOrderUserId = fOrderUserId == null ? null : fOrderUserId.trim();
    }

    public String getfConcatUser() {
        return fConcatUser;
    }

    public void setfConcatUser(String fConcatUser) {
        this.fConcatUser = fConcatUser == null ? null : fConcatUser.trim();
    }

    public Date getfPhone() {
        return fPhone;
    }

    public void setfPhone(Date fPhone) {
        this.fPhone = fPhone;
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress == null ? null : fAddress.trim();
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime == null ? null : fCreateTime.trim();
    }

    public Double getfSumPrice() {
        return fSumPrice;
    }

    public void setfSumPrice(Double fSumPrice) {
        this.fSumPrice = fSumPrice;
    }

    public Boolean getfIsDelete() {
        return fIsDelete;
    }

    public void setfIsDelete(Boolean fIsDelete) {
        this.fIsDelete = fIsDelete;
    }

    public Integer getfState() {
        return fState;
    }

    public void setfState(Integer fState) {
        this.fState = fState;
    }
}