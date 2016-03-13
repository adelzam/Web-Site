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