document.addEventListener('DOMContentLoaded', () => {
  fetch('/tasks')
    .then(res => res.json())
    .then(tareas => {
      const board = document.getElementById('board')
      const addButton = document.getElementById('add-list')

      tareas.forEach(task => {
        const card = crearTarjeta(task)
        board.insertBefore(card, addButton)
      })
    })
    .catch(err => console.error('Error al cargar tareas:', err))
})

function crearTarjeta(task) {
  const div = document.createElement('div')
  div.className = 'column'

  div.innerHTML = `
    <div class="column-title">${task.name}</div>
    <div class="column-description">${task.description}</div>
    <div class="progress-title">Progress bar</div>
    <progress class="column-progress" value="${task.percentage}" max="100"></progress>
    <div class="section-title">Subtareas</div>
    <div class="subtasks"></div> <!-- ← aquí se insertan las subtareas -->
    <div class="card-form">
      <div class="card-buttons">
        <button class="card-add">Add a subtask</button>
        <button class="card-delete">Delete</button>
      </div>
    </div>
  `

  if (task.subtasks && Array.isArray(task.subtasks)) {
    const contenedor = div.querySelector('.subtasks')
    task.subtasks.forEach(sub => renderSubtask(sub, contenedor))
  }

  return div
}
