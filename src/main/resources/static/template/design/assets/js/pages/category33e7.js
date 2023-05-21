$('#sortOrder').on('change', function () {
    window.location.replace('?sort='+$(this).val());
});