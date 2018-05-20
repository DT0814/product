package cn.product.interceptor;

import cn.product.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RoleInterceptor implements HandlerInterceptor {

    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object method, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod methodHandler = (HandlerMethod) handler;
        java.lang.reflect.Method method = methodHandler.getMethod();
        Role role = method.getAnnotation(Role.class);
        if ( role != null ) {
            int roleCode = role.role();
            if ( roleCode == 3 ) {
                if ( request.getSession().getAttribute("admin") != null ) {
                    return true;
                } else {
                    send(response, 405);
                    request.getSession().invalidate();
                    return false;
                }
            }
            if ( roleCode == 1 ) {
                if ( request.getSession().getAttribute("user_student") != null ) {
                    return true;
                } else {
                    send(response, 405);
                    request.getSession().invalidate();
                    return false;
                }
            }
            if ( roleCode == 2 ) {
                if ( request.getSession().getAttribute("user_teacher") != null ) {
                    return true;
                } else {
                    send(response, 405);
                    request.getSession().invalidate();
                    return false;
                }
            }
            if ( roleCode == 4 ) {
                if ( request.getSession().getAttribute("user_teacher") != null
                        || request.getSession().getAttribute("admin") != null ) {
                    return true;
                } else {
                    send(response, 405);
                    request.getSession().invalidate();
                    return false;
                }
            }
        }
        return true;
    }

    public void send(HttpServletResponse response, int status) {
        response.setStatus(HttpStatus.OK.value()); // 设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 设置ContentType
        response.setCharacterEncoding("UTF-8"); // 避免乱码
        response.setContentType("application/json;charset=UTF-8");
        Result build = Result.err(status, "您的权限不够");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().print(build.toString());
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

}
