package com.effort.demo.common;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by zhangzhenren on 17-7-11.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisRepository {
}
