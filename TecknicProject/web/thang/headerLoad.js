/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    showAllHeaderTag();
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
                s += " href='#" + tag + "'";
                s += " ><li>";
                s += data.result[tag];
                s += "</li></a>";
            }
            div.append(s);
        }
    });
}

