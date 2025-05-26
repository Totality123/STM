
if (!sessionStorage.getItem("jwt")) {
    window.location.href = "/login"; 
}

let token = sessionStorage.getItem("jwt")



function cerrarSesion() {
    sessionStorage.removeItem("jwt");
window.location.href = "/login"; 
}

