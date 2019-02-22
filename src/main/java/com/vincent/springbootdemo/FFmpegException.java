package com.vincent.springbootdemo;

/**
 * @Auther: mythwind
 * @Date: 2019/02/20 13:49
 * @Description:
 */
public class FFmpegException extends RuntimeException {

    public FFmpegException(String errorMsg){
        super(errorMsg);
    }
    public FFmpegException(String errorMsg, Exception e){
        super(errorMsg, e);
    }
}
