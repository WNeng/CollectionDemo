package com.collection.demo.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangwn
 * @date 2019-07-01.
 */
public class BankCertBean {


    private MultipartFile bankCertFile;

    private String collectionObjNo;

    public MultipartFile getBankCertFile() {
        return bankCertFile;
    }

    public void setBankCertFile(MultipartFile bankCertFile) {
        this.bankCertFile = bankCertFile;
    }

    public String getCollectionObjNo() {
        return collectionObjNo;
    }

    public void setCollectionObjNo(String collectionObjNo) {
        this.collectionObjNo = collectionObjNo;
    }
}
