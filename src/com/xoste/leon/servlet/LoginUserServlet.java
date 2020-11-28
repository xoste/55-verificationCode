package com.xoste.leon.servlet;

import com.xoste.leon.pojo.User;
import com.xoste.leon.service.UserService;
import com.xoste.leon.service.impl.UserServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xoste
 */
@WebServlet("/login")
public class LoginUserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = applicationContext.getBean("userService", UserServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String verifyCode = req.getParameter("verifyCode");
        String codeSession = req.getSession().getAttribute("verifyCode").toString();
        System.out.println(codeSession);
        if (!codeSession.equals(verifyCode) ) {
            req.setAttribute("error", "验证码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            User loginUser = userService.loginUser(user);
            if (loginUser != null) {
                req.setAttribute("loginUser", loginUser);
                req.getRequestDispatcher("/jsp/success.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "用户名或密码错误");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }

    }
}
