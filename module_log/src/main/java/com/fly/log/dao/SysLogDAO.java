package com.fly.log.dao;

import com.fly.log.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description: <SysLogDAO><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public interface SysLogDAO extends JpaRepository<SysLog, Long> {
}
