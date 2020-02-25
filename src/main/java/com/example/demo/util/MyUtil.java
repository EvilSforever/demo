package com.example.demo.util;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.xml.crypto.Data;
import java.util.UUID;

public final class MyUtil {
    //UUId
    public static String UUID= java.util.UUID.randomUUID().toString().replace("-","");

    //借款类型
    public static final Integer BORROW_TYPE=1;




}
