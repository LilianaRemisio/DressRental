var username = new URL(location.href).searchParams.get("username");
var user;

//Función que realiza al cargar la pagina para comprobar si existe una sesión
$(document).ready(function () {

   $(function () {
      $('[data-toggle="tooltip"]').tooltip();
   });

   getUsuario().then(function () {
      if (username != "" && username != null) {
         $("#et_inicio").hide();
         $("#user-cerrar").html("Cerrar Sesión");

         $('#et_usuario').attr("href", "profile.html?username=" + username);
         $('#et_usuario').html(user.username);
         $("#user-saldo").html((Math.floor(user.saldo.toFixed(0))).toLocaleString('en-IN', {style: 'currency', currency: 'COP', minimumFractionDigits: 2}));

         //getVestidos(false, "");
      }
      getVestidos(false, "");
   });
});

//Función para obtener datos de usuario
async function getUsuario() {

   await $.ajax({
      type: "GET",
      dataType: "html",
      url: "./ServletUsuarioPedir",
      data: $.param({
         username: username
      }),
      success: function (result) {
         let parseResult = JSON.parse(result);
         if (parseResult != false) {
            user = parseResult;
         } else {
            console.log("Error recuperando los datos de usuario")
         }
      }

   });
}

//función para cerra sesión de usuario
$(document).on("click", "#user-cerrar", function () {
   $("#et_inicio").show();
   $("#user-cerrar").hide();
   $("#user-saldo").hide();
   $('#et_usuario').hide();
   window.location.hash = "no-back-button";
   window.location.hash = "Again-No-back-button";
   window.onhashchange = function () {
      window.location.hash = "index.html";
   };
});

//obtiene los vestidos y filtra si existe un parametro valido
function getVestidos(filtrar, filtro) {
   $.ajax({
      type: "GET",
      dataType: "html",
      url: "./ServletVestidoListar",
      data: $.param({
         filtrar: filtrar,
         filtro: filtro
      }),
      success: function (result) {
         let parseResult = JSON.parse(result);
         if (parseResult != false) {
            mostrarVestido(parseResult);
         } else {
            console.log("Error recuperando los datos de vestidos")
         }
      }
   });
}

//Función que llama a obtener vestidos filtrado por la variable de busqueda
$(document).ready(function () {
   $("#frm_buscar").submit(function (event) {
      event.preventDefault();

      let filtro = $("#txt_buscar").val();

      getVestidos(true, filtro);
   });

});

//Función que lista en la tabla los vestidos
function mostrarVestido(vestidos) {
   let contenido = "";

   if (typeof user === 'undefined') {
      user = {
         premium: false,
         saldo: 0
      };
   }

   $.each(vestidos, function (index, vestido) {

      vestido = JSON.parse(vestido);
      let precio;
      if (vestido.cantidad > 0) {
         if (user.premium) {
            if (vestido.novedad) {
               precio = (2 - (2 * 0.1));
            } else {
               precio = (1 - (1 * 0.1));
            }
         } else {
            if (vestido.novedad) {
               precio = 2;
            } else {
               precio = 1;
            }
         }
      } else {
         precio = 1;
      }

      contenido += '<tr>\n\
                  <th scope="row">' + vestido.id + '</th>' +
              '<td>' + vestido.tipo + '</td>' +
              '<td>' + vestido.color + '</td>' +
              '<td>' + vestido.disenador + '</td>' +
              '<td>' + vestido.cantidad + '</td>' +
              '<td>' + vestido.talla + '</td>' +
              '<td>' + vestido.anio_modelo + '</td>' +
              '<td>' + vestido.precio + '</td>' +
              '<td><input type="checkbox" name="novedad" id="novedad' + vestido.novedad + '" disable';
      if (vestido.novedad) {
         contenido += 'checked';
      }

      contenido += '></td>' +
              '<td><button onclick = "alquilarVestido(' + vestido.id + ',' + vestido.precio + '); class = "btn btn-success";';

      if (user.saldo < vestido.precio) {
         contenido += ' disabled';
      }
      contenido += '>Alquilar</button></td>' +
              '</tr>';
   });

   $("#vestidos-tbody").html(contenido);
}



