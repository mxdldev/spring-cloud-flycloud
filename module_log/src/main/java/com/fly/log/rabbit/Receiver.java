package com.fly.log.rabbit;

import com.alibaba.fastjson.JSON;
import com.fly.log.entity.SysLog;
import com.fly.log.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Description: <Receiver><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    SysLogService sysLogService;
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        SysLog sysLog=  JSON.parseObject(message,SysLog.class);
        sysLogService.saveLogger(sysLog);
        latch.countDown();
    }


}