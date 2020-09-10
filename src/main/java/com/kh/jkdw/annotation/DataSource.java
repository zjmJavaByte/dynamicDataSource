package com.kh.jkdw.annotation;



import com.kh.jkdw.config.DataSourceNames;

import java.lang.annotation.*;
/**
 * @author zjm
 * @version 1.0
 * 描述：TODO
 * @date 2020/9/9 15:06
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value() default DataSourceNames.ONE;
}
