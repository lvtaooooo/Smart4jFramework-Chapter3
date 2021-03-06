package org.smart4j.chapter3.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter3.model.Customer;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.framework.proxy.AspectProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author shijiapeng
 * @Date 2016/11/10 15:49
 * Created by shijiapeng on 2016/11/10.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long beginTime;

    @Override
    public void before(Class<?> targetClass, Method targetMethod, Object[] methodParams) {

        LOGGER.debug("------------ begin -------------");
        LOGGER.debug(String.format("class: %s", targetClass.getName()));
        LOGGER.debug(String.format("method: %s", targetMethod.getName()));
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> targetClass, Method targetMethod, Object[] methodParams) {
        LOGGER.debug(String.format("eclipsed time: %dms", System.currentTimeMillis() - beginTime));
        LOGGER.debug("------------ end -------------");
    }
}
