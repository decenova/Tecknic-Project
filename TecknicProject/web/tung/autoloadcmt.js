var size = 5;
var pos = 0;
var isLoad = false;


$(document).ready(function () {
    size = 5;
    pos = 0;
    getCommentOfArticleV2(size, pos);
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

function addCommentToArticle() {
    if ($('#contentComment').val().toString().trim().length <= 0)
        return;
    $.ajax({
        method: "POST",
        url: "/Tecknic/addComment",
        data: "txtComment=" + $('#contentComment').val() + "&articleID=" + $('#articleId').val(),
        success: function () {
            $('#contentComment').val("");
            $('#numOfComment').text(Number($('#numOfComment').text()) + 1);
            $("#CommentContain").empty();
            pos = 0;
            getCommentOfArticleV2(5,0);
        }
    });
}
function removeCmtById(cmtId) {
    $.ajax({
        method: "POST",
        url: "removeCmt",
        data: {cmtId: cmtId},
        success: function () {
            $('#contentComment').val("");
            $('#numOfComment').text(Number($('#numOfComment').text()) - 1);
            $("#CommentContain").empty();
            pos = 0;
            getCommentOfArticleV2(5,0);
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
                    s += '<div class="commentContain fixPadding widthNarrow"><div class="comment" style="position: relative">';
                    if ($("#cmtUserId").val() == commentList[i].userID) {
                        s += '<i onclick="removeCmtById('+ commentList[i].ID +')" class="fa fa-times" style="position: absolute;right: 10px;"></i>';
                    }
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
                s += '<a id="linkCmt" onclick="goNextCmt()"><p style="text-align: center;">Xem thêm bình luận</p></a>';
            }
            }
            div.append(s);
            isLoad = false;
        }
    });
}

