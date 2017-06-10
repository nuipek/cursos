var direccion = "";
$(document).on("click", ".direccion", function () {
direccion = $(this).attr("data-direccion"); 
 /*alert(direccion);*/
});

$(document).on("click", "#confirmacion", function () {
var id1 = $(this).data('id');
 /*alert(direccion);*/
$(".modal-footer .btn-primary").attr("href", direccion);
});  