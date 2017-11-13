var size = 5;
var pos = 0;    
var countArticle = 0;

function loadAutoArticle() {
    $(document).ready(function () {
        size = 5;
        pos = 0;
        $('#ArticleContain').empty();
        loadUncheckArticle(size, pos);
    });
}
function loadUncheckArticle(sizePage, positon) {
    var parent = $('#ArticleContain');
    $.ajax({
        url: "loadUncheckArticle",
        method: "post",
        data: {size: sizePage, pos: positon},
        success: function (data) {
            var articleList = data.result;
            if (articleList.length > 0) {
                var s = "";
                for (var i = 0; i < articleList.length; i++) {
                    s += "<tr>";
                    s += "<td>" + ++countArticle + "</td>";
                    s += "<td><a href='showArticleForCheck?articleId=" + articleList[i].id + "'>";
                    s += articleList[i].title;
                    s += "</a></td>";
                    s += "<td>";
                    s += articleList[i].createTime;
                    s += "</td><td>";
                    s += articleList[i].status;
                    s += "</td></tr>";
                }
            }
            parent.append(s);
            
            if (articleList.length === 5) {
                $('#ViewMoreUncheckArticle').empty();
                var d = "";
                pos += size;
                d += '<a onclick="loadUncheckArticle(' + size + ',' + pos + ')">Lấy thêm bài viết</a>';
                $('#ViewMoreUncheckArticle').append(d);
            } else {
                 $('#ViewMoreUncheckArticle').empty();
            }
        }
    });
}

