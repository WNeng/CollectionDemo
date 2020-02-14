package com.collection.demo.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.collection.demo.utils.EmailCompletionUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangwn
 * @date 2019-11-26.
 */
public class Demo {


    public static void main(String[] args) {

        String fileName = "/Users/wneng/Downloads/20191125.json";
        String json = readJsonFile(fileName);
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray records = jsonObject.getJSONArray("RECORDS");
        List<String> tels = new ArrayList<>();
        for (int i = 0; i < records.size() ; i++) {

            String tel = records.getJSONObject(i).getString("tel");
            if (EmailCompletionUtil.isChinaTelecomPhoneNum(tel)) {
                tels.add(tel);
            }

        }

        System.out.println(JSON.toJSON(tels));


    }


    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
