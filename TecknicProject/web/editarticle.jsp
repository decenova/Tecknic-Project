<%-- 
    Document   : editarticle
    Created on : 15-Oct-2017, 17:05:17
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknick | Edit</title>
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
                        <h1>Đăng bài</h1>
                        <div class="inputText">
                            <label>Tiêu đề*</label>
                            <input type="text" name="txtTitle">
                        </div>
                        <div class="inputText">
                            <label>Ảnh bìa</label>
                            <input type="text" name="txtImage" placeholder="">
                        </div>
                        <hr/>
                        <div class="inputText">
                            <label>Nội dung*</label>
                            <textarea name="txtComment" rows="4"></textarea>
                        </div>
                        <hr/>
                        <div class="">
                            <label>Thể loại*</label>
                            <p><input type="checkbox" name="cbxTag" value="1" checked> Điện thoại</p>
                            <p><input type="checkbox" name="cbxTag" value="2"> Laptop</p>
                            <p><input type="checkbox" name="cbxTag" value="3"> Khác</p>
                        </div>
                        <hr/>
                        <div class="buttonGroup">
                            <div class="button buttonPrimary">Đăng bài</div>
                        </div>
                    </div>
                </form>
            </div>
        <s:include value="header.jsp"></s:include>
    </body>
</html>
