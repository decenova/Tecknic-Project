<%-- 
    Document   : index
    Created on : 12-Oct-2017, 10:22:45
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tecknic | Tin tức công nghệ mỗi ngày</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="mainstyle.css">
        <link rel="stylesheet" href="indexStyle.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <script src="jquery.min.js" type="application/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="application/javascript"></script>
        <script src="UIControll.js" type="application/javascript"></script>
        <script src="thang/indexajax.js" type="application/javascript"></script>
    </head>
    <body>
        <input type="hidden" id="tagIdFilter" value="<s:property value="%{tagId}"></s:property>"/>
        <input type="hidden" id="searchFilter" value="<s:property value="%{search}"></s:property>"/>
        <s:include value="header.jsp">
        </s:include>
        <div class="slideShow">
            <div class="slideContain selfclear" id="slideContain">
                <div class="slide" style="background-image: url('img/cover01.jpg')">
                    <a>Sorry không có bài mới</a>
                </div>
            </div>
        </div>
        
        <div class="main selfclear">
            <div class="postContaint" id="postContaint">
                
            </div>
        </div>
        <s:include value="footer.jsp">
        </s:include>
    </body>
</html>
