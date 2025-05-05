function renderSubtask(subtask, contenedor) {
  const sub = document.createElement('div')
  sub.className = 'subtask'

  sub.innerHTML = `
  <div class="subtask-title">${subtask.name}</div>
  <p class="subtask-desc">${subtask.description}</p>
  <div class="comments"></div>
   <div class="modal-actions">
        <button class="btn btn-green" onclick="openModalComment(${subtask.id})">Add Comment</button>
      </div>
`

  contenedor.appendChild(sub)

  if (subtask.comments && Array.isArray(subtask.comments)) {
    const commentsContainer = sub.querySelector('.comments')
     subtask.comments.forEach(comment => renderComment(comment, commentsContainer))
  }
}

