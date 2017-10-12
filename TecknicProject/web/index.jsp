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
    </head>
    <body>
        <s:include value="header.jsp"></s:include>
            <div class="main selfclear">
                <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
                <div class="postContaint col-xs-12 col-sm-12 col-md-10 col-lg-10">
                    
                    <%--đây là thẻ post dùng để chứa bài viết --%>
                    <%--dùng câu lệnh lặp cho cả cái div post này --%>
                    <div class="post">
                        <div class="postInfo fixPadding widthNarrow selfclear">
                            <div class="avatar">
                            <%--cho hình vào thẻ này --%>
                                <img src="img/avartar01.jpg">
                            </div>
                            <div class="info">
                                <%--cho tên vào thẻ này --%>
                                <a><span class="poster">Trẩu Ăn Tre</span></a>
                                <br/>
                                <%--cho ngày đăng vào thẻ này --%>
                                <span class="datepost">12:30 12/3/2017</span>
                            </div>
                        </div>
                        <div class="postImage">
                            <%--cho hình cover vào thẻ này --%>
                            <img src="img/cover02.jpg">
                        </div>
                        <div class="postTitle fixPadding widthNarrow">
                            <%--cho tiêu đề bài viết vào thẻ này --%>
                            <a href="post.html">Child of light: The dark of Luis V sẽ ra mắt vào tháng 11</a>
                        </div>
                        <div class="postBody fixPadding widthNarrow">
                            <%--cho một phần nội dung vào thẻ này, cái này phải xử lý SQL nên tính sau --%>
                            <a href="post.html">
                                Ra đời cách đây khá lâu, phiên bản một của tựa game Child of light đã thu hút rất nhiều người chơi
                                trên toàn thế giới. Và phiên bản này sẽ được tái xuất với phần hai The dark of Luis V
                            </a>
                        </div>
                        <hr/>
                        <div class="postControl fixPadding widthNarrow">
                            <%--cho số lượt xem và lượt comment vào thẻ này --%>
                            <span><i class="fa fa-eye"></i> 12000</span>
                            <span><i class="fa fa-comment-o"></i> 12</span>
                        </div>
                    </div>
                    <%--đây là kết thúc thẻ post --%>                  
                    
                </div>
                <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
            </div>
        <s:include value="footer.jsp"></s:include>
    </body>
</html>
