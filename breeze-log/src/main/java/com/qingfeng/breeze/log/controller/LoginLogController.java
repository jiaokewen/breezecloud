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

}