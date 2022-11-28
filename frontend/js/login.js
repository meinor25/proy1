const form = document.querySelector("#form");
const correo = document.querySelector("#correo");
const password = document.querySelector("#password");
let dataArray = [];

form.addEventListener("submit", async function (e) {
    e.preventDefault();
    let body = {
        correo: correo.value,
        password: password.value,
    };
    const resp = await fetch("http://localhost:8080/login", {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            "Content-type": "application/json",
        },
    });
    const data = await resp.json();

    data.forEach((element) => {
        dataArray.push(element);
    });
    const { cedula } = dataArray[0];

    if (dataArray.length > 0) {
        console.log(cedula);
        localStorage.setItem("user", cedula);
        window.location.href = "../index.html";
    } else {
        console.log("Usuario no encontrado");
    }
});
