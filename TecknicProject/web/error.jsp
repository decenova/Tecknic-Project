<%-- 
    Document   : error
    Created on : 12-Oct-2017, 15:10:41
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknic | Lỗi rồi</title>
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
                        <h1>Lỗi!</h1>
                        <p>Xin lỗi các bạn vì xảy ra sự cố này!</p>
                        <p>Xin đợi một lúc và thử thực hiện lại!</p>
                    </div>
                </form>
            </div>
        <s:include value="footer.jsp"></s:include>
    </body>
</html>
