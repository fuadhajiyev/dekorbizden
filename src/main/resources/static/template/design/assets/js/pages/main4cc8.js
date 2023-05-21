$('#ajax-cart-btn').on('click', function (e) {
    e.preventDefault();
    cartRefresh();
});


$('.add-to-cart-btn').on('click', function (e) {
    addToCart($(this).attr('data-id'), 1, 1);
});


$(document).on('click', '.remove_from_cart_button', function (e) {
    e.preventDefault();
    var id = $(this).attr('data-id');
    $.post('/cart/remove', {id:id}, function (data) {
        if (data !== 'error' && $.isNumeric(data)) {
            $('.ajax-cart-count').html(parseInt(data));
            cartRefresh();
            //$('#position-'+id).remove();
        }
    });
});

function cartRefresh() {
    $.get('/cart/getajaxcart', function (data) {
        var obj = $.parseJSON(data);
        $('#ajax-cart-content').html(obj.content);
        $('#ajax-cart-content-mobile').html(obj.content);
        $('#ajaxGrandtotal').html(obj.grandtotal);
        $('#ajaxGrandtotalMobile').html(obj.grandtotal);
    });
}

function addToCart(product, ptype, qty) {
    $.post('/cart/add', {product:product, ptype:ptype, qty:qty}, function (data) {
        if ($.isNumeric(data)) {
            $('.ajax-cart-count').html(parseInt(data));
            $('#addToCardModal').modal();
            cartRefresh();
        } else {
            console.log(data);
        }
    });
}

/*number_format = function (number, decimals, dec_point, thousands_sep) {
    number = number.toFixed(decimals);
    var nstr = number.toString();
    nstr += '';
    x = nstr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? dec_point + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1))
        x1 = x1.replace(rgx, '$1' + thousands_sep + '$2');
    return x1 + x2;
};*/

number_format = function (number, decimals, dec_point, thousands_sep) {
    return $.number( number, decimals, dec_point, thousands_sep )
};




var lang = $('html').attr('lang');
