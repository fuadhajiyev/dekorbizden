
$('#formAddCart').on('submit', function (e) {
    e.preventDefault();
    if (parseInt($('#inputQty').val()) < 1) {
        $('.qty-error').attr('hidden', false);
        return false;
    }

    $.post('/cart/add', $(this).serialize(), function (data) {
        if ($.isNumeric(parseInt(data))) {
            $('.ajax-cart-count').html(parseInt(data));
            $('#addToCardModal').modal();
            cartRefresh();
        } else {
            console.log(data);
        }
    });
});

