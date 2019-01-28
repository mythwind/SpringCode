package com.vincent.springbootdemo.utils;

import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import sun.net.www.http.HttpClient;

import java.net.HttpURLConnection;

public class MyConstants {
    public static final int MSG_LOGIN_USER_NOT_EXISTS = 0x0001;
    public static final int MSG_LOGIN_PASSWORD_ERROR = 0x0002;
    public static final int MSG_LOGIN_SUCESSED = HttpStatus.OK.value();

}
