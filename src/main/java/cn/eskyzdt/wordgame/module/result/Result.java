package cn.eskyzdt.wordgame.module.result;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 继承fastjson的JSONObject
 * 的一个结果集
 *
 * @author dongtian
 * @since 2020-5-12
 *
 */
public class Result extends JSONObject {
    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public static Result error() {
        return error(500, "很抱歉出错了,请稍后再试");
    }

    public static Result error(String msg) {
        return error(500, msg);
    }
    public static Result leaderError(String message) {
        return leaderError(500, message);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
    public static Result leaderError(int state, String message) {
        Result r = new Result();
        r.put("state", state);
        r.put("message", message);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Result putResult(Object value) {
        super.put("result", value);
        return this;
    }

    public Object getResult() {
        return super.get("result");
    }

    /**
     * 判断是否为正确
     * @return 为true则正确
     */
    public boolean isTrue() {
            return this.getCode() == 0;
    }

    public boolean isError() {
        return this.getCode() == 500;
    }

    public int getCode() {
        return (int)this.get("code");
    }

    public String getMsg() {
        return (String)this.get("msg");
    }

}
