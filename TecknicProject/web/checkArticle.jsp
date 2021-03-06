<%-- 
    Document   : article
    Created on : 15-Oct-2017, 10:28:30
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknic | Tin tức công nghệ mỗi ngày</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="mainstyle.css">
        <link rel="stylesheet" href="indexStyle.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <script src="jquery.min.js" type="application/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="application/javascript"></script>
        <script src="UIControll.js" type="application/javascript"></script>
        <script src="trung/function.js" type="application/javascript"></script>
        <script src="tung/function.js" type="application/javascript"></script>
    </head>
    <body onsubmit="return false" >
        <s:include value="header.jsp"></s:include>
            <!-- sẽ cung cấp id của người dùng, và id cảu bài viết -->
            <input type="hidden" id="articleId" value='${requestScope.Article.id}'/>

        <div class="main selfclear fixPadingTop">
            <div class="postContaint">
                <div class="postTran">
                    <div class="postInfoTran fixPadding selfclear">
                        <div class="avatar avatarAbsolute">
                            <img src="${requestScope.Creator.avatar}">
                        </div>
                        <div class="info infoFixPaddingLeft col-xs-12 col-sm-8 col-md-8 col-lg-8">
                            <a><span class="poster">${requestScope.Creator.name}</span></a>
                            <br/>
                            <span class="datepost">${requestScope.Article.createTime}</span>
                        </div>
                        <div class="info col-xs-12 col-sm-4 col-md-4 col-lg-4">
                            <c:if test="${sessionScope.ROLE eq 'Administrator' || sessionScope.ROLE eq 'Colaborator' || sessionScope.ROLE eq 'Moderator'}">
                                <c:if test="${requestScope.Article.status eq 'submited' && sessionScope.ROLE != 'Colaborator'}">
                                    <div class="buttonCircle buttonSuccess" onclick="checkArticle(${requestScope.Article.id}, 3, ${sessionScope.ID}, null)"><i class="fa fa-check"></i></div>
                                    <div class="buttonCircle buttonWarning" onclick="showPopup('popupReject')"><i class="fa fa-times"></i></div>
                                </c:if>
                            </c:if>
                        </div>
                    </div>
                    <%--Chưa thêm hình--%>
                    <div class="postImage">
                        <%-- cho ảnh bài viết --%>
                        <img src="${requestScope.Article.coverImage}">
                    </div>
                    <div class="postTitle fixPadding widthNarrow">
                        <%-- cho tiêu đề của bài vào đây --%>
                        <p>${requestScope.Article.title}</p>
                    </div>
                    <div class="postBody fixPadding widthNarrow">
                        <%-- cho nội dung vào giữa thẻ div này, dung el epression chứ dừng đùng struts--%>
                        <p>${requestScope.Article.content}</p>
                    </div>

                </div>
            </div>
        </div>
        <s:include value="footer.jsp"></s:include>

            <div class="popup" id="popupReject">
                <div class="closebackground" onclick="closePopup('popupReject')"></div>
                <div class="popupcontain">
                    <i class="fa fa-times" onclick="closePopup('popupReject')"></i>
                    <p></p>
                    <div class="formContain" style="margin: 0">
                        <div class="inputText">
                            <label>Bạn muốn reject bài viết của ${requestScope.Creator.name}?</label>
                    </div>
                    <div class="inputText">
                        <label>Lý do</label>
                        <input type="text" id="txtReason"/>
                    </div>
                    <hr/>
                    <div class="buttonGroup">
                        <input class="button buttonPrimary" style="width: 100%" onclick="checkArticle(${requestScope.Article.id}, 4, ${sessionScope.ID}, document.getElementById('txtReason').value)" value="Ok">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
