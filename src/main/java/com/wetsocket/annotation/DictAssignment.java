package com.wetsocket.annotation;

import java.lang.annotation.*;

/**
 * 此注解用于标记那些需要填充字典表中状态值得字段。
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictAssignment {

    String attribute() default "";
}
