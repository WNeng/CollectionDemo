package com.collection.demo.constant;

/**
 * @author wangwn
 */
public interface Constants {

    /**
     * appid,由法催云提供
     */
    String APP_ID = "610005";

    /**
     * appkey,生成签名密钥，由法催云提供
     */
    String APP_KEY = "cc986db9c19e49229f81848ce4f1781d";

    /**
     * api地址
     */
    String BASE_URL = "http://localhost:8600";
//    String BASE_URL = "http://openapi.collectioncloud.cn";

//    String BASE_URL = "http://120.77.145.89:8601";

    /**
     * 获取刷新token
     */
    String GET_TOKEN = BASE_URL + "/order/getToken";

    /**
     * 创建订单
     */
    String CREATE_ORDER_URL = BASE_URL + "/order/createOrder";

    /**
     * 上传凭证文件
     */
    String UPLOAD_BANK_CERT_URL = BASE_URL + "/order/uploadBankCert";

    /**
     * 订单查询，返回订单基本信息和状态信息
     */
    String GET_ORDER_BY_ORDER_NO = BASE_URL + "/order/getOrderByOrderNo";


    /**
     * 律师函下载
     */
    String COLLECTION_OBJ_URL = BASE_URL + "/order/getCollectObj";


    /**
     * 订单列表查询
     */
    String GET_ORDER_LIST_URL = BASE_URL + "/order/queryOrderList";






}
