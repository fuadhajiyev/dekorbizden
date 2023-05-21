$('#builderModal').on('shown.bs.modal', function () {
    $('.builder-success').attr('hidden', 'hidden');
    $.get('/constructor/rendercart', function (data) {
        var obj = $.parseJSON(data);
        var cost = parseFloat(obj.cost);
        var content = obj.content;
        if (cost > 0) {

            $('#emptyBuilder').attr('hidden', 'hidden');
            $('#blockBuilder').removeAttr('hidden');
            $('#dataBody').html(content);
            setTotal(cost);
        } else {
            $('#emptyBuilder').removeAttr('hidden');
            $('#blockBuilder').attr('hidden', 'hidden');
        }
    });
});


$('.component-add-button').on('click', function () {
    var id = $(this).attr('data-id');
    var type = parseInt($(this).attr('data-type'));
    var qty = parseInt($('#qty_'+id).val());
    if (qty < 1) {
        console.log('Miqdar daxil edin');
        $('#addToBuilderModal').modal();
        $('#errorAlert').removeAttr('hidden').html($('#errorAlert').attr('data-default-message'));
        $('#successAlert').attr('hidden', 'hidden');
        return false;
    }
    $.post('/constructor/cptadd', {id:id, qty:qty}, function (data) {
        if (data === 'success') {
            if (type === 3) rq = 1; else rq = 0;
            $('#qty_'+id).val(rq);
            // $('#addToBuilderModal').modal();
            // $('#successAlert').removeAttr('hidden');
            // $('#errorAlert').attr('hidden', 'hidden');
            $('#builderModal').modal();
        } else {
            console.log(data);
            $('#addToBuilderModal').modal();
            $('#errorAlert').removeAttr('hidden').html(data);
            $('#successAlert').attr('hidden', 'hidden');
        }
    });
});


$('#constructorAddCart').on('click', function () {
    $.get('/constructor/movetocart', function (data) {
        if (data !== 'error' && parseInt(data)>0) {
            $('#blockBuilder').html('');
            $('.builder-success').removeAttr('hidden');
            $('.ajax-cart-count').html(parseInt(data));
        }
    })
});


$(document).on('click', '.remove-component-btn', function (e) {
    e.preventDefault();
    var id = $(this).attr('data-id');
    $.get('/constructor/remove', {id:id}, function (data) {
        if (data === 'success') {
            var cost = $('#cptCost_'+id).attr('data-cost');
            var total = getTotal();
            setTotal(total-cost);
            $('#rowComponent_'+id).remove();
        }
    });
});


$(document).on('click', '.quantity-plus', function (e) {
    var o = $(this);
    var id = o.attr('data-id');
    //o.hide();
    o.css('pointer-events', 'none');
    $.get('/constructor/cartplus', {id:id}, function (data) {
        if (data === 'success') {
            var qty = $('#inputQty_'+id).val();
            var grandtotal = getTotal();
            var total = $('#cptCost_'+id).attr('data-cost');
            var price = $('#price_'+id).attr('data-price');
            $('#cptCost_'+id).html( number_format(price*qty, 2, '.', ' ') ).attr('data-cost', price*qty);
            setTotal(price*qty+parseFloat(grandtotal)-total);
            //o.show();
            o.css('pointer-events', 'auto');

        } else {
            //o.show();
            o.css('pointer-events', 'auto');
            return false;
        }
    })
});

$(document).on('click', '.quantity-minus', function (e) {
    var o = $(this);
    var id = o.attr('data-id');
    //o.hide();
    o.css('pointer-events', 'none');
    $.get('/constructor/cartminus', {id:id}, function (data) {
        if (data === 'success') {
            var qty = $('#inputQty_'+id).val();
            var grandtotal = getTotal();
            var total = $('#cptCost_'+id).attr('data-cost');
            var price = $('#price_'+id).attr('data-price');
            $('#cptCost_'+id).html( number_format(price*qty, 2, '.', ' ') ).attr('data-cost', price*qty);
            setTotal(price*qty+parseFloat(grandtotal)-total);
            //o.show();
            o.css('pointer-events', 'auto');
        } else {
            //o.show();
            o.css('pointer-events', 'auto');
            return false;
        }
    })
});

$(document).on('click', '#mobile-cart', function() {
    cartRefresh();
});

$('.related-items').slick({
    arrows:true,
    slidesMargin:30,
    dots:false,
    infinite:false,
    speed:300,
    slidesToShow:5,
    rows:1,
    prevArrow:"<button type='button' class='slick-prev pull-left'><i class='fa fa-angle-left' aria-hidden='true'></i></button>",
    nextArrow:"<button type='button' class='slick-next pull-right'><i class='fa fa-angle-right' aria-hidden='true'></i></button>",
    responsive: [
        {
            breakpoint :480,
            settings: {
                slidesToShow:2,
                slidesMargin:10
            }
        },
        {
            breakpoint:768,
            settings: {
                slidesToShow:2,
                slidesMargin:10
            }
        },
        {
            breakpoint:992,
            settings: {
                slidesToShow:3,
                slidesMargin:20
            }
        },
        {
            breakpoint:1200,
            settings: {
                slidesToShow:3,
                slidesMargin:20
            }
        },
        {
            breakpoint:1500,
            settings: {
                slidesToShow:4,
                slidesMargin:30
            }
        }

    ]

});

function setTotal(cost) {
    $('#blockCost').html(number_format(cost,2,'.',' ')).attr('data-grandtotal', cost);
}

function getTotal() {
    return $('#blockCost').attr('data-grandtotal')
}

function getCost(id) {

}

function setCost(id, cost) {

}