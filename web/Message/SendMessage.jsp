<%--
  Created by IntelliJ IDEA.
  User: fcncd
  Date: 2018/11/25
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SendMessage</title>
</head>
<body>
    <form action="./sendMessageServlet" method="post">
        <textarea name="message_content" id="message_content" cols="30" rows="10"></textarea>
        <br>
        <input type="submit">
    </form>
    <p>
    <%= request.getParameter("message_content") %>
    </p>
</body>
</html>
