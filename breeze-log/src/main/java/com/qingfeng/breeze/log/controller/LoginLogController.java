package com.qingfeng.breeze.log.controller;

import com.qingfeng.breeze.api.base.BaseController;
import com.qingfeng.breeze.log.model.LoginLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/loginLog/")
public class LoginLogController extends BaseController<LoginLog> {

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        if (haystack == null || haystack.equals("")) {
            return -1;
        }
        int n = needle.length();
        loop: for (int i=0; i <=haystack.length()-n;i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j=1;j<n;j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        continue loop;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","asssasd"));
    }
}