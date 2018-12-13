package com.iking.module.user.model.http;

import java.io.Serializable;

/**
 *
 * 功能描述: 分页查询用户账号信息Model
 *
 * @auther: tjw
 * @date: 2018/8/13 17:57
 */
public class HttpSelectUserInfoReq implements Serializable {

    private static final long serialVersionUID = 2782348648317954480L;

    private Integer pageSize;//分页大小

    private Integer currentPage;//分页大小

    private String fDeptId;//用户组id

    private String fAccount;//账号

    private String fUserName;//用户名称

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getfAccount() {
        return fAccount;
    }

    public void setfAccount(String fAccount) {
        this.fAccount = fAccount;
    }

    public String getfUserName() {
        return fUserName;
    }

    public void setfUserName(String fUserName) {
        this.fUserName = fUserName;
    }

    public String getfDeptId() {
        return fDeptId;
    }

    public void setfDeptId(String fDeptId) {
        this.fDeptId = fDeptId;
    }

    @Override
    public String toString() {
        return "HttpSelectUserInfoReq" + "[" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", fDeptId=" + fDeptId +
                ", fAccount=" + fAccount +
                ", fUserName=" + fUserName +
                "]";
    }
}
