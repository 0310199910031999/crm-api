// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});


async function cargarUsuarios(){
  const requestUser = await fetch('controler/administracion/usuarios',{
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await requestUser.json();
  console.log(usuarios);
  let listadoHtml = ``;

  for (let usuarioelement of usuarios) {
    let botonEliminar = `<a href="#" onclick="eliminarUsuario(${usuarioelement.id})" class="btn btn-danger btn-circle btn-sm">
              <i class="fas fa-trash"></i>
          </a>`;
    let usuario =`<tr>
      <td>${usuarioelement.id}</td>
      <td>${usuarioelement.nombre} ${usuarioelement.apellido}</td>
      <td>${usuarioelement.email}</td>
      <td>${usuarioelement.telefono}</td>
      <td>
          ${botonEliminar}
      </td>
  </tr>`;
    listadoHtml += usuario;
  }
  document.querySelector("#usuarios tbody").outerHTML = listadoHtml;

}
async function eliminarUsuario(id){

  if(!confirm(`Desea eliminar este usuario?`)){
    return;
  }
  const requestUser = await fetch(`api/usersdelete/${id}`,{
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  location.reload();

}
