<%-- 
    Document   : header
    Created on : 12-Oct-2017, 10:20:47
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Header</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="thang/headerLoad.js" type="application/javascript"></script>
    </head>
    <body>
        <header>
            <div class="hidden-xs hidden-sm hidden-md col-lg-1"></div>
            <div class="logocontain col-xs-2 col-sm-2 col-md-1 col-lg-1">
                <a href="/Tecknic/">
                    <img src="img/newlogo.svg"/>
                </a>
            </div>
            <div class="col-xs-2 col-sm-4 col-md-5 col-lg-4">
                <div class="menuButton" onclick="showNav()"><i class="fa fa-bars"></i></div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
                <input id="search" type="text" class="" name="search" placeholder="search...">
                <div class="button buttonPrimary" id="searchButton">
                    <i class="fa fa-search"></i>
                </div>
            </div>
            <div class="col-xs-4 col-sm-2 col-md-2 col-lg-2">
                <s:if test="%{#session.ROLE == null}">
                    <a href="login.jsp">
                        <button class="button buttonPrimary">Đăng nhập</button>
                    </a>
                </s:if>
                <s:else>
                    <div class="userInfoContain" onclick="userMenuToggle()">
                        <div class="userAvatar">
                            <img src="<s:property value="%{#session.AVATAR}"/>">
                            <!--set thêm ID-->
                        </div>
                    </div>
                </s:else>
            </div>
            <div class="hidden-xs hidden-sm hidden-md col-lg-1"></div>
        </header>
        <s:if test="%{#session.ROLE != null}">
            <div class="userMenu">
                <div class="hidden-xs hidden-sm hidden-md col-lg-1"></div>
                <div class="col-xs-8 col-sm-10 col-md-10 col-lg-8"></div>
                <ul class="col-xs-4 col-sm-2 col-md-2 col-lg-2">
                    <a href="/Tecknic/viewOtherProfile?userId=<s:property value="%{#session.ID}"/>"><li>Tường nhà bạn</li></a>
                    <!--load Profile-->
                    <a href="loadProfile"><li>Quản lý cá nhân</li></a>
                    <a href="changepassword.jsp"><li>Đổi mật khẩu</li></a>
                    <a href="logout"><li>Đăng xuất</li></a>
                </ul>
                <div class="hidden-xs hidden-sm hidden-md col-lg-1"></div>
            </div>
        </s:if>
        <nav class="">
            <div class="closebackground" onclick="closeNav()"></div>
            <div class="navContain col-xs-12 col-sm-6 col-md-4 col-lg-4">
                <ul>

                    <a onclick="closeNav()"><li><i class="fa fa-times"></i></li></a>
                    <hr/>
                    <s:if test="%{#session.ROLE == 'Colaborator' || #session.ROLE == 'Moderator' || #session.ROLE == 'Administrator'}">
                        <a href="editarticle.jsp"><li>Đăng bài</li></a>
                        <hr/>
                    </s:if>
                    <s:if test="%{#session.ROLE == 'Administrator' || #session.ROLE == 'Moderator'}">
                        <a href="manager.jsp"><li>Quản lý</li></a>
                        <hr/>
                    </s:if>
                    <%-- cái dưới dùng để lọc nội dung vài post theo loại --%>
                    <div id="categories">
                    </div>
                </ul>
            </div>
        </nav>
    </body>
</html>
