package com.wetsocket.entity;

import com.wetsocket.annotation.DictAssignment;
import lombok.Data;

/**
 * Created by PC-007 on 2019/11/22.
 */
@Data
public class User {
    /**
     * 姓名
     */
    private String userName;
    /**
     * 性别编码
     */
    private Integer sex;
    /**
     * 性别描述
     */
    @DictAssignment
    private Integer sexMemo;

}
