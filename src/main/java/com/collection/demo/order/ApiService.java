package com.collection.demo.order;

import com.alibaba.fastjson.JSON;
import com.collection.demo.constant.Api;
import com.collection.demo.constant.Constants;
import com.collection.demo.pojo.ApiObjKey;
import com.collection.demo.pojo.OrderRequest;
import com.collection.demo.utils.SecurityUtils;
import com.collection.demo.utils.SignUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author wangwn
 * @date 2020/6/12.
 */
@Service
public class ApiService {


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取刷新token
     */
    public void getToken() {

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForToken(Api.GET_TOKEN, paramMap);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取创建的催收模版列表
     * @param pageNumber
     * @param pageSize
     */
    public void queryCollectionTplList(int pageNumber, int pageSize, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("pageNumber", String.valueOf(pageNumber));
        paramMap.put("pageSize", String.valueOf(pageSize));
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            System.out.println(paramMap.toString());
            postForObject(Api.QUERY_TPL_LIST, token, paramMap);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建订单
     * @param orderData
     * @param token
     */
    public void createOrderBySecret(String orderData, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("orderData", orderData);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Api.CREATE_ORDER, token, paramMap);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 查询创建订单失败的数据列表
     * @param beginDate
     * @param endDate
     */
    public void qryFailObjList(String beginDate, String endDate, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("beginDate", beginDate);
        paramMap.put("endDate", endDate);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Api.QRY_FAIL_OBJ_LIST, token, paramMap);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 按批次取消订单审核通过状态不能取消
     * @param orderNo
     * @param opinion
     */
    public void backOrderByOrderNo(String orderNo, String opinion, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("orderNo", orderNo);
        paramMap.put("opinion", opinion);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Api.BACK_ORDER_BY_ORDER_NO, token, paramMap);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 单个发函对象退回
     *      * 审核通过状态不能退回
     * @param orderNo
     * @param objId
     * @param opinion
     */
    public void backCollectionObj(String orderNo, String objId, String opinion, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("orderNo", orderNo);
        paramMap.put("objId", objId);
        paramMap.put("opinion", opinion);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Api.BACK_COLLECTION_OBJ, token, paramMap);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 已还款用户标记
     *      * 标记完成后不会后续发送短信邮件
     * @param orderNo
     * @param objId
     */
    public void updateRepaidStatus(String orderNo, String objId, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("orderNo", orderNo);
        paramMap.put("objId", objId);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Api.UPDATE_REPAID_STATUS, token, paramMap);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 按合同编号查询发函对象报表数据
     * @param loanNo
     */
    public void queryObjByLoanNo(String loanNo, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("loanNo", loanNo);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Api.QUERY_OBJ_BY_LOANNO, token, paramMap);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 按合同编号发起语音通知
     * @param loanNo
     */
    public void voiceNotificationByLoanNo(String loanNo, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("loanNo", loanNo);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Api.VOICE_NOTIFY_BY_LOANNO, token, paramMap);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String postForToken(String url, Map paramsMap) {
        return postForObject(url, null, paramsMap);
    }

    public String postForObject(String url, String token, Map paramsMap) {

        RestTemplate restTemplate = new RestTemplate();
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setBufferRequestBody(false);
//        RestTemplate restTemplate = new RestTemplate(factory);
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.setAll(paramsMap);
        HttpHeaders headers = new HttpHeaders();
        if (!StringUtils.isEmpty(token)) {
            headers.add("token", token);
        }
        System.out.println("请求参数 = " + paramsMap.toString());
        HttpEntity<MultiValueMap<String, Object>> paramsEntiry = new HttpEntity<>(postParameters, headers);
        String data = restTemplate.postForObject(url, paramsEntiry, String.class);
        System.out.println("返回的数据 = " + data);
        return data;
    }

    public static void main(String[] args) {

        ApiService apiService = new ApiService();
        // 1. 获取token
//        apiService.testToken(apiService);

        String token = "4344cdad5f3e40daae3c50c84b8d4773";
        // 2. 获取模版列表
//        apiService.testCollectionTplList(apiService, token);
        // 模版ID
//        String defaultTplId = "2c9276ed6b84de88016b89a264390038";
        String defaultTplId = "2c92775b73f10ddd0173f15a3608001b";
        // 3. 创建订单
        // {"code":0,"data":{"fail":0,"total":1,"orderNo":"200612180054299","failMap":{},"success":1},"message":"SUCCESS"}
//        for (int i = 0; i < 1000; i++) {
//
//            apiService.testCreateOrder(apiService, defaultTplId, token);
//        }



        // 4. 获取创建订单失败数据
//        apiService.testQryFailObjList(apiService, token);
        // 5. 按批次取消订单审核通过状态不能取消
//        apiService.testBackOrderByOrderNo(apiService, token);
        // 6. 单个发函对象退回
//        apiService.testBackCollectionObj(apiService, token);
        // 7. 已还款用户标记
//        apiService.testUpdateRepaidStatus(apiService, token);
        // 8. 按合同编号查询发函对象报表数据
//        apiService.testQueryObjByLoanNo(apiService, token);
        // 9. 按合同编号发起语音通知
        apiService.testVoiceObjByLoanNo(apiService, token);









    }

    /**
     * 1. 获取token测试
     */
    private void testToken(ApiService apiService) {

        // 1.获取token
        apiService.getToken();

    }

    /**
     *
     * 2. 获取机构配置的模版列表
     * 拿到模版id 创建订单使用
     * @param apiService
     * @param token
     */
    private void testCollectionTplList(ApiService apiService, String token){
        //获取订单列表
        int pageNumber = 1;
        int pagerSize = 11;

        apiService.queryCollectionTplList(pageNumber, pagerSize, token);
    }

    /**
     * 3. 创建订单测试
     * @param apiService
     */
    public void testCreateOrder(ApiService apiService, String defaultTplId, String token){

        /**
         * createOrder
         */
        List<ApiObjKey> keyList = new ArrayList<>();
        //这个5个字段是固定的，必须上传
        keyList.add(new ApiObjKey("objName", "发函对象"));
        keyList.add(new ApiObjKey("objIdNbr", "证件号码"));
        keyList.add(new ApiObjKey("address", "联系地址"));
        keyList.add(new ApiObjKey("tel", "手机号码"));
        keyList.add(new ApiObjKey("email", "电子邮箱"));
        keyList.add(new ApiObjKey("loanNo", "合同编号"));
//        keyList.add(new ApiObjKey("loanName", "借款合同名称"));
        keyList.add(new ApiObjKey("lucnName", "委托人"));
//        keyList.add(new ApiObjKey("loanAmount", "借款本金"));
//        keyList.add(new ApiObjKey("loanBet", "年化利率"));
//        keyList.add(new ApiObjKey("loanStartDate", "出借日期"));
        keyList.add(new ApiObjKey("loanEndDate", "数据提取日期"));
        keyList.add(new ApiObjKey("phone", "还款联系电话"));
        keyList.add(new ApiObjKey("endAmount", "逾期金额"));
        keyList.add(new ApiObjKey("bankCert", "凭证文件名"));

        List<Map<String, Object>> details = new LinkedList<>();

        for (int i = 0; i < 1; i++) {

            Map<String, Object> objMap = new HashMap<>();
            objMap.put("objName", "王大胆" + i);
            objMap.put("objIdNbr", "350424199001101617");
            objMap.put("address", "福建厦门湖里区");
            objMap.put("tel", "18950493760");
//            if (i == 0) {
//                objMap.put("tel", "95187");
//            }else if (i == 1){
//                objMap.put("tel", "4006695566");
//            } else if (i == 2) {
//                objMap.put("tel", "0592-96166");
//            }else{
//                objMap.put("tel", "51722737");
//            }
            objMap.put("email", "fj25822@qq.com");
            objMap.put("loanNo", String.valueOf(2019062456 + i));
//            objMap.put("loanName", "借款合同");
            objMap.put("lucnName", "宿迁云瀚信息科技有限公司");
//            objMap.put("loanAmount", "10000" + i);
//            if (i == 8) {
//                objMap.put("loanBet", "40%");
//            }else{
//                objMap.put("loanBet", "12%");
//            }
//            objMap.put("loanStartDate", "2019-06-24");
            objMap.put("loanEndDate", "2020-06-13");
            objMap.put("endAmount", "5000" + i);
            objMap.put("phone", "0592-2181777");
            objMap.put("bankCert", "银行凭证" + i + ".jpg");

            details.add(objMap);

        }

        OrderRequest orderRequest = new OrderRequest();
        //暂时默认提供模版id
        orderRequest.setDefaultTplId(defaultTplId);
        orderRequest.setKeyList(keyList);
        orderRequest.setDetails(details);
        String jsonString = JSON.toJSONString(orderRequest);
        System.out.println(jsonString);

        // 加密订单数据生成订单
        String encrypt = SecurityUtils.encrypt(jsonString, Constants.APP_KEY);
        apiService.createOrderBySecret(encrypt, token);

    }

    /**
     * 4. 获取创建订单失败数据
     */
    private void testQryFailObjList(ApiService apiService, String token){

        String beginDate = "2020-01-01";
        String endDate = "2020-06-15";
        apiService.qryFailObjList(beginDate, endDate, token);

    }

    /**
     * 5. 按批次取消订单审核通过状态不能取消
     * @param token
     */
    private void testBackOrderByOrderNo(ApiService apiService, String token){
        String orderNo = "200613105601084";
        String opinion = "数据有错误";
        apiService.backOrderByOrderNo(orderNo, opinion, token);
    }

    /**
     * 6. 单个订单退回订单审核通过状态不能取消
     * @param apiService
     * @param token
     */
    private void testBackCollectionObj(ApiService apiService, String token){
        String orderNo = "200613105601084";
        String objId = "4028838272ab89840172ab9afe92001b";
        String opinion = "测试退回";
        apiService.backCollectionObj(orderNo, objId, opinion, token);
    }

    /**
     * 7. 已还款用户标记
     *    标记完成后不会后续发送短信邮件
     * @param apiService
     * @param token
     */
    private void testUpdateRepaidStatus(ApiService apiService, String token){
        String orderNo = "200613112606860";
        String objId = "4028838272aba58e0172abb68ce80006";
        apiService.updateRepaidStatus(orderNo, objId, token);
    }

    /**
     * 8. 按合同编号查询发函对象报表数据
     * @param apiService
     * @param token
     */
    private void testQueryObjByLoanNo(ApiService apiService, String token){
        String loanNo = "2019062456";
        apiService.queryObjByLoanNo(loanNo, token);
    }

    /**
     * 9. 按合同编号查询发函对象报表数据
     * @param apiService
     * @param token
     */
    private void testVoiceObjByLoanNo(ApiService apiService, String token){
        String loanNo = "5_18509234256795023536";
        apiService.voiceNotificationByLoanNo(loanNo, token);
    }

}
