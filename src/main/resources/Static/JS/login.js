let token = "";

async function login() {
    const username = document.getElementById("usuario").value;
    const password = document.getElementById("contrasena").value;

    const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    });

    if (response.ok) {
        const data = await response.json();
        sessionStorage.setItem("jwt", data.token); 
        window.location.href = "/"; 
    } else {
        alert("Error al iniciar sesión. Verifica tus credenciales.");
    }


}