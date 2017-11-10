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
        <script src="tung/function.js" type="application/javascript"></script>
        <script src="trung/managerAjax.js" type="application/javascript"></script>
    </head>
    <body onsubmit="return false">
        <s:include value="header.jsp"></s:include>
            <div class="main selfclear fixPadingTop">
                <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
                <div class="managerContaint col-xs-12 col-sm-12 col-md-10 col-lg-10">
                    <div class="managerInfo">
                        <div class="info">
                            <p class="title">Manager page</p>
                            <p class="role"><s:property value="#session.ROLE"/></p>
                            <p class="numOfPost"><b>2</b> bài viết chưa duyệt</p>
                        </div>
                        <div class="tabControl selfclear">
                            <div class="tab tabSelect" onclick="showTab('#postHistory', this)">Bài viết</div>
                            <div class="tab" onclick="showTab('#searchProfile', this)">Thông tin thành viên</div>
                            <div class="tab" onclick="showTab('#report', this)">Thống kê</div>
                        </div>
                    </div>
                    <div class="profileMainContaint widthNarrow">
                        <div class="tabContent widthNarrow" id="searchProfile">
                            <!--                            <form>-->
                            <div class="formContain">
                                <div class="inputText">
                                    <label>Tìm kiếm tài khoản</label>
                                    <input id="sName" type="text" name="searchName">
                                    <div class="buttonGroup">
                                        <button class="button buttonPrimary" onclick="findUserByLike()"> <i class="fa fa-search"></i> </button>
                                    </div>
                                </div>
                                <hr/>
                                <div class="overTable">
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>STT</th>
                                                <th>Tài khoản</th>
                                                <th>Tên thành viên</th>
                                                <th>Email</th>
                                                <th>Chức vụ</th>
                                            </tr>
                                        </thead>
                                        <tbody id="allUserContain">
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--                        </form>-->
                        </div>
                        <div class="tabContent widthNarrow" id="postHistory">
                            <form>
                                <div class="formContain">
                                    <!--<h1>Bài viết</h1>-->
                                    <div class="inputText">
                                        <label>Tìm kiếm bài viết</label>
                                        <input type="text" name="searchTitle" id="sTitle">
                                        <div class="buttonGroup">
                                            <button class="button buttonPrimary" onclick="findArticleByTagOrTitle()"><i class="fa fa-search"></i></button>
                                        </div>
                                    </div>
                                    <div class="">
                                        <label>Thể loại</label>
                                        <span><input type="checkbox" name="cbxTag" value="1" checked> Điện thoại</span>
                                        <span><input type="checkbox" name="cbxTag" value="2"> Laptop</span>
                                        <span><input type="checkbox" name="cbxTag" value="3"> Khác</span>
                                    </div>
                                    <hr/>
                                    <!--<div class="overTable" id="ArticleContain">
                                    dua cai lis vao day ne
                                    </div>-->
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>STT</th>
                                                <th>Tiêu đề</th>
                                                <th>Ngày tạo</th>
                                                <th>Trạng thái</th>
                                            </tr>
                                        </thead>
                                        <tbody id="ArticleContain">
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </form>
                        </div>
                        <div class="tabContent widthNarrow" id="report">
                            <!--                            <form>-->
                            <div class="formContain">
                                <h2>Tài khoản mới có nhiều lượt xem nhất</h2>
                                <div class="inputText">
                                    <label>Từ ngày</label>
                                    <input id="startDay" type="date" name="startDay">
                                </div>
                                <div class="inputText">
                                    <label>Từ ngày</label>
                                    <input id="endDay" type="date" name="endDay">
                                </div>
                                <br/>
                                <div class="buttonGroup">
                                    <div class="button buttonPrimary" onclick="findUserByLike()"> <i class="fa fa-search"></i> </div>
                                </div>
                                <br/>
                                <div class="overTable" id="bestUserContain">
                                </div>
                            </div>
                            <!--                        </form>-->
                        </div>
                    </div>
                </div>
                <div class="hidden-xs hidden-sm col-md-1 col-lg-1"></div>
            </div>                          
            <script>
                loadAutoArticle();
                loadAutoUser();
            </script>                              
        <s:include value="footer.jsp"></s:include>        
    </body>
</html>
