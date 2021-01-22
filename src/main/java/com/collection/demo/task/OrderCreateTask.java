package com.collection.demo.task;

import com.alibaba.fastjson.JSON;
import com.collection.demo.constant.Constants;
import com.collection.demo.order.ApiService;
import com.collection.demo.pojo.ApiObjKey;
import com.collection.demo.pojo.OrderRequest;
import com.collection.demo.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OrderCreateTask {
    Logger logger = LoggerFactory.getLogger(OrderCreateTask.class);

    @Autowired
    ApiService apiService;

    @Async("taskExecutor")
    public void stringTask(){

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
        keyList.add(new ApiObjKey("lucnName", "委托人"));
        keyList.add(new ApiObjKey("loanAmount", "借款本金"));
        keyList.add(new ApiObjKey("loanBet", "年化利率"));
        keyList.add(new ApiObjKey("loanStartDate", "出借日期"));
        keyList.add(new ApiObjKey("loanEndDate", "到期日期"));
        keyList.add(new ApiObjKey("endAmount", "逾期金额"));
        keyList.add(new ApiObjKey("bankCert", "凭证文件名"));

        List<Map<String, Object>> details = new LinkedList<>();

        for (int i = 0; i < 10; i++) {

            Map<String, Object> objMap = new HashMap<>();
            objMap.put("objName", "王大胆");
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

        String token = "bfb141b2e471437bb6861783fa9576ee";

        OrderRequest orderRequest = new OrderRequest();
//        //暂时默认提供模版id
        orderRequest.setDefaultTplId("2c9276ed6b84de88016b89a264390038");
        orderRequest.setKeyList(keyList);
        orderRequest.setDetails(details);
        String jsonString = JSON.toJSONString(orderRequest);
        System.out.println(jsonString);
        // 加密订单数据生成订单
        String encrypt = SecurityUtils.encrypt(jsonString, Constants.APP_KEY);
        apiService.createOrderBySecret(encrypt, token);

    }
}