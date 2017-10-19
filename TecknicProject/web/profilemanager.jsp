<%-- 
    Document   : profilemanager
    Created on : 15-Oct-2017, 16:53:06
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
            <div class="main selfclear fixPadingTop">
                <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
                <div class="profileContaint col-xs-12 col-sm-12 col-md-10 col-lg-10">
                    <div class="profileInfo">
                    <%-- làm giống bên trang profile.jsp --%>
                    <div class="avatar">
                        <img src="<s:property value="%{#request.Profile.avatar}"/>">
                    </div>
                    <div class="info">
<!--                        <p class="member">Trẩu Ăn Tre</p>-->
                        <p class="member"><s:property value="%{#request.Profile.name}"/></p>
                        <p class="role"><s:property value="%{#request.Profile.role}"/></p>
<!--                    tính sau-->
                        <p class="numOfPost"><b>2</b> bài viết</p> 
                        <p class="datejoin">Ngày gia nhập: <span class="date"><s:property value="%{#request.JoiningDate}"/></span> </p>
                    </div>
                    <div class="tabControl selfclear">
                        <div class="tab tabSelect" onclick="showTab('#profile', this)">Thông tin cá nhân</div>
                        <div class="tab" onclick="showTab('#postHistory', this)">Bài viết</div>
                    </div>
                </div>
                <div class="profileMainContaint widthNarrow">
                    <div class="tabContent widthNarrow" id="profile">
                        <form action="updateProfile" method="POST">
                            <%-- làm form --%>
                            <div class="formContain">
                                <h1>Thông tin cá nhân</h1>
                                <div class="inputText">
                                    <label>Avatar</label>
                                    <div class="avatar avatarProfile">
                                        <%-- avatar hiện tại, sẽ là avatar mới nếu input hình lên, nên dùng javascript để thực hiện --%>
<!--                                        <img src="img/avartar01.jpg">-->
                                        <img src="<s:property value="%{#request.Profile.avatar}"/>">
                                    </div>
                                    <input type="file" name="flAvatar" placeholder="Url hình ảnh">
                                </div>
                                <div class="inputText">
                                    <label>Tên</label>
                                    <input type="text" name="txtName" placeholder="Họ và tên" value="<s:property value="%{#request.Profile.name}"/>" required>
                                </div>
                                <hr/>
                                <div class="">
                                    <label>Giới tính*</label>
                                    <p><input type="radio" name="cbxGender" value="M" <s:if test="%{#request.Profile.gender eq 'M'}">checked</s:if>> Nam</p>
                                    <p><input type="radio" name="cbxGender" value="F" <s:if test="%{#request.Profile.gender eq 'F'}">checked</s:if>> Nữ</p>
                                    <p><input type="radio" name="cbxGender" value="O" <s:if test="%{#request.Profile.gender eq 'O'}">checked</s:if>> Giới tính khác</p>
                                </div>
                                <div class="inputText">
                                    <label>Ngày sinh</label>
                                    <input type="date" name="txtDob" value="<s:property value="%{#request.BirthDate}"/>">
                                </div>
                                <div class="inputText">
                                    <label>Email</label>
                                    <input type="email" name="txtEmail" value="<s:property value="%{#request.Profile.email}"/>" placeholder="example@gmail.com" required>
                                </div>
                                <div class="inputText">
                                    <label>Số điện thoại</label>
                                    <input type="text" name="txtPhoneNum" value="<s:property value="%{#request.Profile.phoneNum}"/>" name="txtPhoneNumber">
                                </div>
                                <div class="inputText">
                                    <label>Địa chỉ</label>
                                    <input type="text" name="txtAddress" value="<s:property value="%{#request.Profile.address}"/>">
                                </div>
                                <hr/>
                                <div class="buttonGroup">
                                    <div class="button buttonPrimary">
                                        <input style="background: inherit; border: 0" type="submit" value="Lưu thay đổi">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tabContent widthNarrow fixPadding" id="postHistory">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Create time</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%-- bảng những bài viết, bài viết bao gồm tất cả các trạng thái luôn --%>
                                <tr class="success">
                                    <td><a href="post.html">Child of light: The dark of Luis V sẽ ra mắt vào tháng 11</a></td>
                                    <td>12:30 12/3/2017</td>
                                    <td>Posted</td>
                                </tr>
                                <tr class="danger">
                                    <td><a href="post.html">Ori and the lind forest giảm giá mùa đông này</a></td>
                                    <td>11:30 12/3/2017</td>
                                    <td>Reject</td>
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
