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
    });
}
//------------------------------------------REPORT---------------------------------
function getUserReport(from, to) {
    if (checkNullDay('#startDay') && checkNullDay('#endDay') && checkEndDay()) {
        $.ajax({
            method: "POST",
            url: "getUserReport",
            data: {txtFrom: from, txtTo: to},
            success: function (data) {
                var div = $("#bestUserContain");
                div.empty();
                var listBestUser = data.arrayList;
                var s = '';
                if (listBestUser.length > 0) {
                    s += '<table class="table table-hover">';
                    s += '<thead><tr><th>STT</th><th>Tài khoản</th><th>Tên thành viên</th><th>Ngày tham gia</th><th>Tổng lượt xem bài viết</th></tr></thead><tbody>';
                    for (var i = 0; i < listBestUser.length; i++) {
                        s += '<tr>';
                        s += '<td>' + (i + 1) + '</td>';
                        s += '<td><a href="/Tecknic/viewOtherProfile?userId=' + listBestUser[i].id + '">' + listBestUser[i].username + '</a></td>';
                        s += '<td>' + listBestUser[i].name + '</td>';
                        s += '<td>' + listBestUser[i].txtDateOfJoin + '</td>';
                        s += '<td>' + listBestUser[i].totalOfView + '</td>';
                    }
                    s += '</tbody></table>';
                } else {
                    s = '<p>Không có thành viên nào</p>';
                }
                div.append(s);
            }

        });
    }
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
            } else {
                s = '<p>Không có thành viên nào</p>';
            }
            div.append(s);


            if (memberList.length === 5) {
                $('#ViewMoreUser').empty();
                var d = "";
                pos += size;
                d += '<a onclick="getAllUser(' + size + ',' + pos + ')">Tải thêm thành viên</a>';
                $('#ViewMoreUser').append(d);
            } else {
                $('#ViewMoreUser').empty();
            }
        }
    });
}
//tìm thành viên theo tên


function findUserByLike() {
    if (checkSearchName('#sName')) {
        $.ajax({
            method: "POST",
            url: "/Tecknic/searchLikeName",
            data: "searchName=" + $('#sName').val(),
            success: function (data) {
                var parent = $("#userContain");
                parent.show();
                var div = $("#allUserContain");
                var noti = $("#showNoRecordUser");
                noti.empty();
                div.empty();
                var searchUserList = data.searchUserList;
                var s = '';
                if (searchUserList.length > 0) {
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
                    parent.hide();
                    $('#ViewMoreUser').hide();
                    var tmpS = 'Không tìm thấy bài viết nào';
                    noti.html(tmpS);
                }
                div.append(s);
            }
        });
    }
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
    if (checkSearchName('#sTitle')) {
        var names = $('input:checked').map(function () {
            return $(this).val();
        }).get();
        $.ajax({
            method: "POST",
            url: "/Tecknic/findArticleV2",
            data: "searchTitle=" + $('#sTitle').val() + "&cbxTag=" + names,
            success: function (data) {
                var parent = $('#tbArticle');
                parent.show();
                var div = $("#ArticleContain");
                var noti = $('#showNoRecord');
                div.empty();
                var articleList = data.articleList;
                var s = "";
                if (articleList.length > 0) {
                    noti.empty();
                    for (var i = 0; i < articleList.length; i++) {
                        s += '<tr><td>' + (i + 1) + '</td><td><a href="showArticleForCheck?articleID=' + articleList[i].ID + '">';
                        s += articleList[i].title + '</a></td>';
                        s += '<td>' + articleList[i].txtCreateTime + '</td>';
                        s += '<td>' + articleList[i].status + '</td></tr>';
                    }
                } else {
                    parent.hide();
                    $('#ViewMoreUncheckArticle').hide();
                    var tmpS = 'Không tìm thấy bài viết nào';
                    noti.html(tmpS);
                }
                div.append(s);
            }
        });
    }
}
//-------------------------------------------URL Image Cover------------------------------------------
//đã chuyển sang thang/upfile
//------------------------------
function getAmountOfUnchecked() {
    var number;
    $.ajax({
        method: "POST",
        url: "getAmountOfUnchecked",
        success: function (data) {
            $('#numOfUnchecked').html(data.numberOfUnchecked);
            number = data.numberOfUnchecked;
        }
    });
    return number;
}


