/**
 * Created by Decen on 28/09/2017.
 */
$(document).ready(function(){
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