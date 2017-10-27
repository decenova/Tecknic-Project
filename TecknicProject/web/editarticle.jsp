<%-- 
    Document   : editarticle
    Created on : 15-Oct-2017, 17:05:17
    Author     : Decen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tecknick | Edit</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="mainstyle.css">
        <link rel="stylesheet" href="loginStyle.css">
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <script src="jquery.min.js" type="application/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="application/javascript"></script>
        <script src="UIControll.js" type="application/javascript"></script>
        <%-- Text editor --%>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.css">

        <!-- Include Editor style. -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1/css/froala_editor.pkgd.min.css" rel="stylesheet" type="text/css" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1/css/froala_style.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <!-- Include external JS libs. -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/mode/xml/xml.min.js"></script>

        <!-- Include Editor JS files. -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1//js/froala_editor.pkgd.min.js"></script>
        <script>
            function showAllTag() {
                $.ajax({
                    type: 'GET',
                    url: "/Tecknic/getTagListForEdit?articleId=<s:property value="articleId"/>",
                    success: function (data) {
                        var div = $("#tagList");
                        div.empty();
                        var s = "<label>Thể loại*</label>";

                        for (var tag in data.result) {
                            if (data.result.hasOwnProperty(tag)) {
                                s += "<p>";
                                s += "<input type='checkbox' name='cbxTag' value=" + tag + " id = " + tag;
                                s += " ";

                                if (data.result[tag].check === 1) {
                                    s += "checked";
                                }

                                s += "> " + data.result[tag].name;
                                s += "</p>";
                            }
                        }
                        div.append(s);
                    }
                });
            }
        </script>
    </head>
    <body onload="showAllTag()">
        <s:include value="header.jsp"></s:include>
            <div class="main selfclear fixPadingTop">
                <form action="addArticle" method="POST">
                    <div class="formContain formBox">
                        <h1>Đăng bài</h1>
                        <div class="inputText">
                            <label>Tiêu đề*</label>
                            <input type="text" name="txtTitle" value="<s:property value="article.title"/>">
                    </div>
                    <div class="inputText">
                        <label>Ảnh bìa</label>
                        <input type="text" name="txtImage" placeholder="" value="<s:property value="article.coverImage"/>">
                    </div>
                    <hr/>
                    <div class="inputText">
                        <label>Nội dung*</label>
                        <textarea name="txtContent" id="editor"><s:property value="article.content"/></textarea>
                    </div>
                    <hr/>

                    <div class="" id="tagList">
<!--                        <label>Thể loại*</label>
                        <p><input type="checkbox" name="cbxTag" value="1" checked> Điện thoại</p>
                        <p><input type="checkbox" name="cbxTag" value="2"> Laptop</p>
                        <p><input type="checkbox" name="cbxTag" value="3"> Khác</p>-->
                    </div>

                    <hr/>
                    <div class="buttonGroup">
                        <div class="button buttonPrimary">
                            <input style="background: inherit; border: 0" type="submit" value="Đăng bài">
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <s:include value="header.jsp"></s:include>
        <script>
            $(function () {
                $('#editor').froalaEditor({
                    // Set the image upload URL.
                    imageUploadURL: 'upload_img',
                    imageUploadParams: {
                        id: 'my_editor'
                    }
                });
            });
        </script>
    </body>
</html>
