package com.wetsocket.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by PC-007 on 2019/11/13.
 */
@Data
@AllArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;
    private T data;
    private String msg;

    public Result(){}

    public static <T> Result<T> data(T data){
        return new Result<T>(200, data, "请求成功");
    }

}
