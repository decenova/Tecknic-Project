<%-- 
    Document   : profile
    Created on : 15-Oct-2017, 16:47:34
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknic | Profile</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="mainstyle.css">
        <link rel="stylesheet" href="profileStyle.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <script src="jquery.min.js" type="application/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="application/javascript"></script>
        <script src="UIControll.js" type="application/javascript"></script>
    </head>
    <body>
        <s:include value="header.jsp"></s:include>
            <div class="main selfclear">
                <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
                <div class="profileContaint col-xs-12 col-sm-12 col-md-10 col-lg-10">
                    <div class="profileInfo">
                        <div class="avatar">
                            <%-- chỗ avatar của chủ profile này --%>
                            <img src="img/avartar01.jpg">
                        </div>
                        <div class="info">
                            <%-- chỗ thông tin của chủ profile này --%>
                            <p class="member">Trẩu Ăn Tre</p>
                            <p class="role">ADMIN</p>
                            <p class="numOfPost"><b>2</b> bài viết</p>
                            <p class="datejoin">Ngày gia nhập: <span class="date">12/02/2017</span> </p>
                        </div>
                        <div class="tabControl selfclear">
                            <div class="tab tabSelect" onclick="showTab('#profile', this)">Thông tin cá nhân</div>
                            <div class="tab" onclick="showTab('#postHistory', this)">Bài viết</div>
                        </div>
                    </div>
                    <div class="profileMainContaint widthNarrow">
                        <div class="tabContent widthNarrow" id="profile">
                            <div class="formContain">
                                <h1>Thông tin cá nhân</h1>
                                <%-- chỗ thông tin của chủ profile này --%>
                                <div class="wallInfo">
                                    <p>Giới tính: Nam</p>
                                    <p>Email: trauantre@gmail.com</p>
                                </div>
                            </div>
                        </div>
                        <div class="tabContent widthNarrow fixPadding" id="postHistory">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Title</th>
                                        <th>Create time</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%-- chỗ liệt kê bài viết, chỉ những bài đã được post mới hiện --%>
                                    <tr>
                                        <%-- nhớ cho link đến action tạo bài viết --%>
                                        <td><a href="post.html">Child of light: The dark of Luis V sẽ ra mắt vào tháng 11</a></td>
                                        <td>12:30 12/3/2017</td>
                                    </tr>
                                    <tr>
                                        <td><a href="post.html">Ori and the lind forest giảm giá mùa đông này</a></td>
                                        <td>11:30 12/3/2017</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
            </div>
        <s:include value="footer.jsp"></s:include>
    </body>
</html>
