package org.example.clztoolsconsole.utils;

import cn.hutool.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AjaxJson extends HashMap<String, Object> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    public AjaxJson() {
        this.put("success",true);
        this.put("code", HttpStatus.HTTP_OK);
        this.put("msg","操作成功");
    }

    public String getMsg() {
        return (String)this.get("msg");
    }

    public void setMsg(String msg) {//向json中添加属性，在js中访问，请调用data.msg
        this.put("msg", msg);
    }

    public boolean isSuccess() {
        return (boolean)this.get("success");
    }

    public void setSuccess(boolean success) {
        this.put("success", success);
    }

    public int getCode() {
        return (int)this.get("code");
    }

    public void setCode(int code) {
        this.put("code", code);
    }

    @JsonIgnore
    public static AjaxJson success(String msg) {
        AjaxJson j=new AjaxJson();
        j.setMsg(msg);
        return j;
    }

    @JsonIgnore//返回对象时忽略此属性
    public static AjaxJson error(String msg) {
        AjaxJson j = new AjaxJson();
        j.setSuccess(false);
        j.setMsg(msg);
        return j;
    }

    public static AjaxJson success(Map<String, Object> map) {
        AjaxJson restResponse = new AjaxJson();
        restResponse.putAll(map);
        return restResponse;
    }

    public static AjaxJson success() {
        return new AjaxJson();
    }

    @Override
    public AjaxJson put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
