package com.vincent.springbootdemo.utils.text;

public class TextUtils {
    public static final boolean isEmpty (String text) {
        return text == null|| "".equals(text.trim());
    }
}
