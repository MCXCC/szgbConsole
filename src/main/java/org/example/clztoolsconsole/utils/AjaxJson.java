package org.example.clztoolsconsole.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AjaxJson {
    private int code;

    private String msg;
    private Object data;


    public AjaxJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxJson put(Object value){
        this.data=value;
        return this;
    }

    static public AjaxJson success(String msg) {
        return new AjaxJson(200, msg);
    }
}
