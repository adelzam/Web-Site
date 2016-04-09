function func() {
    alert("Все работает!");
}

$(document).ready(function () {
    $('.slider').cycle({
        fx: 'fade',
        speed: 1000,
        timeout: 5000

    });
});
window.onload = function () {
    var price = $(this).findObject('price').text();
    var num = $(this).findObject('number').val();
    var sum  = price*num;
    sum = document.getElementById('mult').innerHTML
};