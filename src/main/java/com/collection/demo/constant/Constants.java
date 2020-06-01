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
    String APP_KEY = "20f530f063974f1da713925665fab13d";

    /**
     * api地址
     */
//    String BASE_URL = "http://localhost:8600";
//    String BASE_URL = "http://openapi.collectioncloud.cn";

    String BASE_URL = "http://testopen.collectioncloud.cn";

    /**
     * 获取刷新token
     */
    String GET_TOKEN = BASE_URL + "/order/getToken";

    /**
     * 创建订单
     */
    String CREATE_ORDER_URL = BASE_URL + "/order/createOrder";

    /**
     * 创建订单--订单数据AES加密
     */
    String CREATE_ORDER_AES_URL = BASE_URL + "/order/createOrderBySecret";

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

    /**
     * 获取催收模版列表
     */
    String GET_COLLECTION_TPL_LIST_URL = BASE_URL + "/order/queryCollectionTplList";

    /**
     * 获取发函报告列表
     */
    String COLLECTION_OBJ_REPORT_LIST_URL = BASE_URL + "/order/queryCollectionObjReport";







}
