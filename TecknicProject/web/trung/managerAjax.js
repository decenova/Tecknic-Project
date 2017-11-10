var size = 5;
var pos = 0;

$(document).ready(function () {
    size = 5;
    pos = 0;
    $('#ArticleContain').empty();
    loadUncheckArticle(size, pos);
//    $(window).scroll(function () {
//        
//        if (size > 0 && !isLoad && $(window).scrollTop() >= $(document).height() - $(window).height() - 200) {
//            isLoad = true;
//            pos += size;
//            loadindex(size, pos);
//        }
//    });
});
function loadUncheckArticle(sizePage, positon) {
    var parent = $('#ArticleContain');
    var s = "";
    $.ajax({
        url: "loadUncheckArticle",
        method: "post",
        data: {size: sizePage, pos: positon},
        success: function (data) {
            $('#ArticleContain').empty();
            var articleList = data.result;
            if (articleList.length > 0) {
                var s = "";
                for (var i = 0; i < articleList.length; i++) {

                    s += "<tr>";
                    s += "<td><a href='showArticle?articleId=" + articleList[i].id + "'>";
                    s += articleList[i].title;
                    s += "</a></td>";
                    s += "<td>";
                    s += articleList[i].createTime;
                    s += "</td><td>";
                    s += articleList[i].status;
                    s += "</td></tr>";
                }
            } else {
                var tb = (div.parent()).parent();
                tb.empty();
                tb.append("<h3>Don't have Article</h3>");
            }
            parent.append(s);
        }
    });
}

