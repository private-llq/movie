package com.woniuxy.oneeyeticket.commom;

public class Result {
    /**
     * 执行状态，成功失败
     */
    private boolean  success;

    /**
     * 消息：错误提示；成功消息  xxx不能为空
     */
    private String message;

    /**
     * 结果码  0000成功   0100 参数错误
     */
    //private String  code;

    /**
     * 数据对象
     */
    private Object data;

    public Result() {
    }

    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static Result success(){
        return success(null);
    }

    public static Result success(Object data){
        return new Result(true,"执行成功",data);
    }

    public static Result fail(String message){
        return new Result(false,message,null);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
