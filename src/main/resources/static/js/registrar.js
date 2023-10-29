// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});


async function registrarUsuarios(){


    let datos = {};
    datos.nombre = document.querySelector("#txtnombre").value;
    datos.apellido = document.querySelector("#txtapellido").value;
    datos.email = document.querySelector("#textemail").value;
    datos.telefono = document.querySelector("#texttelefono").value;
    datos.password = document.querySelector("#txtpassword").value;

    for (const datosKey in datos) {
        if(datos[datosKey] === "") {
            alert("Debes de llenar todos los campos")
            return;
        }
    }
    if(datos.password !== document.querySelector("#txtrepetirpassword").value){
        alert("La password no coincide");
        return;
    }

    const requestUser = await fetch('api/users',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    window.location.href = "login.html";


}

