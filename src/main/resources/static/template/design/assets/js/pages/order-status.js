$('#formStatusTrack').on('submit', function (e) {
    e.preventDefault();
    $('.status-result-block').attr('hidden', 'hidden');
    $.get('/order/track', $(this).serialize(), function (data) {
        const resp = $.parseJSON(data);
        if (resp) {
            if (resp.status === 'success') {
                $('#blockResult').removeAttr('hidden');
                $('#blockOrderId').html(resp.order);
                $('#blockStatus').html(resp.text).removeClass('text-danger text-warning text-info text-primary').addClass('text-'+resp.label);
            } else {
                $('#alertError').removeAttr('hidden').html(resp.message)
            }
        }
    });
});