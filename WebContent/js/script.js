$('ul li:has(ul)').addClass('has-submenu');
$('ul li ul').addClass('sub-menu');
$('ul.menu li').hover(function () {
    $(this).addClass('hover');
}, function () {
    $(this).removeClass('hover');
});
var $menu = $('#menu'), $menulink = $('#spinner-form'), $search = $('#search'), $search_box = $('.search_box'), $menuTrigger = $('.has-submenu > a');
$menulink.click(function (e) {
    $menulink.toggleClass('active');
    $menu.toggleClass('active');
    if ($search.hasClass('active')) {
        $('.menu.active').css('padding-top', '50px');
    }
});
$search.click(function (e) {
    e.preventDefault();
    $search_box.toggleClass('active');
});
$menuTrigger.click(function (e) {
    e.preventDefault();
    var t = $(this);
    t.toggleClass('active').next('ul').toggleClass('active');
});
$('ul li:has(ul)');
$(function () {
    var e = $(document).scrollTop();
    var t = $('.SLnbBox').outerHeight();
    $(window).scroll(function () {
        var n = $(document).scrollTop();
        if ($(document).scrollTop() >= 50) {
            $('.SLnbBox').css('position', 'fixed');
        } else {
            $('.SLnbBox').css('position', 'fixed');
        }
        if (n > t) {
            $('.SLnbBox').addClass('scroll');
        } else {
            $('.SLnbBox').removeClass('scroll');
        }
        if (n > e) {
            $('.SLnbBox').removeClass('no-scroll');
        } else {
            $('.SLnbBox').addClass('no-scroll');
        }
        e = $(document).scrollTop();
    });
});