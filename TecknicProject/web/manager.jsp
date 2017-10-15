<%-- 
    Document   : manager
    Created on : 15-Oct-2017, 17:07:20
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknic | Manager Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="mainstyle.css">
        <link rel="stylesheet" href="managerStyle.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <script src="jquery.min.js" type="application/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="application/javascript"></script>
        <script src="UIControll.js" type="application/javascript"></script>
    </head>
    <body>
        <s:include value="header.jsp"></s:include>
            <div class="main selfclear">
                <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
                <div class="managerContaint col-xs-12 col-sm-12 col-md-10 col-lg-10">
                    <div class="managerInfo">
                        <div class="info">
                            <p class="title">Manager page</p>
                            <p class="role">ADMIN</p>
                            <p class="numOfPost"><b>2</b> bài viết chưa duyệt</p>
                        </div>
                        <div class="tabControl selfclear">
                            <div class="tab tabSelect" onclick="showTab('#postHistory', this)">Bài viết</div>
                            <div class="tab" onclick="showTab('#searchProfile', this)">Thông tin thành viên</div>
                        </div>
                    </div>
                    <div class="profileMainContaint widthNarrow">
                        <div class="tabContent widthNarrow" id="searchProfile">
                            <form>
                                <div class="formContain">
                                    <h1>Tìm kiếm thông tin thành viên</h1>
                                    <div class="inputText">
                                        <label>Tìm kiếm tài khoản</label>
                                        <input type="text" name="txtUsername">
                                        <div class="buttonGroup">
                                            <button class="button buttonPrimary"> <i class="fa fa-search"></i> </button>
                                        </div>
                                    </div>
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>Username</th>
                                                <th>Name</th>
                                                <th>Email</th>
                                                <th>Role</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                     <%-- hiện thông tin ở đây --%>
                                           <tr>
                                                <td><a href="wall.html">trautre</a></td>
                                                <td><a href="wall.html">Trẩu Ăn Tre</a></td>
                                                <td>trauantre@gmail.com</td>
                                                <td>Admin</td>
                                            </tr>
                                            <tr>
                                                <td><a href="wall.html">tre1232</a></td>
                                                <td><a href="wall.html">Tre Người</a></td>
                                                <td>tre@gmail.com</td>
                                                <td>Member</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </form>
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
                                    <tr>
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
        <s:include value="header.jsp"></s:include>        
    </body>
</html>
