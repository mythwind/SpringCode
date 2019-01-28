package com.vincent.springbootdemo.entity.common;

import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Auther: mythwind
 * @Date: 2019/01/28 14:45
 * @Description:
 */
public class AspectEntity {
    private String typeName;
    private String methodName;
    private String argsName;
    private String argsValue;
    private String url;
    private String remoteAddr;
    private String httpMethod;
    private String classMethod;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getArgsName() {
        return argsName;
    }

    public void setArgsName(String argsName) {
        this.argsName = argsName;
    }

    public String getArgsValue() {
        return argsValue;
    }

    public void setArgsValue(String argsValue) {
        this.argsValue = argsValue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    @Override
    public String toString() {
        return "AspectEntity{" +
                "typeName='" + typeName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", argsName='" + argsName + '\'' +
                ", argsValue='" + argsValue + '\'' +
                ", url='" + url + '\'' +
                ", remoteAddr='" + remoteAddr + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", classMethod='" + classMethod + '\'' +
                '}';
    }
}
