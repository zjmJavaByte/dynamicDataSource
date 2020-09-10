package com.kh.jkdw.aop;

import com.kh.jkdw.annotation.DataSource;
import com.kh.jkdw.config.DataSourceContextHolder;
import com.kh.jkdw.config.DataSourceNames;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zjm
 * @version 1.0
 * 描述：TODO
 * @date 2020/9/9 15:27
 */
@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {


    /**
     * 切点: 所有配置 DataSource 注解的方法
     */
    @Pointcut("@annotation(com.kh.jkdw.annotation.DataSource)")
    public void dataSourcePointCut() {}

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSource ds = null;
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //获取自定义注解
        ds = method.getAnnotation(DataSource.class);
        if (ds == null) {
            //如果监测到自定义注解不存在,那么默认切换到数据源 mydbone
            DataSourceContextHolder.setDataSourceKey(DataSourceNames.ONE);
            log.info("set default datasource is " + DataSourceNames.ONE);
        } else {
            //自定义存在,则按照注解的值去切换数据源
            DataSourceContextHolder.setDataSourceKey(ds.value());
            log.info("set datasource is " + ds.value());
        }
        return point.proceed();
    }


    @After(value = "dataSourcePointCut()")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.clearDataSourceKey();
        log.info("clean datasource");
    }


}
