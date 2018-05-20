package cn.product.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Role {
	public static int ROLE_STUDENT = 1; // 只有学生
	public static int ROLE_TEACHER = 2; // 只有教师
	public static int ROLE_ADMIN = 3; // 只有管理员
	public static int ROLE_ADMIN_AND_TEACHER = 4; // 只有管理员
	public static String Msg = "权限不足";
	public int role() default 7;

}
