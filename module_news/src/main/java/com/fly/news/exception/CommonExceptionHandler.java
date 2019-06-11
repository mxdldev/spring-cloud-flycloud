package com.fly.news.exception;

import com.fly.common.dto.RespDTO;
import com.fly.common.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: <CommonExceptionHandler><br>
 * Author:    门心叼龙<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@ControllerAdvice
@ResponseBody
public class CommonExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<RespDTO> handleException(Exception e) {
        RespDTO resp = new RespDTO();
        CommonException taiChiException = (CommonException) e;
        resp.code = taiChiException.getCode();
        resp.error = e.getMessage();
        return new ResponseEntity(resp, HttpStatus.OK);
    }

}
