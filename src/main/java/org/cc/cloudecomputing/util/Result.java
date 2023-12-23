package org.cc.cloudecomputing.util;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    public Result(){}
    public Result(T data){
        this.data=data;
    }
    public static <E>Result<E>success(String msg,E data){
        Result<E> result=new Result<>(data);
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }
    public static <E> Result<E> success(E data){
        return success("success",data);
    }
    public static Result<?> success(){
        return success(null);
    }
    public static Result<?> error(int code,String msg){
        Result<?> result=new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
