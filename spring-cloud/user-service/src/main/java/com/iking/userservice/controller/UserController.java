package com.iking.userservice.controller;


import com.iking.module.model.Msg;
import com.iking.module.user.model.TUser;
import com.iking.module.user.model.http.HttpInsertUserReq;
import com.iking.module.user.model.http.HttpSelectUserInfoReq;
import com.iking.userservice.dao.TUserMapper;
import com.iking.userservice.service.TUserService;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * 账号管理
 *
 * @author tjw
 * @date 2018年8月10日 上午9:20:18
 */
@RestController
@RequestMapping("/user")
@Api(description ="账号管理")
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private TUserService userService;// 账号管理
    private TUserMapper tUserMapper;

    @Autowired
    public UserController(TUserService userService, TUserMapper tUserMapper) {
        this.userService = userService;
        this.tUserMapper = tUserMapper;
    }

    /**
     * 新增账号信息
     *
     * @param tUser
     * @param request
     * @return
     * @author tjw
     * @date 2018年8月10日 上午9:24:00
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    private Msg insert(@RequestBody HttpInsertUserReq tUser, HttpServletRequest request) throws NoSuchAlgorithmException{
        Msg msg = new Msg();
        // 新增信息非空验证
        if (tUser == null) {
            msg.setSuccess(false);
            msg.setMsg("新增账号信息不能为空!");
            return msg;
        }
        // 登录账号非空验证
        if (StringUtils.isBlank(tUser.getfAccount())) {
            msg.setSuccess(false);
            msg.setMsg("账号不能为空!");
            return msg;
        }
        // 密码非空验证
        if (StringUtils.isBlank(tUser.getfPassword())) {
            msg.setSuccess(false);
            msg.setMsg("密码不能为空!");
            return msg;
        }
        // 使用人非空验证
        if (StringUtils.isBlank(tUser.getfUserName())) {
            msg.setSuccess(false);
            msg.setMsg("使用人不能为空!");
            return msg;
        }
        // 角色集合非空验证
        if (tUser.getRoles() == null || tUser.getRoles().size() < 1) {
            msg.setSuccess(false);
            msg.setMsg("账号角色不能为空!");
            return msg;
        }
        // 部门id校验
        if (StringUtils.isBlank(tUser.getfDeptId())) {
            msg.setSuccess(false);
            msg.setMsg("所属部门不能为空!");
            return msg;
        }
        // 注册时间
        tUser.setfCreateTime(new Date());
        // 获取ip地址
        tUser.setfLastLoginIp(request.getRemoteAddr());
        // 最后一次登录时间
        tUser.setfLastLoginTime(new Date());
        // 执行注册
        //账号去空格
        tUser.setfAccount(tUser.getfAccount().replaceAll(" ",""));
        tUser.setfPassword(tUser.getfPassword().replaceAll(" ",""));

        msg = userService.insert(tUser);

        log.info("新增账号: 新增信息=" + tUser.toString());
        return msg;
    }


    /**
     * 功能描述: 根据条件分页查询账户信息
     *
     * @param:
     * @return:
     * @auther: tjw
     * @date: 2018/8/13 18:00
     */
    @PostMapping("/selectbypage")
    public Msg selectByPage(@RequestBody HttpSelectUserInfoReq req) {
        Msg msg = new Msg();
        try {
            // 查询条件非空验证
            if (req == null) {
                msg.setSuccess(false);
                msg.setMsg("查询条件不能为空!");
                return msg;
            }
            // 当前页非空验证
            if (req.getCurrentPage() == null) {
                msg.setSuccess(false);
                msg.setMsg("当前页不能为空!");
                return msg;
            }
            // 分页大小非空验证
            if (req.getPageSize() == null) {
                msg.setSuccess(false);
                msg.setMsg("分页大小不能为空!");
                return msg;
            }
            // 部门id为空时
            if (StringUtils.isBlank(req.getfDeptId())) {
                req.setfDeptId(null);
            }
            // 账号为空时
            if (StringUtils.isBlank(req.getfAccount())) {
                req.setfAccount(null);
            }
            // 用户名为空时
            if (StringUtils.isBlank(req.getfUserName())) {
                req.setfUserName(null);
            }
            // 当前页为0时
            if (req.getCurrentPage() == 0) {
                req.setCurrentPage(1);
            }
            // 分页大小为0时
            if (req.getPageSize() == 0) {
                req.setPageSize(10);
            }
            // 执行查询
            msg = userService.selectByPage(req);
        } catch (Exception e) {
            msg.setSuccess(false);
            msg.setMsg("根据条件分页查询账户信息异常!");
            log.error("根据条件分页查询账户信息异常: 查询条件=" + req.toString() + "异常信息:" + e);
            return msg;
        }
        return msg;
    }

    /**
     * 功能描述:查询全部用户信息
     *
     * @param:
     * @return:
     * @auther: tjw
     * @date: 2018/8/15 15:24
     */
    @GetMapping("/selectall")
    public Msg selectAll() {
        Msg msg = new Msg();
        try {
            msg = userService.selectAll();
        } catch (Exception e) {
            msg.setSuccess(false);
            msg.setMsg("查询全部用户信息效验异常!");
            log.error("查询全部用户信息效验异常:异常信息:" + e);
            return msg;
        }
        return msg;
    }

    /**
     * 根据id查询用户是否存在
     * @param:
     * @return:
     * @auther: tjw
     * @date: 2018/12/5 10:11
     */
    @GetMapping("/selectbyid/{fId}")
    public TUser selectById(@PathVariable String fId) {
        System.out.println();
        return tUserMapper.selectByPrimaryKey(fId);
    }
}
