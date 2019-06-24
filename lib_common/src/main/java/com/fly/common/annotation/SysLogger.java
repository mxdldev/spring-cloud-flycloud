package com.fly.common.annotation;

import java.lang.annotation.*;

/**
 * Description: <SysLogger><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogger {
    String value() default "";
}
