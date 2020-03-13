package com.fly.log.service;

import com.fly.log.entity.SysLog;
import com.fly.log.dao.SysLogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: <><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Service
public class  SysLogService {

    @Autowired
    SysLogDAO sysLogDAO;

    public void saveLogger(SysLog sysLog){
        System.out.println("MYTAG:Logger saveLogger start...");
        sysLogDAO.save(sysLog);
    }
}
