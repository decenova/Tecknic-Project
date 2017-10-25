<%-- 
    Document   : register
    Created on : 12-Oct-2017, 15:45:49
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknic | Đăng kí</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="mainstyle.css">
        <link rel="stylesheet" href="loginStyle.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <script src="jquery.min.js" type="application/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="application/javascript"></script>
        <script src="UIControll.js" type="application/javascript"></script>
        <script src="ajaxcontrol.js" type="application/javascript"></script>
    </head>
    <body>
        <s:include value="header.jsp"></s:include>
            <div class="main selfclear fixPadingTop">
                <form action="/register" method="post" id="registerform">
                    <div class="formContain formBox">
                        <h1>Đăng kí</h1>
                        <div class="inputText">
                            <label>Tên*</label>
                            <input type="text" name="txtName" id="name" onblur="checkName()" placeholder="Họ và tên">
                        </div>
                        <div class="inputText">
                            <label>Tài khoản*</label>
                            <input type="text" name="txtUsername" id="username" onblur="checkUsername()" placeholder="TaiKhoan"/>
                        </div>
                        <hr/>
                        <div class="inputText">
                            <label>Mật khẩu*</label>
                            <input type="password" name="txtPassword" id="password" onblur="checkPassword()">
                        </div>
                        <div class="inputText">
                            <label>Nhập lại mật khẩu*</label>
                            <input type="password" name="txtCheckPassword" id="confirmPassword" onblur="checkConfirmPassword()">
                        </div>
                        <hr/>
                        <div class="">
                            <label>Giới tính*</label>
                            <p><input type="radio" name="cbxGender" value="M" checked> Nam</p>
                            <p><input type="radio" name="cbxGender" value="N"> Nữ</p>
                            <p><input type="radio" name="cbxGender" value="O"> Giới tính khác</p>
                        </div>
                        <div class="inputText">
                            <label>Ngày sinh</label>
                            <input type="date" name="txtDob" id="date" value="1990-12-21">
                        </div>
                        <div class="inputText">
                            <label>Email</label>
                            <input type="email" name="txtEmail" id="email" onblur="checkEmail()" placeholder="example@gmail.com">
                        </div>
                        <div class="inputText">
                            <label>Số điện thoại</label>
                            <input type="text" name="txtPhoneNumber" id="phone">
                        </div>
                        <div class="inputText">
                            <label>Địa chỉ</label>
                            <input type="text" name="txtAddress">
                        </div>
                        <hr/>
                        <div>
                            <p><input type="checkbox" id="checkbox">Tôi đã đọc và đồng ý với <a href="rule.jsp" target="_blank">điều khoản và quy tắc</a></p>
                        </div>
                        <div class="buttonGroup">
                            <div class="button buttonPrimary" onclick="formsubmit('registerform')">Đăng kí</div>
                        </div>
                    </div>
                </form>
            </div>
        <s:include value="footer.jsp"></s:include>
    </body>
</html>
