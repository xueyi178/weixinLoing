package com.springboot.entity;

/**
 * 返回结果包装对象使用
 * @author java1234_小锋
 * @site www.java1234.com
 * @company Java知识分享网
 * @create 2019-02-10 下午 2:50
 */
public class Result {

    /**
     * 状态
     */
    private Object status;
    /**
     * 结果
     */
    private Object result;
    /**
     * 消息
     */
    private String message;

    public Result() {
    }

    public Result(Object status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Object status, Object result) {
        this.status = status;
        this.result = result;
    }

    public Result(Object status, Object result, String message) {
        this.status = status;
        this.result = result;
        this.message = message;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
