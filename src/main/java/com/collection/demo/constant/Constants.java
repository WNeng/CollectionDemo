package com.collection.demo.constant;

/**
 * @author wangwn
 */
public interface Constants {

    /**
     * appid,由法催云提供
     */
//    String APP_ID = "610005";
//    String APP_ID = "830002";
    String APP_ID = "890009";


    /**
     * appkey,生成签名密钥，由法催云提供
     */
//    String APP_KEY = "75be3ebe5152458895b6a6a0ced0171e";
//    String APP_KEY = "4b5b64a863e44d0cb15ba41425dc34ae";
    String APP_KEY = "0693f390-8cbc-4365-abd8-5a68466a69ad";

    /**
     * api地址
     */
//    String BASE_URL = "http://localhost:8600";
//    String BASE_URL = "https://openapi.collectioncloud.cn";

    String BASE_URL = "http://testopen.collectioncloud.cn";
//    String BASE_URL = "http://120.77.3.193:8601";

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
