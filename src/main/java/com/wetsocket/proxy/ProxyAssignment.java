package com.wetsocket.proxy;

import com.wetsocket.proxy.impl.DicValueAssignmentImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.Collection;

/**
 * Created by PC-007 on 2019/11/22.
 */
public class ProxyAssignment implements DicValueAssignment {

    @Autowired
    private DicValueAssignmentImpl dicValueAssignment;

    /**
     * @param collection
     * @param tClass
     * @Desc: 批量赋值
     */
    @Override
    public void assignment(Collection collection, Class<T> tClass) {
        Assert.notEmpty(collection, "传入集合为空");
        Assert.notNull(tClass, "传入的Class<T>为空");
        dicValueAssignment.assignment(collection, tClass);
    }

    /**
     * @param object
     * @Desc: 但对象赋值
     */
    @Override
    public void assignment(T object, Class<T> tClass) {
        Assert.notNull(object, "传入的被装配对象为空");
        Assert.notNull(tClass, "传入的Class<T>为空");

        dicValueAssignment.assignment(object, tClass);
    }
}
