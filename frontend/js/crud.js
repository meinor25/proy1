let baseurl = "http://localhost:8080";
let consultas = [];

function getConsultas() {
    fetch(baseurl + "/consultas").then(res=>{
        res.json().then(json=>{
            consultas = json;
            ImprimirConsultas();
        })
    })
}

function ImprimirConsultas() {
    let contenedor = document.getElementById("T-Body");


    consultas.forEach(({nombre,apellido,fecha_consulta,motivo_consulta}) => {
        contenedor.innerHTML += CrearConsulta(nombre,apellido,fecha_consulta,motivo_consulta);
        });
}

function CrearConsulta(nombre,apellido,fecha_consulta,motivo_consulta) {
    return `<tr>
    <td>${nombre}</td>
    <td>${apellido}</td>
    <td>${fecha_consulta}</td>
    <td>${motivo_consulta}</td>
    `
}

getConsultas();
setTimeout(()=>{ImprimirConsultas()},1000);