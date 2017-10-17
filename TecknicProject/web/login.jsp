<%-- 
    Document   : login
    Created on : 12-Oct-2017, 10:36:35
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknic | Đăng nhập</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="mainstyle.css">
        <link rel="stylesheet" href="loginStyle.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <script src="jquery.min.js" type="application/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="application/javascript"></script>
        <script src="UIControll.js" type="application/javascript"></script>
    </head>
    <body>
        <s:include value="header.jsp"></s:include>
        <s:if test="%{#session.ROLE == null}">
            <div class="main selfclear fixPadingTop">
                <form action="login" method="POST">
                    <div class="formContain formBox">
                        <h1>Đăng nhập</h1>
                        <div class="inputText">
                            <label>Tài khoản</label>
                            <input type="text" name="txtUsername">
                        </div>
                        <div class="inputText">
                            <label>Mật khẩu</label>
                            <input type="password" name="txtPassword">
                        </div>
                        <div class="buttonGroup">
                            <input type="submit" class="button buttonPrimary" value="Đăng nhập">
                        </div>
                        <div>
                            <p>Bạn chưa có tài khoản? <a href="register.jsp">Hãy đăng ký ngay</a>.</p>
                        </div>
                    </div>
                </form>
            </div>
        </s:if>
        <s:else>
            <div class="main selfclear">
                Bạn đã đăng nhập. Bấm vào <a href="index.jsp">đây</a> để trở lại trang chủ.
            </div>
        </s:else>
        <s:include value="footer.jsp"></s:include>
    </body>
</html>
