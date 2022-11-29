const datosDiv = document.querySelector("#datos");
const form = document.querySelector("#form");
const userCedula = localStorage.getItem("user");
const nombreInput = document.querySelector("#nombre");
const correoInput = document.querySelector("#correo");
const direccionInput = document.querySelector("#direccion");
let nombreCompleto = [];

const mostrarDatos = async () => {
    const resp = await fetch("http://localhost:8080/user/" + userCedula);
    const data = await resp.json();

    const { nombre, correo, direccion, apellido } = data[0];

    datosDiv.innerHTML = `<h2 id="datos-generales">Datos Generales</h2>
            <p id="dato1"><strong>Nombre:</strong> ${nombre} ${apellido}</p>
            <p id="dato2"><strong>Direccion:</strong> ${direccion}</p>
            <p id="dato3"><strong>Email:</strong> ${correo}</p>`;

    nombreInput.value = nombre + " " + apellido;
    correoInput.value = correo;
    direccionInput.value = direccion;
};

mostrarDatos();

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    nombreCompleto = nombreInput.value.split(" ");
    let body = {
        correo: correo.value,
        nombre: nombreCompleto[0],
        apellido: nombreCompleto[1],
        cedula: localStorage.getItem("user"),
        direccion: direccion.value,
    };

    const resp = await fetch("http://localhost:8080/user", {
        method: "PUT",
        body: JSON.stringify(body),
        headers: {
            "Content-type": "application/json",
        },
    });
    const data = await resp.json();
    if (data === 1) {
        window.location.reload();
    }
});
