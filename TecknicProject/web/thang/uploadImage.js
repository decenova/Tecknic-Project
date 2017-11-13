/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var hostLink = "http://192.168.137.1:8084/Tecknic/files/";

function getURLCoverImage() {
    var fd = new FormData();
    fd.append('file', $('#urlCoverImage')[0].files[0]);
    $.ajax({
        url: "upload_img",
        method: "POST",
        data: fd,
        processData: false,
        contentType: false,
        success: function (data) {
            if (data.link != null) {
                var link = data.link.split('/');
                link = link[link.length - 1];
                link = 'files/' + link;
                
                console.log(hostLink);
                console.log(link);
                $('#urlHidden').val(link);
                $('#imgShow').attr('src', link);
            } else {

            }
        }
    });
}
function getURLAvartarImage() {
    var fd = new FormData();
    fd.append('file', $('#urlCoverImage')[0].files[0]);
    $.ajax({
        url: "upload_img",
        method: "POST",
        data: fd,
        processData: false,
        contentType: false,
        success: function (data) {
            if (data.link != null) {
                var link = data.link.split('/');
                link = link[link.length - 1];
                link = 'files/' + link;
                $('#urlHidden').val(link);
                $('#imgShow').attr('src', link);
            } else {

            }
        }
    });
}
