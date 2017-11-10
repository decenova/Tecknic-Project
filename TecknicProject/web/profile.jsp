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
        <script src="trung/function.js" type="application/javascript"></script>
    </head>
    <body>
        <s:include value="header.jsp"></s:include>
            <div class="main selfclear fixPadingTop">
                <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
                <div class="profileContaint col-xs-12 col-sm-12 col-md-10 col-lg-10">
                    <div class="profileInfo">
                    <%--nếu là admin mới hiện lên ban or upgrade--%>
                    <s:if test="%{#session.ROLE == 'Administrator' and user.role != 'Administrator'}">
                        <div class="controlButton">
                            <div class="buttonCircle buttonSuccess" onclick="showPopup('popupUpgrade')"><i class="fa fa-plus"></i></div>
                            <div class="buttonCircle buttonDanger" onclick="showPopup('popupBan');autoFocus('txtReason')"><i class="fa fa-ban"></i></div>
                        </div>
                    </s:if>
                    <div class="avatar">
                        <img src="<s:property value="user.avatar"/>">
                    </div>
                    <div class="info">
                        <p class="member"><s:property value="user.name"/></p>
                        <p class="role"><s:property value="user.role"/></p>
                        <p class="numOfPost"><b><s:property value="otherNumOfArticle"/></b> bài viết</p>
                        <p class="datejoin">Ngày gia nhập: <span class="date"><s:property value="user.DOJ"/></span> </p>
                    </div>
                    <div class="tabControl selfclear">
                        <div class="tab tabSelect" onclick="showTab('#profile', this)">Thông tin cá nhân</div>
                        <div class="tab" onclick="showTab('#postHistory', this);
                                showArticleTab(<s:property value="userId"/>)">Bài viết</div>
                    </div>
                </div>
                <div class="profileMainContaint widthNarrow">
                    <div class="tabContent widthNarrow" id="profile">
                        <div class="formContain">
                            <h1>Thông tin cá nhân</h1>
                            <%-- chỗ thông tin của chủ profile này --%>
                            <div class="wallInfo">
                                <p>Giới tính: <s:property value="user.gender"/></p>
                                <p>Email: <s:property value="user.email"/></p>
                            </div>
                        </div>
                    </div>

                    <%-- trung: Tab show article --%>
                    <div class="tabContent widthNarrow fixPadding overTable" id="postHistory">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Create time</th>
                                </tr>
                            </thead>
                            <tbody id="userArticleList">
                                <%-- chỗ liệt kê bài viết, chỉ những bài đã được post mới hiện --%>
                                <!--                                <tr>
                                <%-- nhớ cho link đến action tạo bài viết --%>
                                <td><a href="post.html">Child of light: The dark of Luis V sẽ ra mắt vào tháng 11</a></td>
                                <td>12:30 12/3/2017</td>
                            </tr>
                            <tr>
                                <td><a href="post.html">Ori and the lind forest giảm giá mùa đông này</a></td>
                                <td>11:30 12/3/2017</td>
                            </tr>-->
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
        </div>


        <s:if test="%{#session.ROLE == 'Administrator' and user.role != 'Administrator'}">
            <div class="popup" id="popupUpgrade">
                <div class="closebackground" onclick="closePopup('popupUpgrade')"></div>
                <div class="popupcontain">
                    <i class="fa fa-times" onclick="closePopup('popupUpgrade')"></i>
                    <!--<form action="" method="POST">-->
                    <div class="formContain" style="margin: 0">
                        <div class="inputText">
                            <label>Vai trò*</label>
                            <select id="txtRole">       
                                <s:if test="%{user.roleId == 1}">
                                    <option id="role1" value="1" selected="true">Member</option>
                                    <option id="role2" value="2">Colaborator</option>
                                    <option id="role3" value="3">Moderator</option>
                                </s:if>
                                <s:elseif test="%{user.roleId == 2}">
                                    <option id="role1" value="1">Member</option>
                                    <option id="role2" value="2" selected="true">Colaborator</option>
                                    <option id="role3" value="3">Moderator</option>
                                </s:elseif>
                                <s:elseif test="%{user.roleId == 3}">
                                    <option id="role1" value="1">Member</option>
                                    <option id="role2" value="2">Colaborator</option>
                                    <option id="role3" value="3" selected="true">Moderator</option>
                                </s:elseif>
                            </select>
                        </div>
                        <hr/>
                        <div class="buttonGroup">
                            <input class="button buttonPrimary" style="width: 100%" onclick="upgradeMember(<s:property value="user.id"/>)" value="Ok">
                        </div>
                    </div>
                    <!--</form>-->
                </div>
            </div>
            <div class="popup" id="popupBan">
                <div class="closebackground" onclick="closePopup('popupBan')"></div>
                <div class="popupcontain">
                    <i class="fa fa-times" onclick="closePopup('popupBan')"></i>
                    <p></p>
                    <div class="formContain" style="margin: 0">
                        <div class="inputText">
                            <label>Bạn muốn cấm tài khoản <s:property value="user.username"/> của <s:property value="user.name"/>?</label>
                        </div>
                        <div class="inputText">
                            <label>Lý do</label>
                            <input type="text" id="txtReason"/>
                        </div>
                        <hr/>
                        <div class="buttonGroup">
                            <input class="button buttonPrimary" style="width: 100%" onclick="banMember(<s:property value="user.id"/>, <s:property value="#session.ID"/>)" value="Ok">
                        </div>
                    </div>
                </div>
            </div>
        </s:if>
        <s:include value="footer.jsp"></s:include>
    </body>
</html>
