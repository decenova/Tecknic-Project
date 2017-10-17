<%-- 
    Document   : changepassword
    Created on : 15-Oct-2017, 17:01:43
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknic | Change password</title>
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
            <div class="main selfclear fixPadingTop">
                <form>
                    <div class="formContain formBox">
                        <h1>Đổi mật khẩu</h1>
                        <div class="inputText">
                            <label>Mật khẩu cũ</label>
                            <input type="password" name="txtPassword">
                        </div>
                        <div class="inputText">
                            <label>Mật khẩu mới</label>
                            <input type="password" name="txtPassword">
                        </div>
                        <div class="inputText">
                            <label>Xác nhận mật khẩu mới</label>
                            <input type="password" name="txtPassword">
                        </div>
                        <div class="buttonGroup">
                            <div class="button buttonPrimary">Đổi mật khẩu</div>
                        </div>
                    </div>
                </form>
            </div>
        <s:include value="header.jsp"></s:include>
    </body>
</html>
