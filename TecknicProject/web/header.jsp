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
    </head>
    <body>
        <header>
            <div class="hidden-xs hidden-sm hidden-md col-lg-1"></div>
            <div class="logocontain col-xs-2 col-sm-2 col-md-1 col-lg-1">
                <a href="index.jsp">
                    <img src="img/logo.svg"/>
                </a>
            </div>
            <div class="col-xs-2 col-sm-4 col-md-5 col-lg-4">
                <div class="menuButton" onclick="showNav()"><i class="fa fa-bars"></i></div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
                <form>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-search"></i></span>
                        <input id="search" type="text" class="form-control" name="search" placeholder="search...">
                    </div>
                </form>
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
                        </div>
                    </div>
                </s:else>
            </div>
            <div class="hidden-xs hidden-sm hidden-md col-lg-1"></div>
        </header>
        <nav class="">
            <div class="closebackground" onclick="closeNav()"></div>
            <div class="navContain col-xs-12 col-sm-6 col-md-4 col-lg-4">
                <ul>
                    
                    <a onclick="closeNav()"><li><i class="fa fa-times"></i></li></a>
                    <hr/>
                    <s:if test="%{#session.ROLE == 'Colaborator' || #session.ROLE == 'Moderator' || #session.ROLE == 'Administrator'}">
                    <a href="articlePost.html"><li>Đăng bài</li></a>
                    <hr/>
                    </s:if>
                    <s:if test="%{#session.ROLE == 'Administrator' || #session.ROLE == 'Moderator'}">
                    <a href="managerPage.html"><li>Quản lý</li></a>
                    <hr/>
                    </s:if>
                    <%-- cái dưới dùng để lọc nội dung vài post theo loại --%>
                    <a><li>Điện thoại</li></a>
                    <a><li>Laptop</li></a>
                    <a><li>Khác</li></a>
                </ul>
            </div>
        </nav>
        <s:if test="%{#session.ROLE != null}">
            <div class="userMenu">
                <ul class="col-xs-4 col-sm-2 col-md-2 col-lg-2">
                    <a><li>Tường nhà bạn</li></a>
                    <a><li>Quản lý cá nhân</li></a>
                    <a><li>Đổi mật khẩu</li></a>
                    <a href="logout"><li>Đăng xuất</li></a>
                </ul>
            </div>
        </s:if>
    </body>
</html>
