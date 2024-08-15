package org.example.clztoolsconsole.utils;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AjaxJson implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    @lombok.Data
    private static class Data{
        private Object data;
        private Page page;
    }

    private int code;
    private String msg;
    private Data data=new Data();
    private Page page;

    public AjaxJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    static public AjaxJson success(String msg) {
        return new AjaxJson(200, msg);
    }

    public AjaxJson put(Object value) {
        this.data.data = value;
        return this;
    }

    public AjaxJson page(Page page) {
        this.data.page = page;
        return this;
    }

    static public AjaxJson error(String msg){
        return new AjaxJson(403, msg);
    }

    static public AjaxJson loginError(String msg){return new AjaxJson(401, msg);}
}
