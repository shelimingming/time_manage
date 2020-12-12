package com.mj.time.intercepter;

import com.alibaba.fastjson.JSONObject;
import com.mj.time.annotation.NoNeedToken;
import com.mj.time.common.ErrorCodeEnum;
import com.mj.time.util.JwtTokenUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置返回值属性
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String token = request.getHeader("token");
        PrintWriter out;
        // 对于注解的判断
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (handlerMethod.getMethodAnnotation(NoNeedToken.class) != null || handlerMethod.getBeanType().isAnnotationPresent(NoNeedToken.class)) {
            // 如果方法拥有NoNeedToken标注或者所属的类拥有NoNeedToken 就直接放行
            return true;
        }

        if (StringUtils.isEmpty(token)) {
            JSONObject res = new JSONObject();
            res.put("code", ErrorCodeEnum.TOKEN_ERROR.getCode());
            res.put("message", ErrorCodeEnum.TOKEN_ERROR.getMsg());
            out = response.getWriter();
            out.append(res.toString());
            return false;
        }

        Claims claims = null;
        try {
            claims = jwtTokenUtils.getClaimsFromToken(token);
        } catch (Exception ignored) {
            //解析token失败
            JSONObject res = new JSONObject();
            res.put("code", ErrorCodeEnum.TOKEN_ERROR.getCode());
            res.put("message", ErrorCodeEnum.TOKEN_ERROR.getMsg());
            out = response.getWriter();
            out.append(res.toString());
            return false;
        }
        //将token中解析出来的信息放入attribute中
        if (claims != null) {
            request.setAttribute("user_claims", claims);
            return true;
        }

        return false;
    }
}
