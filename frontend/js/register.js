const form = document.querySelector("#form");
const correo = document.querySelector("#correo");
const password = document.querySelector("#password");
const passwordValidate = document.querySelector("#password-validate");
const nombre = document.querySelector("#nombre");
const apellido = document.querySelector("#apellido");
const cedula = document.querySelector("#cedula");
const direccion = document.querySelector("#direccion");

let estado = 0;

form.addEventListener("submit", function (e) {
    e.preventDefault();
    let body = {
        correo: correo.value,
        password: password.value,
        nombre: nombre.value,
        apellido: apellido.value,
        cedula: cedula.value,
        direccion: direccion.value,
    };

    fetch("http://localhost:8080/register", {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            "Content-type": "application/json",
        },
    })
        .then((res) => res.json())
        .then((data) => (data = estado));

    setTimeout(() => {
        if ((estado = 1)) {
            console.log("usuario registrado");
            window.location.href = "login.html";
        }
    }, 1000);
});
