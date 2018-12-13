package com.iking.module.user.model.http;


import com.iking.module.user.model.TUser;

import java.io.Serializable;
import java.util.List;

/**
 * 新增账号信息
 *
 * @author tjw
 * @date 2018年8月10日 下午2:34:08
 */
public class HttpInsertUserReq extends TUser implements Serializable {

    private static final long serialVersionUID = 3794893973677422538L;

    private List<String> roles;// 角色集合

    public final List<String> getRoles() {
        return roles;
    }

    public final void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
