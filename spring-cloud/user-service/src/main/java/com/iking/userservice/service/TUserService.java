package com.iking.userservice.service;



import com.iking.module.model.Msg;
import com.iking.module.user.model.http.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * 账号管理
 *
 * @author tjw
 * @ClassName: TUserService
 * @date 2018年3月5日 下午4:15:53
 */
 public interface TUserService {

	/**
	 * 新增账号信息
	 *
	 * @param tUser
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @Title: insert
	 * @author tjw
	 * @date 2018年3月5日 下午4:16:16
	 */
	 Msg insert(HttpInsertUserReq tUser) throws NoSuchAlgorithmException;

	/**
	 *
	 * 功能描述: 根据条件分页查询账户信息
	 *
	 * @param:
	 * @return:
	 * @auther: tjw
	 * @date: 2018/8/13 18:08
	 */
	 Msg selectByPage(HttpSelectUserInfoReq req);
	/**
	 *
	 * 功能描述:查询全部用户信息
	 *
	 * @param:
	 * @return:
	 * @auther: tjw
	 * @date: 2018/8/15 15:24
	 */
	 Msg selectAll();
}
