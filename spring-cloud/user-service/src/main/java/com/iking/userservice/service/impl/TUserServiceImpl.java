package com.iking.userservice.service.impl;


import com.codingapi.tx.annotation.TxTransaction;
import com.iking.module.model.Msg;
import com.iking.module.model.PageRes;
import com.iking.module.user.model.TUser;
import com.iking.module.user.model.http.HttpInsertUserReq;
import com.iking.module.user.model.http.HttpSelectUserInfoReq;
import com.iking.module.util.SysUtil;
import com.iking.userservice.dao.TUserMapper;
import com.iking.userservice.service.TUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * 账号管理
 *
 * @author tjw
 * @date 2018年8月10日 上午9:30:58
 */
@Service
public class TUserServiceImpl implements TUserService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TUserMapper tUserMapper;// 账号管理


    /**
     * 新增账号信息
     *
     * @param tUser
     * @return
     * @throws NoSuchAlgorithmException
     * @author tjw
     * @date 2018年8月10日 上午9:33:17
     */
    @Override
    @Transactional
    @TxTransaction
    public Msg insert(HttpInsertUserReq tUser) throws NoSuchAlgorithmException {
        Msg msg = new Msg();
            // 账号名重复验证
        if (tUserMapper.selectByLoginName(tUser.getfAccount()) != null) {
            msg.setSuccess(false);
            msg.setMsg("账号已存在!");
            return msg;
        }
        // 新增账号信息
        tUser.setfPassword(SysUtil.getMD5(tUser.getfPassword()));
        tUser.setfId(SysUtil.getUUID());
        tUser.setfState(1);
        tUserMapper.insertSelective(tUser);
        return Msg.sucess();
    }


    /**
     * 功能描述: 根据条件分页查询账户信息
     *
     * @param:
     * @return:
     * @auther: tjw
     * @date: 2018/8/13 18:09
     */
    @Override
    public Msg selectByPage(HttpSelectUserInfoReq req) {
        Msg msg = new Msg();
        PageRes<TUser> page = new PageRes();
        List<TUser> list = new ArrayList();
        page.setPageSize(req.getPageSize());
        page.setPageCurrent(req.getCurrentPage());
        try {

            // 符合条件的记录数查询
            int count = tUserMapper.selectNumByPage(req);
            if (count < 1) {
                msg.setMsg("未搜索到记录数!");
                page.setItems(list);
                msg.setObj(page);
                return msg;
            }
            page.setItemTotal(count);
            // 当前页验证
            if (page.getPageCurrent() <= 0 || page.getPageCurrent() > page.getPageCount()) {
                msg.setMsg("当前页不正确!");
                page.setItems(list);
                msg.setObj(page);
                return msg;
            }
            // 执行查询
            list = tUserMapper.selectByPage(req, page);
            page.setItems(list);
            msg.setObj(page);

        } catch (Exception e) {
            msg.setSuccess(false);
            msg.setMsg("根据条件分页查询账户信息异常!");
            log.error("根据条件分页查询账户信息异常:查询条件=" + req.toString() + "异常信息:" + e);
            return msg;
        }
        return msg;
    }

    /**
     * 功能描述: 查询全部用户信息
     *
     * @param:
     * @return:
     * @auther: tjw
     * @date: 2018/8/15 15:25
     */
    @Override
    public Msg selectAll() {
        Msg msg = new Msg();
        try {
            List<TUser> list = tUserMapper.selectAll();
            msg.setObj(list);

        } catch (Exception e) {
            msg.setSuccess(false);
            msg.setMsg("查询全部用户信息异常!");
            log.error("查询全部用户信息异常:异常信息:" + e);
            return msg;
        }
        return msg;
    }

}
