/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var size = 5;
var pos = 0;
var isLoad = false;
var left = 0;
var leftFlag = -100;
var numOfBest = 0;
var slideInterval;
$(document).ready(function () {
    size = 5;
    pos = 0;
    $('#postContaint').empty();
    var tagId = $('#tagIdFilter').val();
    var search = $('#searchFilter').val();
    loadindex(size, pos, tagId, search);
    loadBestArticle();
    $(window).scroll(function () {
        if (size > 0 && !isLoad && $(window).scrollTop() >= $(document).height() - $(window).height() - 200) {
            isLoad = true;
            pos += size;
            loadindex(size, pos, tagId, search);
        }
    });
});
function checkEmpty() {
    if ($('#postContaint').html() == "") {
        $('#postContaint').append('<div style="height: 100%">' +
                '<h1 style="text-align: center;font-size: 5em;margin: auto">Sorry nha!<br/>Không có gì để đọc cả.</h1>'
                + '<div>');
    }
}
function loadindex(sizePage, positon, tagId, search) {
    var parent = $('#postContaint');
    var s = "";
    $.ajax({
        url: "indexLoadArticle",
        method: "post",
        data: {size: sizePage, pos: positon, tagId: tagId, search: search},
        success: function (data) {
            var array = data.json;
            if (array.length == 0) {
                size = 0;
                checkEmpty();
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
function loadNumOfComment(articleId) {
    var tag = $('#numOfComment' + articleId);
    $.ajax({
        url: "getAmountOfComment",
        method: "post",
        data: {articleId: articleId},
        success: function (data) {
            tag.text(data.numOfComment);
        }
    });
}


function loadBestArticle() {
    var tag = $('#slideContain');
    $.ajax({
        url: "loadBestArticle",
        method: "get",
        success: function (data) {
            var json = data.json;
            numOfBest = json.length;
            tag.empty();
            var s = "";
            for (var item in json){
                s += "<div class='slide' style='background-image: url(\""+ json[item].coverImage +"\")'>";
                s += "<a href='/Tecknic/showArticle?articleId="+json[item].ID+"'>"+ json[item].title +"</a>";
                s += "</div>";
            }
            tag.append(s);
            if (json.length < 5) {
                $('#slideContain').css("width", (numOfBest * 100) + "%");
                $('#slideContain .slide').css("width", (100 / numOfBest) + "%");
            }
            slideInterval = setInterval(slideShow,3000);
        }
    });
}

function slideShow(){
    var tag = $('#slideContain');
    if (left === (-100 * (numOfBest - 1)))
        leftFlag = 100;
    if (left === 0)
        leftFlag = -100;
    left += leftFlag;
    tag.animate({left: (left) + "%"},1000,"swing");
}


