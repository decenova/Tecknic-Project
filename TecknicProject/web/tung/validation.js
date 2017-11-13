/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var popoverStr = '<div class="mypopover top mypopoverAlert">' +
        '<div class="arrow"></div>' +
        '<div class="popover-content"></div>' +
        '</div>';

function checkName() {
    var tag = $('#name');
    var value = tag.val().toString().trim();
    //  lấy thẻ cha để có thể thêm vào cái popover
    var parent = tag.parent();
    if (value === null || value.length <= 0 || value.length > 100) {
//      thêm popover
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
//      thêm câu thông báo vào popover

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Tên không được để trống và không dài quá 100 kí tự');
        return false;
    } else {
//      xóa popover nếu nhập đúng
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}

function checkEmail() {
    var tag = $('#email');
    var value = tag.val().toString().trim();
    var parent = tag.parent();
    if (!(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+$/.test(value)) || value.length > 100) {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Email không để trống<br/>Email theo format: example@abc.xyz');
        return false;
    } else {
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
function checkPhone() {
    var tag = $('#phone');
    var value = tag.val().toString().trim();
    var parent = tag.parent();
    if (!(/^([0-9]{9,11})?$/.test(value))) {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Số điện thoại chỉ chứa chữ số');
        return false;
    } else {
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
function updateUser(tagId) {
    if (checkName() && checkEmail() && checkPhone()) {
        document.getElementById(tagId).submit();
    }
}
//-------------------------ARTICLE------------------------------------
function checkTitle() {
    var tag = $('#title');
    var value = tag.val().toString().trim();
    //  lấy thẻ cha để có thể thêm vào cái popover
    var parent = tag.parent();
    if (value === null || value.length <= 0 || value.length > 200) {
//      thêm popover
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
//      thêm câu thông báo vào popover

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Tiêu đề bài viết không được để trống và không dài quá 200 kí tự');
        return false;
    } else {
//      xóa popover nếu nhập đúng
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
function checkCoverImage() {
    var tag = $('#urlHidden');
    var value = tag.val().toString().trim();
    //  lấy thẻ cha để có thể thêm vào cái popover
    var parent = tag.parent();
    if (value === null || value.length <= 0) {
//      thêm popover
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
//      thêm câu thông báo vào popover

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Bài viết không thể thiếu ảnh bìa');
        return false;
    } else {
//      xóa popover nếu nhập đúng
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
function checkContent() {
    var tag = $('div.fr-element.fr-view')[0];
    var value = $(tag).text().toString().trim();
    //  lấy thẻ cha để có thể thêm vào cái popover
    var parent = $('#editorParent');
    if (value === null || value.length <= 0) {
//      thêm popover
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
//      thêm câu thông báo vào popover

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Nội dung không thể không có kí tự nào');
        return false;
    } else {
//      xóa popover nếu nhập đúng
        parent.children('div.mypopover').remove();
        return true;
    }
}
function checkNewTag() {
    var tag = $('[name="cbxTag"]:checked');
    //  lấy thẻ cha để có thể thêm vào cái popover
    var parent = $('#tagList');
    if (tag.length === 0) {
//      thêm popover
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
//      thêm câu thông báo vào popover

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Hãy chọn thể loại của bài viết');
        return false;
    } else {
//      xóa popover nếu nhập đúng
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
//sửa checkTag thành checkNewTag
function addPost(tagId) {
    if (checkTitle() && checkCoverImage() && checkContent() && checkNewTag()) {
        document.getElementById(tagId).submit();
    } else {
        if (!checkTitle() || !checkCoverImage())
            $(document).scrollTop(0);
        else
            $(document).scrollTop(1000);
    }
}

function checkNewTag() {
    var tag = $('[name="cbxTag"]:checked');
    //  lấy thẻ cha để có thể thêm vào cái popover
    var parent = $('#tagList');
    if (tag.length === 0) {
//      thêm popover
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
//      thêm câu thông báo vào popover

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Hãy chọn thể loại của bài viết');
        return false;
    } else {
//      xóa popover nếu nhập đúng
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}

function checkOldPasword() {
    var check = false;
    var tag = $('#old');
    var value = tag.val().toString().trim();
//            lấy thẻ cha để có thể thêm vào cái popover 
    var parent = tag.parent();
    if (value === null || value.length === 0) {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Mật khẩu cũ không thể bỏ trống!');
        check = false;
    } else {
        $.ajax({
            url: "checkPwd",
            method: "post",
            async: false,
            data: {oldPassword: value},
            success: function (data) {
                if (!data.checkRight) {
//                thêm popover
                    parent.children('div.mypopover').remove();
                    parent.append(popoverStr);
//                thêm câu thông báo vào popover

                    tag.css({"border-left-color": "#ff8888"});
                    parent.find('div.popover-content').html('Mật khẩu cũ không đúng');
                    check = false;
                } else {
//                xóa popover nếu nhập đúng
                    tag.css({"border-left-color": "#226699"});
                    parent.children('div.mypopover').remove();
                    check = true;
                }
            }
        });
    }
    return check;
}
function checkPass() {
    var tag = $('#new');
    var value = tag.val().toString().trim();
    var parent = tag.parent();
    if (value === null || value.length < 6 || value.length > 20
            || !(/[0-9]+/.test(value)) || !(/^[a-zA-Z0-9.,@#$%^&*()]*$/.test(value))) {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
        
        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Password phải có: <br/>' +
                ' + Từ 6 đến 20 kí tự<br/>' +
                ' + Chứa ít nhất một số [0-9]<br/>' +
                ' + Có thể chứa các kí tự đặc biệt: . , @ # $ % ^ & * ( )');
        return false;
    } else {
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
function checkConfirmPassword() {
    var tag = $('#confirm');
    var value = tag.val().toString().trim();
    var parent = tag.parent();
    if (!($('#new').val() === value)) {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);

        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Không trùng với password trên');
        return false;
    } else {
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
function submitChangePassword(tagId) {
    if (checkOldPasword && checkPass() && checkConfirmPassword()) {
        document.getElementById(tagId).submit();
    }
}

function checkEndDay() {
    var tag = $('#endDay');
    var value = tag.val().toString().trim();
    console.log(value);
    var startDay = new Date($('#startDay').val());
    var endDay = new Date($('#endDay').val());
    var parent = tag.parent();
     if (startDay > endDay) {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Ngày kết thúc không thể trước ngày bắt đầu!');
        return false;
    } else {
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
function checkNullDay(day) {
    var tag = $(day);
    var value = tag.val();
    console.log(tag);
    var parent = tag.parent();
     if (value === null || value === "") {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Nhập ngày trước khi tìm kiếm');
        return false;
    } else {
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
