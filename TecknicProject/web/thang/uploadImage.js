/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
                $('#urlHidden').val(data.link);
                $('#imgShow').attr('src', data.link);
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
                var link = data.link.replace('loadProfile','');
                console.log(link);
                $('#urlHidden').val(link);
                $('#imgShow').attr('src', link);
            } else {

            }
        }
    });
}
