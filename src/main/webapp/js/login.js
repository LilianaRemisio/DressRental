/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function(){
    $("#form-login").submit(function(event){
        event.preventDefault();
        autenticarUsuario();
    });
    
});

function autenticarUsuario(){
    let username = $("#usuario").val();
    let contrasena = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            contrasena: contrasena

        }),
        success: function(result){
            let parseResult = JSON.parse(result);
            if (parseResult != false){
                let username = parseResult['username'];
                document.location.href = "index.html?username=" + username;
            }else{
                //$("#login-error").remove("d-none");
                $.alert({
                    title: 'Error!',
                    content: 'Usuario o contraseña Incorrectos!',
                    type: 'red',
                    typeAnimated: true
                });

            }
        }
    });
    
}