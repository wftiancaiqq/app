package com.wf.first.app.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResult<T> {
    private T data;

    private String code;

    private String msg;

    public BaseResult(T data, String code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static <T>BaseResult<T> success () {
        return new <T>BaseResult<T>(null, "200", null);
    }

    public static <T>BaseResult<T> success (T data) {
        return new <T>BaseResult<T>(data, "200", "请求成功");
    }

    public static <T>BaseResult<T> fail (String msg) {
        return new <T>BaseResult<T>(null, "500", msg);
    }

}
