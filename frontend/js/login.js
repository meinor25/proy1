const form = document.querySelector("#form");
const correo = document.querySelector("#correo");
const password = document.querySelector("#password");
let dataArray = [];

form.addEventListener("submit", function (e) {
    e.preventDefault();
    let body = {
        correo: correo.value,
        password: password.value,
    };

    fetch("http://localhost:8080/login", {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            "Content-type": "application/json",
        },
    })
        .then((res) => res.json())
        .then((data) =>
            data.forEach((element) => {
                dataArray.push(element);
            })
        );

    setTimeout(() => {
        if (dataArray.length > 0) {
            window.location.href = "../index.html";
        } else {
            console.log("Usuario no encontrado");
        }
    }, 1000);
});
