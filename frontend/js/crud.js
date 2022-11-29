let baseurl = "http://localhost:8080";
const button = document.querySelector("#buscar");
const mostrar = document.querySelector("#mostrar");
const input = document.querySelector("#search-input");
let contenedor = document.getElementById("T-Body");

function getConsultas() {
    fetch(baseurl + "/consultas").then((res) => {
        res.json().then((json) => {
            ImprimirConsultas(json);
        });
    });
}

function ImprimirConsultas(consultas) {
    consultas.forEach(({ nombre, fecha_consulta, motivo_consulta, nombre_mascota }) => {
        contenedor.innerHTML += CrearConsulta(
            nombre,
            nombre_mascota,
            fecha_consulta,
            motivo_consulta
        );
    });
}

function CrearConsulta(nombre, nombre_mascota, fecha_consulta, motivo_consulta) {
    return `<tr>
    <td>${nombre}</td>
    <td>${nombre_mascota}</td>
    <td>${fecha_consulta}</td>
    <td>${motivo_consulta}</td>
    `;
}

function buscarConsulta(value) {
    fetch(baseurl + "/consultas/nombre", {
        method: "POST",
        body: JSON.stringify({ nombre: value }),
        headers: {
            "Content-type": "application/json",
        },
    }).then((res) => {
        res.json().then((json) => {
            ImprimirConsultas(json);
        });
    });
}

button.addEventListener("click", () => {
    contenedor.innerHTML = "";
    buscarConsulta(input.value);
});

mostrar.addEventListener("click", () => {
    contenedor.innerHTML = "";
    getConsultas();
});

getConsultas();
ImprimirConsultas();
