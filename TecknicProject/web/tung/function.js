var size = 5;
var pos = 0;
var isLoad = false;
var countUser = 0;
function loadAutoUser() {
    $(document).ready(function () {
        size = 5;
        pos = 0;
        $('#allUserContain').empty();
        getAllUser(size, pos);
        $(window).scroll(function () {
            if (size > 0 && !isLoad && $(window).scrollTop() >= $(document).height() - $(window).height() - 100) {
                isLoad = true;
                pos += size;
                getAllUser(size, pos);
            }
        });
    });
}

//-------------------------------------------USER------------------------------------------
//lấy hết thành viên
function getAllUser(size, pos) {
    $.ajax({
        method: "POST",
        url: "/Tecknic/loadAll",
        data: {size: size, pos: pos},
        success: function (data) {
            var div = $("#allUserContain");
            var memberList = data.memberList;
            var s = '';
            if (memberList.length > 0) {
                for (var i = 0; i < memberList.length; i++) {
                    s += '<tr>';
                    s += '<td>' + ++countUser + '</td>';
                    s += '<td><a href=/Tecknic/viewOtherProfile?userId=' + memberList[i].id + '>' + memberList[i].username + '</a></td>';
                    s += '<td>' + memberList[i].name + '</td>';
                    s += '<td>' + memberList[i].email + '</td>';
                    s += '<td>' + memberList[i].role + '</td>';
                    s += '</tr>';
                }
            }
            div.append(s);
            isLoad = false;
        }
    });
}
//tìm thành viên theo tên


function findUserByLike() {
    $.ajax({
        method: "POST",
        url: "/Tecknic/searchLikeName",
        data: "searchName=" + $('#sName').val(),
        success: function (data) {
            var div = $("#allUserContain");
            div.empty();
            var searchUserList = data.searchUserList;
            var s = '';
            if (searchUserList.length > 0) {
                s += '<table class="table table-hover"><thead>';
                s += '<tr><th>No.</th><th>Username</th><th>Name</th><th>Email</th><th>Role</th>';
                s += '</tr></thead><tbody>';
                for (var i = 0; i < searchUserList.length; i++) {
                    s += '<tr>';
                    s += '<td>' + (i + 1) + '</td>';
                    s += '<td><a href=profile.jsp?userID="' + searchUserList[i].id + '">' + searchUserList[i].username + '</a></td>';
                    s += '<td>' + searchUserList[i].name + '</td>';
                    s += '<td>' + searchUserList[i].email + '</td>';
                    s += '<td>' + searchUserList[i].role + '</td>';
                    s += '</tr>';
                }
                s += '</tbody></table>';
            } else {
                s = '<p>No record is not found!</p>';
            }
            div.append(s);
        }
    });
}
//-------------------------------------------COMMENT------------------------------------------
//tải comment theo bài viết
function getCommentOfArticle() {
    console.log($('#articleId').val());
    $.ajax({
        method: "POST",
        url: "/Tecknic/loadComment",
        data: {articleId: $('#articleId').val()},
        success: function (data) {
            var div = $("#CommentContain");
            div.empty();
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
            }
            div.append(s);
        }
    });
}
//Thêm comment
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
            getCommentOfArticle();
        }
    });
}
//-------------------------------------------ARTICLE------------------------------------------
function findArticleByTitle() {
    $.ajax({
        method: "POST",
        url: "/Tecknic/findArticle",
        data: "searchTitle=" + $('#sTitle').val(),
        success: function (data) {
            var div = $("#ArticleContain");
            div.empty();
            var articleList = data.articleList;
            var s = "";
            if (articleList.length > 0) {
                s += '<table class="table table-hover">';
                s += '<thead><tr><th>No.</th><th>Title</th><th>Create time</th></tr></thead><tbody>';
                for (var i = 0; i < articleList.length; i++) {
                    s += '<tr><td>' + (i + 1) + '</td><td><a href="article.jsp?articleID=' + articleList[i].ID + '">';
                    s += articleList[i].title + '</a></td>';
                    s += '<td>' + articleList[i].txtCreateTime + '</td></tr>';
                }
                s += '</tbody></table>';
            } else {
                s = '<p>Không tìm thấy bài viết nào</p>';
            }
            div.append(s);
        }
    });
}
//Tag or Title
function findArticleByTagOrTitle() {
    var names = $('input:checked').map(function () {
        return $(this).val();
    }).get();
    $.ajax({
        method: "POST",
        url: "/Tecknic/findArticleV2",
        data: "searchTitle=" + $('#sTitle').val() + "&cbxTag=" + names,
        success: function (data) {
            var div = $("#ArticleContain");
            div.empty();
            var articleList = data.articleList;
            var s = "";
            if (articleList.length > 0) {
//                s += '<table class="table table-hover">';
//                s += '<thead><tr><th>No.</th><th>Title</th><th>Create time</th></tr></thead><tbody>';
                for (var i = 0; i < articleList.length; i++) {
                    s += '<tr><td>' + (i + 1) + '</td><td><a href="article.jsp?articleID=' + articleList[i].ID + '">';
                    s += articleList[i].title + '</a></td>';
                    s += '<td>' + articleList[i].txtCreateTime + '</td>';
                    s += '<td>' + articleList[i].status + '</td></tr>';
                }
//                s += '</tbody></table>';
            } else {
                s = '<p>Không tìm thấy bài viết nào</p>';
            }
            div.append(s);
        }
    });
    //-------------------------------------------URL Image Cover------------------------------------------
//đã chuyển sang thang/upfile
}

