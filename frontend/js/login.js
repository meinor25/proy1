const form = document.querySelector("#form");
const input1 = document.querySelector("#correo");
const input2 = document.querySelector("#password");
let dataArray = [];

form.addEventListener("submit", function (e) {
    console.log(input1.value, input2.value);
    e.preventDefault();
    let body = {
        correo: input1.value,
        password: input2.value,
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
