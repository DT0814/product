package cn.product.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention( RetentionPolicy.RUNTIME )
@Documented
@Inherited
public @interface Role {
    public static int ROLE_STUDENT = 1; //观看
    public static int ROLE_TEACHER = 2; // 普通
    public static int ROLE_ADMIN = 3; // 超级
    public static String Msg = "权限不足";

    public int role() default 0;

}
