/**
 * Created by Curso on 13/06/2017.
 */
var direccion = "";
$(document).on("click", ".direccion", function () {
    direccion = $(this).attr("data-direccion");
    /*alert(direccion);*/
});

$(document).on("click", "#confirmacion", function () {
    /*alert(direccion);*/
    $(".modal-footer .btn-primary").attr("href", direccion);
});

$( ".busqueda").keypress(function(e) {
    // Enter pressed?
    if(e.which == 10 || e.which == 13) {
    	e.preventDefault();
    	procesarBusqueda();
    }
    
});

$(document).on("click", "#buscar", function () {
	procesarBusqueda();
});

function procesarBusqueda()
{
    var busqueda = $(".busqueda").val();
    var buscar = busqueda;

    if (busqueda == "" || busqueda == "*" || busqueda == undefined){
        busqueda = "todosloscursos";
        buscar = "Todos";
    }

    var url = "http://localhost:8080/cursos/api/buscar/" + busqueda +".json";
    console.log("url" + url);
    $.ajax({
        url : url,
        contentType: "application/json",
        dataType: "json",
        success : function(data,textStatus,xhr) {
            /*console.log("sucess " + data);
            console.log("status " + textStatus)
            console.log("xhr " + xhr.status)
            */

            if (xhr.status == 200)
            {
                var listaCursos = JSON.stringify(data);
                var datosCursos = JSON.parse(listaCursos);
                renderizarBusqueda(datosCursos,buscar)
            }
            else
            {
                renderizarError(xhr.status,buscar);
            }

        },
        error: function(data, textStatus, xhr) {
            console.log("error " + textStatus);
        }
    });	
}


function renderizarError(status, busqueda){

    var $seccion = $("<section/>",{
        class:'row'});

    var $seccion12 = $("<section/>",{
        class:'col-xs-12'});
    var $div12 = $("<div/>",{
        class:'col-xs-12'});
    var $divrow = $("<div/>",{
        class:'row'});

    var $removible = $("<div/>",{
        id:'removable'});

    $("#removable").remove();




    if (status == 204){
        console.log("No hay Cursos para la busqueda solicitada " + busqueda);
        var txt =  '<section class="row"><header class="col-xs-12"><h2 class="text-center">';
        txt += 'No hay Resultados para la busqueda, ' + busqueda +'</h2></header>';

        $removible.appendTo("#contenedorCursos")
            .append(txt);
        $removible.append($seccion12);


    }
    else{
        console.log("Error en la busqueda");
        var txt =  '<section class="row"><header class="col-xs-12"><h2 class="text-center">';
        txt += 'Error en la busqueda, ' + busqueda +'</h2></header>';

        $removible.appendTo("#contenedorCursos")
            .append(txt);
        $removible.append($seccion12);
    }
}

function renderizarBusqueda(cursos,busqueda){

    var $seccion = $("<section/>",{
        class:'row'});

    var $seccion12 = $("<section/>",{
        class:'col-xs-12'});
    var $div12 = $("<div/>",{
        class:'col-xs-12'});
    var $divrow = $("<div/>",{
        class:'row'});

    var $removible = $("<div/>",{
        id:'removable'});

    var txt =  '<section class="row"><header class="col-xs-12"><h2 class="text-center">';
    txt += 'Resultados para la busqueda, ' + busqueda +'</h2></header><div class="col-xs-12"><div class="row">'
    txt += '<div class="col-xs-3">Codigo Curso</div><div class="col-xs-9">Nombre Curso</div></div></div></section>';

    $("#removable").remove();

    $removible.appendTo("#contenedorCursos")
        .append(txt);
    $removible.append($seccion12);
       var $posicion =  $seccion12.append($divrow);


    for(var x=0;x<cursos.length;x++) {

        var curso = cursos[x];
        //console.log(curso);
        var datos = '<div class="row"><div class="col-xs-3">' + curso['codCurso'];
        datos += '</div><div class="col-xs-9">' + curso['nomCurso'];
        datos += '</div></div>'
        $posicion.append(datos);
    }

}

