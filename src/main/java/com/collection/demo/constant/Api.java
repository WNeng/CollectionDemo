package com.collection.demo.constant;

/**
 * 新版api接口
 * @author wangwn
 * @date 2020/6/12.
 */
public interface Api {

    /**
     * api地址
     */
//    String BASE_URL = "http://localhost:8600";
    String BASE_URL = "https://openapi.collectioncloud.cn";

//    String BASE_URL = "http://testopen.collectioncloud.cn";
//    String BASE_URL = "http://120.77.3.193:8601";
    /**
     * 获取刷新token
     */
    String GET_TOKEN = BASE_URL + "/api/token";
    /**
     * 获取机构模版列表
     */
    String QUERY_TPL_LIST = BASE_URL + "/api/queryTplList";
    /**
     * 创建订单ems加密
     */
    String  CREATE_ORDER = BASE_URL + "/api/createOrder";
    /**
     * 查询创建订单失败数据
     */
    String QRY_FAIL_OBJ_LIST = BASE_URL + "/api/qryFailObjList";
    /**
     * 按批次取消订单审核通过状态不能取消
     */
    String BACK_ORDER_BY_ORDER_NO = BASE_URL + "/api/backOrderByOrderNo";
    /**
     * 单个发函对象退回
     * 审核通过状态不能退回
     */
    String BACK_COLLECTION_OBJ = BASE_URL + "/api/backCollectionObj";
    /**
     * 已还款用户标记
     * 标记完成后不会后续发送短信邮件
     */
    String UPDATE_REPAID_STATUS = BASE_URL + "/api/updateRepaidStatus";
    /**
     * 按合同编号查询发函对象报表数据
     */
    String QUERY_OBJ_BY_LOANNO = BASE_URL + "/api/queryObjByLoanNo";

    /**
     * 按合同编号发起语音通知
     */
    String VOICE_NOTIFY_BY_LOANNO = BASE_URL + "/api/voiceNotificationByLoanNo";

}
