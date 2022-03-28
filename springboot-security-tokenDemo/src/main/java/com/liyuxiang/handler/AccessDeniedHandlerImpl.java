package com.liyuxiang.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liyuxiang.domain.ResponseResult;
import com.liyuxiang.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //处理异常
        ResponseResult responseResult = new ResponseResult(HttpStatus.FORBIDDEN.value(),"权限不足");
        WebUtils.renderString(response,new ObjectMapper().writeValueAsString(responseResult));
    }
}
