const datosDiv = document.querySelector("#datos");
const userCedula = localStorage.getItem("user");
const dataArray = [];

const mostrarDatos = async () => {
    const resp = await fetch("http://localhost:8080/user/" + userCedula);
    const data = await resp.json();
    data.forEach((element) => {
        dataArray.push(element);
    });
    const { nombre, correo, direccion, apellido } = dataArray[0];

    datosDiv.innerHTML = `<h2 id="datos-generales">Datos Generales</h2>
            <p id="dato1"><strong>Nombre:</strong> ${nombre} ${apellido}</p>
            <p id="dato2"><strong>Direccion:</strong> ${direccion}</p>
            <p id="dato3"><strong>Email:</strong> ${correo}</p>`;
};

mostrarDatos();
