<%--
  Created by IntelliJ IDEA.
  User: Xoste
  Date: 2020/11/27
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function() {
            $("a").click(function() {
                // 浏览器带有缓存功能，不会多次请求相同数据， 加个时间戳
                $("img").attr("src", "${pageContext.request.contextPath}/verify?date=" + new Date());
                // 取消超链接跳转功能
                return false;
            });
        });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label>
        用户名：<input type="text" name="username" placeholder="用户名"/><br/>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" placeholder="密码"><br/>
        验证码：<input type="text" size="1" name="verifyCode"><img src="${pageContext.request.contextPath}/verify" alt="图片已丢失" width="80px"/><a href="">看不清，换一张</a><br/>
        <input type="submit" value="登陆"><input type="reset" value="重置">
    </label><br/>
    ${requestScope.error}
</form>
</body>
</html>
