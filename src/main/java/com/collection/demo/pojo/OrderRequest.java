package com.collection.demo.pojo;

import java.util.List;
import java.util.Map;

/**
 * @author wangwn
 * @date 2019-06-24.
 */
public class OrderRequest {


    /**
     * 默认的模版id
     */
    private String defaultTplId;

    /**
     * 接口创建订单时，入参中每条记录详情
     */
    private List<Map<String, Object>> details;

    /**
     * 接口上传的字段key列表
     */
    private List<ApiObjKey> keyList;


    public String getDefaultTplId() {
        return defaultTplId;
    }

    public void setDefaultTplId(String defaultTplId) {
        this.defaultTplId = defaultTplId;
    }

    public List<Map<String, Object>> getDetails() {
        return details;
    }

    public void setDetails(List<Map<String, Object>> details) {
        this.details = details;
    }

    public List<ApiObjKey> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<ApiObjKey> keyList) {
        this.keyList = keyList;
    }
}
