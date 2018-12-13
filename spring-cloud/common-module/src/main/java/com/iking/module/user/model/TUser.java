package com.iking.module.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 功能描述: 用户信息
 * @auther: tjw
 * @date: 2018/8/10 17:26
 */
public class TUser implements Serializable {

    private static final long serialVersionUID = 1929453681820860568L;

    private String fId;//用户id

    private String fDeptId;//部门id

    private String fAccount;//账号

    private String fPassword;//密码

    private String fUserName;//用户名称

    private String fPhone;//电话

    private Integer fState;//状态 0:删除 1.可用 2.不可用（冻结）

    private Date fCreateTime;//创建时间

    private Date fLastLoginTime;//最后一次登录时间

    private String fLastLoginIp;//最近登陆ip

    public String getfDeptId() {
        return fDeptId;
    }

    public void setfDeptId(String fDeptId) {
        this.fDeptId = fDeptId;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId == null ? null : fId.trim();
    }

    public String getfAccount() {
        return fAccount;
    }

    public void setfAccount(String fAccount) {
        this.fAccount = fAccount == null ? null : fAccount.trim();
    }

    public String getfPassword() {
        return fPassword;
    }

    public void setfPassword(String fPassword) {
        this.fPassword = fPassword == null ? null : fPassword.trim();
    }

    public String getfUserName() {
        return fUserName;
    }

    public void setfUserName(String fUserName) {
        this.fUserName = fUserName == null ? null : fUserName.trim();
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone == null ? null : fPhone.trim();
    }

    public Integer getfState() {
        return fState;
    }

    public void setfState(Integer fState) {
        this.fState = fState;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Date getfLastLoginTime() {
        return fLastLoginTime;
    }

    public void setfLastLoginTime(Date fLastLoginTime) {
        this.fLastLoginTime = fLastLoginTime;
    }

    public String getfLastLoginIp() {
        return fLastLoginIp;
    }

    public void setfLastLoginIp(String fLastLoginIp) {
        this.fLastLoginIp = fLastLoginIp == null ? null : fLastLoginIp.trim();
    }
}