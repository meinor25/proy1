const datosDiv = document.querySelector("#datos");
const userCedula = localStorage.getItem("user");
const dataArray = [];

window.onload = () => {
    fetch("http://localhost:8080/user/" + userCedula)
        .then((res) => res.json())
        .then((data) =>
            data.forEach((element) => {
                dataArray.push(element);
            })
        );
};

setTimeout(() => {
    const { nombre, correo, direccion, apellido } = dataArray[0];

    datosDiv.innerHTML = `<h2 id="datos-generales">Datos Generales</h2>
    <p id="dato1"><strong>Nombre:</strong> ${nombre} ${apellido}</p>
    <p id="dato2"><strong>Direccion:</strong> ${direccion}</p>
    <p id="dato3"><strong>Email:</strong> ${correo}</p>`;
}, 200);
