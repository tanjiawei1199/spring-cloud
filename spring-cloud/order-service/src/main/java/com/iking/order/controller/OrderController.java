package com.iking.order.controller;

import com.iking.module.feignclient.user.UserFeignClient;
import com.iking.module.model.Msg;
import com.iking.module.oder.model.http.HttpOrderSaveReq;
import com.iking.module.user.model.TUser;
import com.iking.module.util.SysUtil;
import com.iking.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rx.Observable;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/****
 * 订单管理
 * @author tjw
 * @versuion 1.0
 * @date 2018/11/7 18:58
 */
@Api(description = "订单管理")
@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    /**
     * 新增订单
     * @param:
     * @return:
     * @auther: tjw
     * @date: 2018/12/5 18:36
     */


    @PostMapping("/insert")
    public Msg insert(@RequestBody HttpOrderSaveReq req){
        try {
            // 打印负载均衡当前选择的节点
            ServiceInstance serviceInstance = this.loadBalancerClient.choose("user-service");
            log.info("======================================>{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
            return orderService.insert(req);
        }catch (Exception e){
            log.error("新增订单异常!异常信息:" + e);
            return Msg.fail("新增订单异常!");
        }

    }

}
