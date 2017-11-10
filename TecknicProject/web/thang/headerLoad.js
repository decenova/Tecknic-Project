/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    showAllHeaderTag();
    $('#searchButton').click(function () {
        var tagId = $('#tagIdFilter').val();
        if (tagId === undefined)
            tagId = 0;
        var search = $('#search').val().toString().trim();
        window.location.href = 'loadIndex?tagId=' + tagId + '&search=' + search;
    });
});

function showAllHeaderTag() {
//    if (articleId === null || articleId === undefined) {
    $.ajax({
        method: 'GET',
        url: "/Tecknic/getTagListForNew",
        success: function (data) {
            var div = $("#categories");
            div.empty();
            var s = "";
            for (var tag in data.result) {
                s += "<a";
                s += " href='loadIndex?tagId=" + tag + "'";
                s += " ><li>";
                s += data.result[tag];
                s += "</li></a>";
            }
            div.append(s);
        }
    });
}

