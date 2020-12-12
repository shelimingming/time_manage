package com.mj.time.controller.base;

import com.mj.time.common.Constants;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Integer userId;  // 用户id
    protected String authType; // 登录类型

    @ModelAttribute
    public void parseClaims(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        // 获取到在拦截器里设置的 user_claims， 并将其保存到类的成员变量中
        Claims userClaims = (Claims) request.getAttribute("user_claims");
        if (userClaims != null) {
            this.userId = (Integer) userClaims.get(Constants.CLAIMS_USER_ID);
            this.authType = (String) userClaims.get(Constants.CLAIMS_AUTH_TYPE);
        }
    }
}
