package com.wetsocket.proxy;

import org.apache.poi.ss.formula.functions.T;

import java.util.Collection;

/**
 * Created by PC-007 on 2019/11/22.
 */
public interface DicValueAssignment {

    /**
     * @Desc: 批量赋值
     * @param collection
     */
    void assignment(Collection collection, Class<T> tClass);

    /**
     * @Desc: 但对象赋值
     * @param object
     */
    void assignment(T object, Class<T> tClass);
}
