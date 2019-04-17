package com.iking.order.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.iking.module.feignclient.user.UserFeignClient;
import com.iking.module.model.Msg;
import com.iking.module.oder.model.TOrderDetail;
import com.iking.module.oder.model.http.HttpOrderSaveReq;
import com.iking.module.user.model.TUser;
import com.iking.module.user.model.http.HttpInsertUserReq;
import com.iking.module.util.SysUtil;
import com.iking.order.dao.TOrderDetailMapper;
import com.iking.order.dao.TOrderMapper;
import com.iking.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/****
 *
 * @author tjw
 * @versuion 1.0
 * @date 2018/11/8 10:52
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserFeignClient userFeignClient;
    @Autowired
    private TOrderMapper orderMapper;// 订单管理
    @Autowired
    private TOrderDetailMapper orderDetailMapper;// 订单详情管理
    /**
     * 新增订单
     * @param:
     * @return:
     * @auther: tjw
     * @date: 2018/12/5 12:35
     */
    @Override
    @TxTransaction(isStart = true)
    @Transactional(rollbackFor = Exception.class)
//    @HystrixCommand(fallbackMethod = "insertFallback")
    public Msg insert(HttpOrderSaveReq req){
        req.setfId(SysUtil.getUUID());
        // 查询下单人id是否存在
        TUser tUser = userFeignClient.selectById(req.getfOrderUserId());

        // 如果不存在 则新增人员账号
        if (tUser == null) {
            HttpInsertUserReq user = new HttpInsertUserReq();
            user.setfId(SysUtil.getUUID());
            user.setfAccount("test");
            user.setfPassword("000000");
            user.setfCreateTime(new Date());
            user.setfDeptId("6b3dfa778e144bf68ba9f1a4a6e6ad71");
            user.setfPhone("10086");
            user.setfUserName("xxxx");
            user.setfState(1);
            user.setfLastLoginIp("ip");
            // 角色

            List<String> roles = new ArrayList<>();
            roles.add("8d650b4698d950508f0d21eff85570df");
            user.setRoles(roles);
            Msg insert = userFeignClient.insert(user);
            if (!insert.isSuccess()) {
//                   TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return insert;
            }
        }
        TOrderDetail detail = new TOrderDetail();
        detail.setfId(SysUtil.getUUID());
        detail.setfOrderId(req.getfId());
        detail.setfCreateTime(new Date());
        detail.setfBuyPrice(req.getfBuyPrice());
        detail.setfBuyCount(req.getfBuyCount());
        detail.setfSumPrice(req.getfBuyPrice()*req.getfBuyCount());
        detail.setfGoodsId(req.getfGoodsId());
        // 新增订单详情
        orderDetailMapper.insert(detail);
        int a = 9/0;
        // 新增订单
        req.setfSumPrice(detail.getfSumPrice());
        orderMapper.insert(req);
        return Msg.sucess();
    }
    public Msg insertFallback(HttpOrderSaveReq req){
        return Msg.fail("微服务调用失败!");
    }
}
