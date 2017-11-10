var size = 5;
var pos = 0;
var isLoad = false;
$(document).ready(function () {
    size = 5;
    pos = 0;
//    $('#CommentContain').empty();
    getCommentOfArticleV2(size, pos);
//        $(window).scroll(function () {
//            if (size > 0 && !isLoad && $(window).scrollTop() >= $(document).height() - $(window).height() - 200) {
//                isLoad = true;
//                pos += size;
//                getCommentOfArticleV2(size, pos);
//            }
//        });

});
function goNextCmt() {
    $('#linkCmt').hide();
    pos += size;
    getCommentOfArticleV2(size, pos);
    $(window).scroll(function () {
            if (size > 0 && !isLoad && $(window).scrollTop() >= $(document).height() - $(window).height() - 200) {
                isLoad = true;
                pos += size;
                getCommentOfArticleV2(size, pos);
            }
        });
}

function getCommentOfArticleV2(sizePage, position) {
    $.ajax({
        url: "/Tecknic/loadAutoCmt",
        method: "POST",
        data: {articleId: $('#articleId').val(), size: sizePage, pos: position},
        success: function (data) {
            var div = $("#CommentContain");
            var commentList = data.commentList;
            if (commentList.length > 0) {
                var s = "";
                for (var i = 0; i < commentList.length; i++) {
                    s += '<div class="commentContain fixPadding widthNarrow"><div class="comment">';
                    s += '<div class="commentInfo"><div class="avatar">';
                    s += '<img src="' + commentList[i].avatarUser + '">';
                    s += '</div><div class="info">';
                    s += '<a><span class="poster">' + commentList[i].nameUser + '</span></a>';
                    s += '<br/><span class="datepost">' + commentList[i].txtCreateTime + '</span>';
                    s += '</div></div><div class="commentContent">';
                    s += '<p>' + commentList[i].content + '</p>';
                    s += '</div>';
                    s += '<div class="commentIndex">#' + commentList[i].ID + '</div><hr/></div></div>';
                }
                if (pos === 0 && commentList.length >= 5) {
                s += '<a id="linkCmt" onclick="goNextCmt()">Xem thêm bình luận</a>';
            }
            }
            div.append(s);
            isLoad = false;
        }
    });
}

