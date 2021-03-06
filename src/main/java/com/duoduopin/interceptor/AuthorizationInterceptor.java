package com.duoduopin.interceptor;

import com.duoduopin.annotation.Authorization;
import com.duoduopin.config.DuoDuoPinUtils;
import com.duoduopin.manager.TokenManager;
import com.duoduopin.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，判断此次请求是否有权限
 *
 * @author ScienJus
 * @date 2015/07/30.
 * @see com.duoduopin.annotation.Authorization
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
  @Autowired
  private TokenManager tokenManager;
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception {
    //    忽略非映射方法
    if (!(handler instanceof HandlerMethod)) return true;
    Method method = ((HandlerMethod) handler).getMethod();
    if (method.getAnnotation(Authorization.class) != null) {
      //    从header中得到token
      TokenModel tokenModel = tokenManager.getToken(request.getHeader(DuoDuoPinUtils.AUTHORIZATION));
      if (tokenManager.checkToken(tokenModel)) {
        request.setAttribute(DuoDuoPinUtils.CURRENT_USER_ID, tokenModel.getUserId());
        return true;
      } else {
        //      验证token失败，并且方法标注了@Authrization，返回401
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
      }
    }
    return true;
  }
}
