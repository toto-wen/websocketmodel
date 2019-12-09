package com.wetsocket.proxy.impl;

import com.wetsocket.proxy.DicValueAssignment;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 实际执行类
 */
@Service
public class DicValueAssignmentImpl implements DicValueAssignment {
    /**
     * @param collection
     * @param tClass
     * @Desc: 批量赋值
     */
    @Override
    public void assignment(Collection collection, Class<T> tClass) {

    }

    /**
     * @param object
     * @Desc: 但对象赋值
     */
    @Override
    public void assignment(T object, Class<T> tClass) {

    }
}
