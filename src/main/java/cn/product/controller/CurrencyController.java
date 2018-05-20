package cn.product.controller;

import cn.product.utils.GraphicHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping( "currency" )
public class CurrencyController {
    @RequestMapping( "/validate.action" )
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        final int width = 180;
        final int height = 40;
        final String imgType = "jpeg";
        final OutputStream output = response.getOutputStream();
        String code = GraphicHelper.create(width, height, imgType, output);
        session.setAttribute("validate", code);
        System.out.println(session.getAttribute("validate"));
    }
}
