function banMember(userId, modId) {
    var reason = document.getElementById("txtReason").value;
    $.ajax({
        method: 'POST',
        data: {userId: userId, modId: modId, reason: reason},
        url: "banMember",
        success: function (data) {
            location.reload();
        }
    });

}

function upgradeMember(userId) {
    var roleId = document.getElementById("txtRole").value;

    $.ajax({
        method: 'POST',
        data: {userId: userId, roleId: roleId},
        url: "upgradeMember",
        success: function (data) {
            location.reload();
        }
    });
}

function showAllTag(articleId) {
//    if (articleId === null || articleId === undefined) {
    $.ajax({
        method: 'GET',
        url: "/Tecknic/getTagListForNew",
        success: function (data) {
            var div = $("#tagList");
            div.empty();
            var s = "<label>Thể loại*</label>";
            for (var tag in data.result) {
                if (data.result.hasOwnProperty(tag)) {
                    s += "<p>";
                    s += "<input type='checkbox' name='cbxTag' value=" + tag + " id = " + tag;
                    s += " ";
                    s += "> " + data.result[tag];
                    s += "</p>";
                }
            }
            div.append(s);
            if (articleId !== null && articleId !== undefined)
                checkTag(articleId);
        }
    });
}

function showAllTag() {
//    if (articleId === null || articleId === undefined) {
    $.ajax({
        method: 'GET',
        url: "/Tecknic/getTagListForNew",
        success: function (data) {
            var div = $("#tagList");
            div.empty();
            var s = "<label>Thể loại*</label>";
            for (var tag in data.result) {
                if (data.result.hasOwnProperty(tag)) {
                    s += "<p>";
                    s += "<input type='checkbox' onblur='checkNewTag()' name='cbxTag' value=" + tag + " id = " + tag;
                    s += " ";
                    s += "> " + data.result[tag];
                    s += "</p>";
                }
            }
            div.append(s);
        }
    });
}

function checkTag(articleId) {
    $.ajax({
        method: 'GET',
        url: "/Tecknic/getTagListForEdit?articleId=" + articleId,
        success: function (data) {
            for (var tag in data.result) {
                if (data.result.hasOwnProperty(tag)) {
                    if (data.result[tag].check === 1) {
                        document.getElementById(tag).checked = true;
                    }
                }
            }
        }
    });
}



function showArticleTab(id) {
    $.ajax({
        method: 'GET',
        url: "/Tecknic/getUserArticleList?userId=" + id,
        success: function (data) {
            var div = $("#userArticleList");
            div.empty();
            var articleList = data.result;
            if (articleList.length > 0) {
                var s = "";
                for (var i = 0; i < articleList.length; i++) {
                    s += "<tr><td><a href='showArticle?articleId=" + articleList[i].id + "'>";
                    s += articleList[i].title;
                    s += "</a></td><td>";
                    s += articleList[i].createTime;
                    s += "</td></tr>";
                }
            } else {
                var tb = (div.parent()).parent();
                tb.empty();
                tb.append("<h3>Don't have Article</h3>");
            }
            div.append(s);
        }
    });
}

function showOwnArticleTab(id) {

    $.ajax({
        method: 'GET',
        url: "/Tecknic/getOwnArticleList?userId=" + id,
        success: function (data) {
            var div = $("#userArticleList");
            div.empty();
            var articleList = data.result;
            if (articleList.length > 0) {
                var s = "";
                for (var i = 0; i < articleList.length; i++) {
                    if (articleList[i].status === "posted") {
                        s += "<tr class='success'>";
                        s += "<td><a href='showArticle?articleId=" + articleList[i].id + "'>";
                        s += articleList[i].title;
                        s += "</a></td>";
                    } else if (articleList[i].status === "reject" || articleList[i].status === "remove") {
                        s += "<tr class='danger'>";
                        s += "<td><a href='showArticle?articleId=" + articleList[i].id + "'>";
                        s += articleList[i].title;
                        s += "</a></td>";
                    } else if (articleList[i].status === "reviewing") {
                        s += "<tr class='well'>";
                        s += "<td><a href='showArticle?articleId=" + articleList[i].id + "'>";
                        s += articleList[i].title;
                        s += "</a></td>";
                    } else if (articleList[i].status === "submited") {
                        s += "<tr class='warning'>";
                        s += "<td><a href='showArticle?articleId=" + articleList[i].id + "'>";
                        s += articleList[i].title;
                        s += "</a></td>";
                    } else {
                        s += "<tr>";
                        s += "<td><a href='showArticle?articleId=" + articleList[i].id + "'>";
                        s += articleList[i].title;
                        s += "</a></td>";
                    }


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
            div.append(s);
        }
    });
}

function checkArticle(articleId, statusId, modId, reason) {
    console.log(articleId);
    console.log(statusId);
    console.log(modId);
    console.log(reason);
    $.ajax({
        url: "checkArticle",
        data: {articleId: articleId, statusId: statusId, modId: modId, reason: reason},
        success: function (data) {
            window.location.replace("manager.jsp");
        }
    });
}


