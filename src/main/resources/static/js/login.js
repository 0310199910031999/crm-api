async function iniciarSesion(){
    let datos = {};
    datos.email = document.querySelector("#txtemail").value;
    datos.password = document.querySelector("#txtpassword").value;

    for (const datosKey in datos) {
        if(datos[datosKey]==="") {
            alert("Debe llenar todos los campos");
            return;
        }
    }
    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type' : 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const respuesta = await request.text();

    if(respuesta === "OK"){
        window.location.href = "usuarios.html"
    }
    else{
        alert("Credenciales incorrectas, intente de nuevo porfavor");
    }




}