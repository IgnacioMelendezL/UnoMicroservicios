<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
<script>
// $.ajax({
// url: ,
//   method: "GET",
// }).done(function( data ) {
//     if ( console && console.log ) {
//       console.log( "done" );
//     }
//   }).fail(function() {
// 	  console.log( "error" );
//   })
//   .always(function() {
// 	  console.log( "finished" );
//   });

sessionStorage.setItem('id', <%=request.getAttribute("id")%>);
sessionStorage.setItem('nombre', <%=request.getAttribute("nombre")%>);

// var jqxhr = $.post(, 
// 		function() {
// 	console.log( "success" );
// 	}).done(function() {
// 		console.log( "done" );
// 	  })
// 	  .fail(function() {v
// 		  console.log( "error" );
// 	  })
// 	  .always(function() {
// 		  console.log( "finished" );
// 	  });
	  
	  
// $.ajax({
//     type:"POST", // la variable type guarda el tipo de la peticion GET,POST,..
<%--     url:"/usuario/" + <%=request.getAttribute("id")%> + "/" + <%=request.getAttribute("nombre")%> + "/" + <%=request.getAttribute("codigo")%>, //url guarda la ruta hacia donde se hace la peticion --%>
//     data:{}, // data recive un objeto con la informacion que se enviara al servidor
//     success:function(datos){ //success es una funcion que se utiliza si el servidor retorna informacion
//          console.log("Exito")
//      },
//     dataType: dataType // El tipo de datos esperados del servidor. Valor predeterminado: Intelligent Guess (xml, json, script, text, html).
// })


var xhr = new XMLHttpRequest();
xhr.open("POST", "/usuario/" + <%=request.getAttribute("id")%> + "/" + <%=request.getAttribute("nombre")%> + "/" + <%=request.getAttribute("codigo")%>, true);
xhr.setRequestHeader('Content-Type', 'application/json');
));
</script>

<script>window.location.href = "uno.html"</script>

</body>
</html>