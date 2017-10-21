/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var popoverStr = '<div class="mypopover top mypopoverAlert">' +
        '<div class="arrow"></div>' +
        '<div class="popover-content"></div>' +
        '</div>';
function checkUsername() {
    var tag = $('#username');
    var value = tag.val();
//            lấy thẻ cha để có thể thêm vào cái popover 
    var parent = tag.parent();
    if (value === null || value.length <= 0 || value.length > 40) {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
        
        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Username không được để trống và không quá 40 kí tự');
        return false;
    } else {
        $.ajax({
            url: "checkusername",
            method: "post",
            data: {username: value},
            success: function (data) {
                if (!data.check) {
//                thêm popover
                    parent.children('div.mypopover').remove();
                    parent.append(popoverStr);
//                thêm câu thông báo vào popover
                    
                    tag.css({"border-left-color": "#ff8888"});
                    parent.find('div.popover-content').html('Username đã tồn tại');
                    return false;
                } else {
//                xóa popover nếu nhập đúng
                    tag.css({"border-left-color": "#226699"});
                    parent.children('div.mypopover').remove();
                    return true;
                }
            }
        });
    }
}

function checkName() {
    var tag = $('#name');
    var value = tag.val();
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
function checkPassword() {
    var tag = $('#password');
    var value = tag.val();
    var parent = tag.parent();
    if (value === null || value.length < 6 || value.length > 20
            || !(/[0-9]+/.test(value)) || !(/^[a-zA-Z0-9.,@#$%^&*()]*$/.test(value))) {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
        
        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Password phải có: <br/>' +
                ' + từ 6 đến 20 kí tự<br/>' +
                ' + chứa ít nhất một số [0-9]<br/>' +
                ' + có thể chứa các kí tự đặc biệt: . , @ # $ % ^ & * ( )');
        return false;
    } else {
        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}
function checkConfirmPassword() {
    var tag = $('#confirmPassword');
    var value = tag.val();
    var parent = tag.parent();
    if (!($('#password').val() === value)) {
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
function checkEmail() {
    var tag = $('#email');
    var value = tag.val();
    var parent = tag.parent();
    if (!(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+&/.test(value)) || value.length > 100) {
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
    var value = tag.val();
    var parent = tag.parent();
    if (!(/([0-9]{9,11})?/.test(value))) {
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
function checkCheckBox() {
    var tag = $('#checkbox');
    var value = tag[0].checked;
    var parent = tag.parent();
    if (!value) {
        parent.children('div.mypopover').remove();
        parent.append(popoverStr);
//        tag.css({"border-left-color": "#ff8888"});
        parent.find('div.popover-content').html('Đồng ý với điều khoản để đăng kí');
        return false;
    } else {
//        tag.css({"border-left-color": "#226699"});
        parent.children('div.mypopover').remove();
        return true;
    }
}

//Submit
function submit(tagId) {
    if (checkName() && checkUsername() && checkPassword() && checkConfirmPassword()
            && checkEmail() && checkPhone() && checkCheckBox())
        $(tagId)[0].submit();
}
