/**
 * Created by Decen on 28/09/2017.
 */
$(document).ready(function(){
    document.addEventListener("scroll", headerControl);
})

function showTab(id,tag) {
    $(".tabContent").hide();
    $(".tab").removeClass("tabSelect");
    $(tag).addClass("tabSelect");
    $(id).show();
}
function showNav() {
    $("nav").fadeIn(100);
}
function closeNav() {
    $("nav").fadeOut(100);
}
function userMenuToggle() {
    $(".userMenu").fadeToggle(100);
}

function showPopup(id) {
    $("#" + id).fadeIn(100);
}
function closePopup(id) {
    $("#" + id).fadeOut(100);
}

function headerControl() {
    if (window.pageYOffset <= 600)
        $('header')[0].style.backgroundColor = 'rgba(255,255,255,' + (0.6 + 0.4 * window.pageYOffset / 600) + ')';
}