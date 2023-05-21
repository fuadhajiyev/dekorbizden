$('.cart-page-remove-product-btn').on('click', function (e) {
    e.preventDefault();
    var id = $(this).attr('data-id');
    $.post('/cart/remove', {id:id}, function (data) {
        if (data !== 'error' && $.isNumeric(data)) {
            var cost = $('#total_'+id).html();
            var total = $('#grandtotal').html();
            $('.ajax-cart-count').html(parseInt(data));
            $('#rowCartProduct_'+id).remove();
            $('#grandtotal').html(number_format(total-cost,2,'.',''));
            cartRefresh();
            //$('#position-'+id).remove();
        }
    });
    //console.log(id);
});

$('.quantity-plus').on('click', function () {
    var o = $(this);
    var id = o.attr('data-id');
    //o.hide();
    o.css('pointer-events', 'none');
    $.get('/cart/cartplus', {id:id}, function (data) {
        if (data === 'success') {
            var qty = $('input[name="qty['+id+']"]').val();
            var grandtotal = $('#grandtotal').html();
            var total = $('#total_'+id).html();
            var price = $('#price_'+id).attr('data-price');
            $('#total_'+id).html( number_format(price*qty, 2, '.', ' ') );
            $('#grandtotal').html( number_format(parseFloat(price*qty) + parseFloat(grandtotal) - parseFloat(total), 2, '.', ' ') );
            //o.show();
            o.css('pointer-events', 'auto');
        } else {
            //o.show();
            o.css('pointer-events', 'auto');
            return false;
        }
    })
});

$('.quantity-minus').on('click', function () {
    var o = $(this);
    var id = o.attr('data-id');
    //o.hide();
    o.css('pointer-events', 'none');
    $.get('/cart/cartminus', {id:id}, function (data) {
        if (data === 'success') {
            var qty = $('input[name="qty['+id+']"]').val();
            var grandtotal = $('#grandtotal').html();
            var total = $('#total_'+id).html();
            var price = $('#price_'+id).attr('data-price');
            $('#total_'+id).html( number_format(price*qty, 2, '.', ' ') );
            $('#grandtotal').html( number_format(parseFloat(price*qty) + parseFloat(grandtotal) - parseFloat(total), 2, '.', ' ') );
            //o.show();
            o.css('pointer-events', 'auto');
        } else {
            //o.show();
            o.css('pointer-events', 'auto');
            return false;
        }
    })
});