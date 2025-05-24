
if (!sessionStorage.getItem("jwt")) {
    window.location.href = "/login"; // Redirigir al login si no hay token
}

let token = sessionStorage.getItem("jwt")


function cerrarSesion() {
    sessionStorage.removeItem("jwt");
window.location.href = "/login"; 
}

