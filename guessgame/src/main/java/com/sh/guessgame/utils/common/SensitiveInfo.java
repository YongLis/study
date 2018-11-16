package com.sh.guessgame.utils.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: SensitiveInfo.java
 * @Description: <br>
 *               敏感信息注解标记 <br>
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveInfo {

    public SensitiveUtils.SensitiveType type() ;
}
