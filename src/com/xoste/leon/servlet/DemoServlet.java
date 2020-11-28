package com.xoste.leon.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Tiger
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 响应输出流
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File(getServletContext().getRealPath("image"), "timg.jpg"));
        int index = -1;
        while ((index = fileInputStream.read()) != -1) {
            servletOutputStream.write(index);
        }
    }
}
