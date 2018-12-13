package com.iking.module.feignclient.user;

import com.iking.module.model.Msg;
import com.iking.module.user.model.TUser;
import com.iking.module.user.model.http.HttpInsertUserReq;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/****
 * 用户feignClient
 * @author tjw
 * @versuion 1.0
 * @date 2018/11/8 11:27
 */
@Component
@FeignClient(name = "user-service")
public interface UserFeignClient {
    @HystrixCommand()
    @RequestMapping(method = RequestMethod.GET, value = "/user/selectbyid/{fId}")
    public TUser selectById(@PathVariable("fId") String fId);
    @RequestMapping(method = RequestMethod.POST, value = "/user/insert")
    public Msg insert(@RequestBody HttpInsertUserReq tUser);

}
