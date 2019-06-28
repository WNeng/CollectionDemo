package com.collection.demo.pojo;

/**
 * @author wangwn
 * @date 2019-06-24.
 */
public class ApiObjKey {

    /**
     * api上传的动态字段名
     */
    private String keyCode;

    /**
     * api 上传的动态字段中文名
     */
    private String keyNameCn;


    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getKeyNameCn() {
        return keyNameCn;
    }

    public void setKeyNameCn(String keyNameCn) {
        this.keyNameCn = keyNameCn;
    }


    public ApiObjKey(String keyCode, String keyNameCn) {
        this.keyCode = keyCode;
        this.keyNameCn = keyNameCn;
    }
}
