package com.collection.demo.order;

import com.alibaba.fastjson.JSON;
import com.collection.demo.constant.Constants;
import com.collection.demo.pojo.*;
import com.collection.demo.utils.SecurityUtils;
import com.collection.demo.utils.SignUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

/**
 * @author wangwn
 * @date 2019-06-20.
 */
@Service
public class OrderService {

    @Value("${spring.fileupload.destination}")
    private String destination;
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
            postForToken(Constants.GET_TOKEN, paramMap);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过订单号查询订单信息
     *
     * @param orderNo
     */
    public void getOrderByOrderNo(String orderNo, String token) {

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("orderNo", orderNo);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Constants.GET_ORDER_BY_ORDER_NO, token, paramMap);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取催收对象文件
     *
     * @param orderNo
     * @param objNo
     * @param token
     */
    public void getCollectObj(String orderNo, String objNo, String token) {

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("orderNo", orderNo);
        paramMap.put("objNo", objNo);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForEntity(Constants.COLLECTION_OBJ_URL, token, paramMap);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取订单列表
     * @param pageNumber
     * @param pageSize
     * @param createDateStart
     * @param createDateEnd
     */
    public void queryOrderList(int pageNumber, int pageSize, String createDateStart, String createDateEnd, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("pageNumber", String.valueOf(pageNumber));
        paramMap.put("pageSize", String.valueOf(pageSize));
        paramMap.put("createDateStart", createDateStart);
        paramMap.put("createDateEnd", createDateEnd);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Constants.GET_ORDER_LIST_URL, token, paramMap);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
            postForObject(Constants.GET_COLLECTION_TPL_LIST_URL, token, paramMap);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取发函报告列表
     * @param pageNumber
     * @param pageSize
     * @param createDateStart
     * @param createDateEnd
     */
    public void queryCollectionObjReport(int pageNumber, int pageSize, String createDateStart, String createDateEnd, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("pageNumber", String.valueOf(pageNumber));
        paramMap.put("pageSize", String.valueOf(pageSize));
        paramMap.put("createDateStart", createDateStart);
        paramMap.put("createDateEnd", createDateEnd);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Constants.COLLECTION_OBJ_REPORT_LIST_URL, token, paramMap);



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
    public void createOrder(String orderData, String token){

        Map<String, String> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("orderData", orderData);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        try {
            String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);
            paramMap.put("sign", sign);
            postForObject(Constants.CREATE_ORDER_URL, token, paramMap);



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
            postForObject(Constants.CREATE_ORDER_AES_URL, token, paramMap);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    /**
     * 上传凭证文件
     * @param orderNo
     * @param bankCert
     * @param token
     */
    public String uploadBankCert(String orderNo, BankCert bankCert, String token) throws IOException {

        Map<String, Object> paramMap = new HashMap();
        paramMap.put("appId", Constants.APP_ID);
        paramMap.put("orderNo", orderNo);
        paramMap.put("timestampStr", SignUtil.getTimeStampStr());

        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.setAll(paramMap);

        // 保存临时文件
        List<String> tempList = new ArrayList<>();

        if (bankCert != null) {


            for (BankCertBean cert : bankCert.getBankCerts()) {

                MultipartFile file = cert.getBankCertFile();
                createDir(destination);
                String tempFilePath = destination + File.separator + file.getOriginalFilename();

                try {
                    // create local temp file
                    FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(tempFilePath));
                    tempList.add(tempFilePath);
                    // MultipartFile 直接转 FileSystemResource是不行的
                    // 把临时文件变成FileSystemResource
                    FileSystemResource resource = new FileSystemResource(tempFilePath);
                    // LinkedMultiValueMap中，key对应的value值其实是一个LinkedList，所以可以一直往同一个key中add值，不会覆盖
                    postParameters.add("files", resource);
                } catch (Exception e) {
                    System.out.println("保存文件" + file.getOriginalFilename() + "至本地临时文件异常!");
                }

            }

        }else{
            System.out.println("bankCert is null");
        }

        String data = postForFile(Constants.UPLOAD_BANK_CERT_URL, token, postParameters);

        // delete local temp file
        deleteLocalTempFiles(tempList);

        return data;
    }


    public String postForToken(String url, Map paramsMap) {
        return postForObject(url, null, paramsMap);
    }


    public String postForObject(String url, String token, Map paramsMap) {

        RestTemplate restTemplate = new RestTemplate();
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


    public String postForFile(String url, String token, MultiValueMap<String, Object> postParameters) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        if (!StringUtils.isEmpty(token)) {
            headers.add("token", token);
        }
        headers.setContentType(MediaType.parseMediaType("multipart/form-data;charset=UTF-8"));

        System.out.println("请求参数 = " + postParameters.toString());
        HttpEntity<MultiValueMap<String, Object>> paramsEntiry = new HttpEntity<>(postParameters, headers);

        String data = restTemplate.postForObject(url, paramsEntiry, String.class);
        System.out.println("返回的数据 = " + data);

        return data;
    }

    private void deleteLocalTempFiles(List<String> tempList) {
        if (!CollectionUtils.isEmpty(tempList)) {
            for (String fileName : tempList) {
                new File(fileName).delete();
            }
        }
    }

    private void createDir(String tempPath) {
        File file = new File(tempPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public String postForEntity(String url, String token, Map paramsMap) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.setAll(paramsMap);
        HttpHeaders headers = new HttpHeaders();
        if (!StringUtils.isEmpty(token)) {
            headers.add("token", token);
        }
        System.out.println("请求参数 = " + paramsMap.toString());
        HttpEntity<MultiValueMap<String, Object>> paramsEntiry = new HttpEntity<>(postParameters, headers);
        ResponseEntity<Resource> entity = restTemplate.postForEntity(url, paramsEntiry, Resource.class);
        OutputStream outputStream = null;
        InputStream in = null;
        if (entity.getStatusCode().equals(HttpStatus.OK)) {

            try {
                in = entity.getBody().getInputStream();

                //地址自行更换本地地址
                File file = new File("/Users/wneng/fcy/home/files/test7.pdf");
                if (!file.exists()) {
                    file.createNewFile();
                }

                outputStream = new FileOutputStream(file);
                int len = 0;
                byte[] buf = new byte[1024];
                while ((len = in.read(buf, 0, 1024)) != -1) {
                    outputStream.write(buf, 0, len);
                }
                outputStream.flush();


            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                if (in != null) {
                    in.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }

        }

        return null;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {


        OrderService orderService = new OrderService();

        //获取token
//        orderService.getToken();

        //获取订单信息
//        String orderNo = "190926103800103";
        String token = "5574864967e541cfb824d2150c25e858";
//        String token = "4a54416915f345f3a61eda677a15c2ce";
//        orderService.getOrderByOrderNo(orderNo, token);


        //获取催收对象律师函
//        String objNo = "2c9276ed6d6877e5016d6b6eb4455996";
//        orderService.getCollectObj(orderNo, objNo, token);


        //获取订单列表
        int pageNumber = 1;
        int pagerSize = 11;
        //订单创建时间起始，字符串，格式必须为：yyyy-MM-dd
        String createDateStart = "2020-01-01";
        String createDateEnd = "2020-04-20";

//        orderService.queryOrderList(pageNumber, pagerSize, createDateStart, createDateEnd, token);
        // 获取发函报告列表
        orderService.queryCollectionObjReport(pageNumber, pagerSize, createDateStart, createDateEnd, token);

//        orderService.queryCollectionTplList(pageNumber, pagerSize, token);


//        Map<String, String> paramMap = new HashMap();
//        paramMap.put("appId", Constants.APP_ID);
//        paramMap.put("pageNumber", String.valueOf(1));
//        paramMap.put("pageSize", String.valueOf(10));
//        paramMap.put("createDateStart", "2019-06-20");
//        paramMap.put("createDateEnd", "2019-06-20");
//        paramMap.put("timestampStr", "1561100331");
//        String sign = SignUtil.createSign(paramMap, Constants.APP_KEY, true);



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
        keyList.add(new ApiObjKey("loanNo", "借款合同编号"));
        keyList.add(new ApiObjKey("loanName", "借款合同名称"));
        keyList.add(new ApiObjKey("lucnName", "出借人"));
        keyList.add(new ApiObjKey("loanAmount", "借款本金"));
        keyList.add(new ApiObjKey("loanBet", "年化利率"));
        keyList.add(new ApiObjKey("loanStartDate", "出借日期"));
        keyList.add(new ApiObjKey("loanEndDate", "到期日期"));
        keyList.add(new ApiObjKey("endAmount", "逾期金额"));
        keyList.add(new ApiObjKey("bankCert", "凭证文件名"));

        List<Map<String, Object>> details = new LinkedList<>();

        for (int i = 0; i < keyList.size(); i++) {

            Map<String, Object> objMap = new HashMap<>();
            objMap.put("objName", "王大胆" + i);
            objMap.put("objIdNbr", "350424199001101617");
            objMap.put("address", "福建厦门湖里区");
            objMap.put("tel", "18950493760");
            objMap.put("email", "fj25822@qq.com");
            objMap.put("loanNo", String.valueOf(2019062456 + i));
            objMap.put("loanName", "借款合同");
            objMap.put("lucnName", "龙行虎步");
            objMap.put("loanAmount", "10000" + i);
            objMap.put("loanBet", "12%");
            objMap.put("loanStartDate", "20180624");
            objMap.put("loanEndDate", "20190624");
            objMap.put("endAmount", "5000" + i);
            objMap.put("bankCert", "银行凭证" + i + ".jpg");

            details.add(objMap);

        }
//
//        OrderRequest orderRequest = new OrderRequest();
//        //暂时默认提供模版id
//        orderRequest.setDefaultTplId("2c9276ed6b84de88016b89a264390038");
//        orderRequest.setKeyList(keyList);
//        orderRequest.setDetails(details);
//        String jsonString = JSON.toJSONString(orderRequest);
//        System.out.println(jsonString);
//
////        orderService.createOrder(jsonString, token);
//
//        // 加密订单数据生成订单
//        String encrypt = SecurityUtils.encrypt(jsonString, Constants.APP_KEY);
//        orderService.createOrderBySecret(encrypt, token);


//        System.out.println(isNumber("1000"));
//        System.out.println(isNumber("242525.252636"));
//        System.out.println(isNumber("242525.252636.9596"));
//        System.out.println(isNumber("200535.243"));
//        System.out.println(isNumber("200535"));
//        System.out.println(isNumber("中午"));









    }


    public static boolean isNumber(String str){
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }


}
