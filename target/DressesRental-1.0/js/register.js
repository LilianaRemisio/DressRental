
$(document).on("click", "#btn_registrar", function(){
    registrar();
});

function registrar(){
    let username = $("#txt_usuario").val();
    let contrasena = $("#txt_contrasena").val();
    let repit = $("#txt_repit_contrasena").val();
    let email = $("#txt_correo").val();
    let nombres = $("#txt_nombre").val();
    let apellidos = $("#txt_apellido").val();
    let saldo = $("#txt_saldo").val();
    let premium = $("#cb_premium").prop("checked");
    
    if (contrasena === repit){
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegistro",
            data: $.param({
                username: username,
                contrasena: contrasena,
                email: email,
                nombres: nombres,
                apellidos: apellidos,
                saldo: saldo,
                premium: premium

            }),
            success: function(result){
                let parseResult = JSON.parse(result);
                if (parseResult != false){
                    /*$.alert({
                        title: 'Exito!',
                        content: 'Se registro el usuario correctamente!',
                        type: 'green',
                        typeAnimated: true
                    });*/
                  alert('Se registro el usuario correctamente!');
                }else{
                    /*$.alert({
                        title: 'Error!',
                        content: 'No se registro el usuario, intente con otro usuario!',
                        type: 'red',
                        typeAnimated: true
                    });*/
                    
                    alert("No se registro el usuario, intente con otro usuario!");

                }
            }
        });
    }else{
        /*k$.alert({
            title: 'Error!',
            content: 'Las contraseñas no son iguales!',
            type: 'red',
            typeAnimated: true
        });*/
      alert("Las contraseñas no son iguales!");
    }
}
