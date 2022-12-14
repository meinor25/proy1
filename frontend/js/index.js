const user = localStorage.getItem("user");
const accountDiv = document.querySelector("#account");

if (!user) {
    accountDiv.innerHTML =
        ' <a href="./pages/login.html"> <button class="btn-selected">Login</button> </a> <a href="./pages/registrarse.html"> <button class="btn-selected">Register</button></a>';
} else {
    accountDiv.innerHTML =
        ' <a href="./pages/profile.html"> <button class="btn-selected">Ver cuenta</button> </a></a> <a href="#"> <button id="log-out" class="btn-selected">log out</button> </a></a>';

    document.querySelector("#log-out").addEventListener("click", () => {
        localStorage.removeItem("user");
        window.location.reload();
    });
}
