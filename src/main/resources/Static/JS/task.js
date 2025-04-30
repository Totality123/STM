fetch('/tasks')
  .then(res => res.json())
  .then(tareas => {
    const board = document.querySelector('.board')
    tareas.forEach(task => {
      const card = document.createElement('div')
      card.classList.add('column')
      card.innerHTML = `
        <div class="column-title">${task.name}</div>
        <div class="column-description">${task.description}</div>
        <div class="progress-title">Progress bar</div>
        <progress class="column-progress" value="${task.percentage}" max="100"></progress>
        <div class="section-title">Estado: ${task.completed ? '✅ Completada' : '🕓 Pendiente'}</div>
        <div class="card-form">
          <div class="card-buttons">
            <button class="card-add">Add a subtask</button>
            <button class="card-delete">Delete</button>
          </div>
        </div>
      `
      board.appendChild(card)
    })
  })
  .catch(err => console.error('Error al cargar tareas:', err))
