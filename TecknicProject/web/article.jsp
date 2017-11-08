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
                                    <c:if test="${requestScope.Article.status eq 'reviewing' && sessionScope.ROLE != 'Colaborator'}">
                                        <div class="buttonCircle buttonSuccess"><i class="fa fa-check"></i></div>
                                        <div class="buttonCircle buttonWarning"><i class="fa fa-times"></i></div>
                                    </c:if>
                                    <c:if test="${sessionScope.ROLE eq 'Administrator' && requestScope.Article.status eq 'posted'}">
                                        <div class="buttonCircle buttonDanger"><i class="fa fa-trash"></i></div>
                                    </c:if>
                                    <c:if test="${requestScope.Article.status != 'posted' && requestScope.Article.creatorId eq sessionScope.ID}">
                                        <a href="getArticleForUpdate?articleId=${requestScope.Article.id}"><div class="buttonCircle buttonDanger"><i class="fa fa-pencil"></i></div></a>
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
                    <hr/>
                    <div class="postControl fixPadding widthNarrow">
                        <%-- số lượt view và số lượt bình luận --%>
                        <span><i class="fa fa-eye"></i> ${requestScope.Article.numOfView}</span>
                        <span><i class="fa fa-comment-o"></i> 12</span>
                    </div>
                    <hr>
                    <s:if test="%{#session.ROLE != null}">
                        <%-- chỗ comment của người dùng --%>
                        <div class="commentContain fixPadding widthNarrow">
                            <div class="comment">
                                <div class="commentInfo">
                                    <div class="avatar">
                                        <%-- cho avatar của user đang đọc bài viết --%>
                                        <img src="<s:property value="%{#session.AVATAR}"/>">
                                    </div>
                                    <div class="info">
                                        <%-- cho tên user đang đọc bài viết --%>
                                        <a><span class="poster"><s:property value="%{#session.NAME}"/></span></a>
                                        <br/>
                                        <span class="datepost"></span>
                                    </div>
                                </div>
                                <form>
                                    <div class="commentContent">
                                        <%-- nhúng texteditor --%>
                                        <textarea id="contentComment" name="txtComment" rows="4"></textarea>
                                        <button class="button buttonPrimary" onclick="addCommentToArticle()"><i class="fa fa-send"></i></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </s:if>
                    <s:else>
                        <div class="fixPadding widthNarrow">
                            <p>Hãy <a href="login.jsp">đăng nhập</a> để có thể bình luận cùng mọi người!</p>
                        </div>
                    </s:else>
                    <hr>
                    <!-- Tung xử lý ajax -->
                    <div id="CommentContain">

                    </div>
                </div>
            </div>
        </div>
        <script>
            getCommentOfArticle();
        </script>
        <s:include value="footer.jsp"></s:include>
    </body>
</html>
