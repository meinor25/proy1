const form = document.querySelector("#form");
const correo = document.querySelector("#correo");
const password = document.querySelector("#password");
const passwordValidate = document.querySelector("#password-validate");
const nombre = document.querySelector("#nombre");
const apellido = document.querySelector("#apellido");
const cedula = document.querySelector("#cedula");
const direccion = document.querySelector("#direccion");

form.addEventListener("submit", async function (e) {
    e.preventDefault();
    let body = {
        correo: correo.value,
        password: password.value,
        nombre: nombre.value,
        apellido: apellido.value,
        cedula: cedula.value,
        direccion: direccion.value,
    };
    const resp = await fetch("http://localhost:8080/register", {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            "Content-type": "application/json",
        },
    });
    const data = await resp.json();

    if (data === 1) {
        window.location.href = "login.html";
    } else {
        console.log(data);
    }
});
