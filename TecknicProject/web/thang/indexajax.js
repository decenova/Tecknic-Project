/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var size = 5;
var pos = 0;
var isLoad = false;
$(document).ready(function () {
    size = 5;
    pos = 0;
    $('#postContaint').empty();
    var tagId = $('#tagIdFilter').val();
    if (tagId == null || tagId == undefined){
        loadindex(size, pos);
        $(window).scroll(function () {

            if (size > 0 && !isLoad && $(window).scrollTop() >= $(document).height() - $(window).height() - 200) {
                isLoad = true;
                pos += size;
                loadindex(size, pos);
            }
        });
    } else {
        loadindex(size, pos, tagId);
        $(window).scroll(function () {

            if (size > 0 && !isLoad && $(window).scrollTop() >= $(document).height() - $(window).height() - 200) {
                isLoad = true;
                pos += size;
                loadindex(size, pos, tagId);
            }
        });
    }
});
function loadindex(sizePage, positon) {
    var parent = $('#postContaint');
    var s = "";
    $.ajax({
        url: "indexLoadArticle",
        method: "post",
        data: {size: sizePage, pos: positon, tagId:0},
        success: function (data) {
            var array = data.json;
            if (array.length == 0){
                size = 0;
                return;
            }
            var json;
            for (var i = 0; i < array.length; i++) {
                json = array[i];
                s = "";
                s += '<div class="post">';
                s += '<div class="postInfo fixPadding widthNarrow selfclear">';
                s += '    <div class="avatar">';
                s += '        <img src="' + json[1].avatar + '">';
                s += '    </div>';
                s += '    <div class="info">';
                s += '        <a href="/Tecknic/viewOtherProfile?userId=' + json[1].id + '"><span class="poster">' + json[1].name + '</span></a>';
                s += '        <br/>';
                s += '        <span class="datepost">' + json[0].modifyTime + '</span>';
                s += '    </div>';
                s += '</div>';
                s += '<div class="postImage">';
                s += '    <img src="' + json[0].coverImage + '">';
                s += '</div>';
                s += '<div class="postTitle fixPadding widthNarrow">';
                s += '    <a href="/Tecknic/showArticle?articleId=' + json[0].ID + '">' + json[0].title + '</a>';
                s += '</div>';
                s += '<div class="postBody fixPadding widthNarrow">';
                s += '    <a href="/Tecknic/showArticle?articleId=' + json[0].ID + '">' + $(json[0].content).text() + '</a>';
                s += '</div>';
                s += '<hr/>';
                s += '<div class="postControl fixPadding widthNarrow">';
                s += '    <span><i class="fa fa-eye"></i> ' + json[0].numOfView + '</span>';
                s += '    <span><i class="fa fa-comment-o"></i> <span id="numOfComment' + json[0].ID + '">0</span></span>';
                s += '</div>';
                s += '</div>';
                parent.append(s);
                loadNumOfComment(json[0].ID);
            }
            isLoad = false;
        }
    });
}
function loadindex(sizePage, positon, tagId) {
    var parent = $('#postContaint');
    var s = "";
    $.ajax({
        url: "indexLoadArticle",
        method: "post",
        data: {size: sizePage, pos: positon, tagId: tagId},
        success: function (data) {
            var array = data.json;
            if (array.length == 0){
                size = 0;
                return;
            }
            var json;
            for (var i = 0; i < array.length; i++) {
                json = array[i];
                s = "";
                s += '<div class="post">';
                s += '<div class="postInfo fixPadding widthNarrow selfclear">';
                s += '    <div class="avatar">';
                s += '        <img src="' + json[1].avatar + '">';
                s += '    </div>';
                s += '    <div class="info">';
                s += '        <a href="/Tecknic/viewOtherProfile?userId=' + json[1].id + '"><span class="poster">' + json[1].name + '</span></a>';
                s += '        <br/>';
                s += '        <span class="datepost">' + json[0].modifyTime + '</span>';
                s += '    </div>';
                s += '</div>';
                s += '<div class="postImage">';
                s += '    <img src="' + json[0].coverImage + '">';
                s += '</div>';
                s += '<div class="postTitle fixPadding widthNarrow">';
                s += '    <a href="/Tecknic/showArticle?articleId=' + json[0].ID + '">' + json[0].title + '</a>';
                s += '</div>';
                s += '<div class="postBody fixPadding widthNarrow">';
                s += '    <a href="/Tecknic/showArticle?articleId=' + json[0].ID + '">' + $(json[0].content).text() + '</a>';
                s += '</div>';
                s += '<hr/>';
                s += '<div class="postControl fixPadding widthNarrow">';
                s += '    <span><i class="fa fa-eye"></i> ' + json[0].numOfView + '</span>';
                s += '    <span><i class="fa fa-comment-o"></i> <span id="numOfComment' + json[0].ID + '">0</span></span>';
                s += '</div>';
                s += '</div>';
                parent.append(s);
                loadNumOfComment(json[0].ID);
            }
            isLoad = false;
        }
    });
}
function loadNumOfComment(articleId){
    var tag = $('#numOfComment' + articleId);
    $.ajax({
       url: "getAmountOfComment",
       method: "post",
       data: {articleId:articleId},
       success: function (data){
           tag.text(data.numOfComment);
       }
    });
}


