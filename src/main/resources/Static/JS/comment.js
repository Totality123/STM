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
  