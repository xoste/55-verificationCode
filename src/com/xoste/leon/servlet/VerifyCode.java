package com.xoste.leon.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Xoste
 */
@WebServlet("/verify")
public class VerifyCode extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建一张图片 单位：像素
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
        // 创建透明的玻璃
        Graphics2D graphics = image.createGraphics();
        // 在画板上画内容之前先设置好画板的颜色
        graphics.setColor(new Color(124,135,151));
        // 填充画板中的内容
        graphics.fillRect(0, 0, 200, 100);
        // 在画板中绘制
        List<Integer> randomList = new ArrayList<Integer>();
        Random random = new Random();
        int length = 4;
        for (int i = 0; i < length; i++) {
            randomList.add(random.nextInt(10));
        }
        // 设置字体的风格
        graphics.setFont(new Font("华文行楷", Font.ITALIC, 40));
        // 设置画笔的颜色
        Color[] colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.GRAY, Color.CYAN, Color.ORANGE, Color.YELLOW};
        for (int i = 0; i < randomList.size(); i++) {
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawString(randomList.get(i) + "", 10 + i * 50 , 70 + (random.nextInt(20) - 10));
        }
        //画横线
        int num = 2;
        for (int i = 0; i < num; i++) {
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(0, random.nextInt(100), 200, random.nextInt(100));
        }
        // 输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        // 工具类
        ImageIO.write(image, "jpg", outputStream);
        // 将验证码存到Session中
        HttpSession session = req.getSession();
        session.setAttribute("verifyCode", "" + randomList.get(0) + randomList.get(1) + randomList.get(2) + randomList.get(3));
    }
}
