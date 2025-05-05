function renderComment(comment, contenedor) {
  const div = document.createElement('div')
  div.className = 'comment'

  const username = comment.user?.name || 'Usuario desconocido'
  const message = comment.comment || 'Sin mensaje'

  div.innerHTML = `
      <div class="column-usuario">${username}</div>
      <div>💬 ${message}</div>
    `
  contenedor.appendChild(div)
}


function openModalComment(subtask) {
  const div = document.createElement("div");
  div.className = "modal-overlay_comment";
  div.id = "modal-overlay_comment";
  div.innerHTML = `
    <div class="modal_comment">
      <label class="modal-label">Comentario</label>
      <textarea class="modal-textarea_comment" id="modal-textarea_comment" placeholder="Escribe tu comentario..."></textarea>
      <div class="modal-actions">
        <button class="btn btn-green" onclick="guardarComment(${subtask})">Guardar</button>
        <button class="btn btn-red" onclick="closeModalComment()">Cancelar</button>
      </div>
    </div>
    `

  document.getElementById("cuerpo-general").appendChild(div)
}
function guardarComment(subtask) {
  const comment = document.getElementById("modal-textarea_comment").value;
  
  const nuevoComment = {
    comment,
    image_url: "no hay",
    user: { id: 1 },
    subtask: { id: subtask }
  };

  fetch('http://localhost:8080/comments/add', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(nuevoComment)
  })
    .then(() => {
      cargarTareas();
      closeModalComment();
    })
    .catch(err => console.error('Error al crear comentario:', err));
}

function  closeModalComment(){
    
  const div = document.getElementById("modal-overlay_comment").remove();
 
    }