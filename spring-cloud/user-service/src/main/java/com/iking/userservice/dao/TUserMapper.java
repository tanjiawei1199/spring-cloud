package com.iking.userservice.dao;


import com.iking.module.model.PageRes;
import com.iking.module.user.model.TUser;
import com.iking.module.user.model.http.HttpSelectUserInfoReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述: 用户信息管理
 *
 * @auther: tjw
 * @date: 2018/8/10 17:34
 */
@Mapper
public interface TUserMapper {
	int deleteByPrimaryKey(String fId);

	int insert(TUser record);

	int insertSelective(TUser record);

	TUser selectByPrimaryKey(String fId);

	int updateByPrimaryKeySelective(TUser record);

	int updateByPrimaryKey(TUser record);

	/**
	 * 功能描述: 根据登录账号查询账号信息
	 *
	 * @param:
	 * @return:
	 * @auther: tjw
	 * @date: 2018/8/10 18:06
	 */
	TUser selectByLoginName(String fAccount);

	/**
	 * 功能描述: 查询符合条件的账号数量
	 *
	 * @param:
	 * @return:
	 * @auther: tjw
	 * @date: 2018/8/13 18:20
	 */
	int selectNumByPage(@Param("req") HttpSelectUserInfoReq req);

	/**
	 * 功能描述:分页查询符合条件的账号信息
	 *
	 * @param:
	 * @return:
	 * @auther: tjw
	 * @date: 2018/8/13 18:29
	 */
	List<TUser> selectByPage(@Param("req") HttpSelectUserInfoReq req, @Param("page") PageRes<TUser> page);

	/**
	 *
	 * 功能描述: 查询全部用户信息
	 *
	 * @param:
	 * @return:
	 * @auther: tjw
	 * @date: 2018/8/15 15:26
	 */
	List<TUser> selectAll();
    /**
     * 根据部门id查询部门下的人员
     * @param:
     * @return:
     * @auther: tjw
     * @date: 2018/11/7 11:12
     */
    List<TUser> selectByDeptId(@Param("fDeptId") String fDeptId);
}