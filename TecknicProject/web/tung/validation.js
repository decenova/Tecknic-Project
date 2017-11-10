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
    if (checkName() && checkEmail() && checkPhone()){
        document.getElementById(tagId).submit();
    }
}
//-------------------------ARTICLE------------------------------------
function checkTitle() {
    var tag = $('#name');
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
    if (value === null || value.length <= 0 || value.length > 200) {
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
    var tag = $('#editor');
    var value = tag.val().toString().trim();
    //  lấy thẻ cha để có thể thêm vào cái popover
    var parent = tag.parent();
    if (value === null || value.length <= 0 || value.length > 200) {
//      thêm popover
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
//      thêm câu thông báo vào popover
        
        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Nội dung không thể không có');
        return false;
    } else {
//      xóa popover nếu nhập đúng
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
function checkNewTag() {
    var tag = $('#cbxTag');
    var value = tag.val();
    //  lấy thẻ cha để có thể thêm vào cái popover
    var parent = tag.parent();
    if (value === null) {
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
    if (checkTitle() && checkCoverImage() && checkContent() && checkNewTag()){
        document.getElementById(tagId).submit();
    } else {
        $(document).scrollTop(0);
    }
}
