package com.iking.order.service;

import ch.qos.logback.classic.Logger;
import com.iking.module.feignclient.user.UserFeignClient;
import com.iking.module.model.Msg;
import com.iking.module.oder.model.TOrder;
import com.iking.module.oder.model.TOrderDetail;
import com.iking.module.oder.model.http.HttpOrderSaveReq;
import com.iking.module.user.model.TUser;
import com.iking.module.util.SysUtil;
import com.iking.order.dao.TOrderDetailMapper;
import com.iking.order.dao.TOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/****
 *
 * @author tjw
 * @versuion 1.0
 * @date 2018/11/8 10:52
 */

public interface OrderService {

    /**
     * 新增订单
     * @param:
     * @return:
     * @auther: tjw
     * @date: 2018/12/5 12:35
     */
    Msg insert(HttpOrderSaveReq req);
}
