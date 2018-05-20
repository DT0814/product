package cn.product.controller;

import cn.product.pojo.User;
import cn.product.service.UserService;
import cn.product.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping( "user" )
public class UserAction {
    @Autowired
    private UserService service;

    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll() {
        return Result.success(service.findAll());
    }

    @PostMapping( "/login.action" )
    @ResponseBody
    public Result login(HttpSession session, User user, String vali) {
        String validate = (String) session.getAttribute("validate");
        if ( !vali.equals(validate) ) {
            return Result.err(201, "验证码错误");
        }
        User u = service.findByAccount(user.getAccount());
        if ( u == null ) {
            return Result.err(201, "账号不存在");
        } else if ( !u.getPass().equals(user.getPass()) ) {
            return Result.err(201, "密码错误");
        } else {
            session.setAttribute("login", u);
            return Result.success(u);
        }
    }
}
