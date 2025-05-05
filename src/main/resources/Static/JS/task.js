let tareaEnEdicion = null;
let tareaParaSubtarea = null;

document.addEventListener('DOMContentLoaded', () => {
  cargarTareas();
});

function cargarTareas() {
  fetch('http://localhost:8080/tasks')
    .then(res => res.json())
    .then(tareas => {
      const board = document.querySelector('.board');
      const addButton = document.querySelector('.add-list');

      board.innerHTML = '';
      board.appendChild(addButton);

      tareas.forEach(task => {
        const card = crearTarjeta(task);
        board.insertBefore(card, addButton);
      });
    })
    .catch(err => console.error('error al cargar tareas:', err));
}

function crearTarjeta(task) {
  const div = document.createElement('div');
  div.className = 'column';

  div.innerHTML = `
    <button class="card-delete-x">✕</button>
    <div class="column-title">${task.name}</div>
    <div class="column-description">${task.description}</div>
    <div class="progress-title">Progress bar</div>
    <progress class="column-progress" value="${task.percentage}" max="100"></progress>
    <div class="section-title">Subtareas</div>
    <div class="subtasks"></div>
    <div class="card-form">
      <div class="card-buttons">
        <button class="card-add">+</button>
        <button class="card-update">Update</button>
        <button class="card-report">Report</button>
      </div>
    </div>
  `;

  if (task.subtasks && Array.isArray(task.subtasks)) {
    const contenedor = div.querySelector('.subtasks');
    task.subtasks.forEach(sub => renderSubtask(sub, contenedor));
  }

  div.querySelector('.card-delete-x').addEventListener('click', () => {
    const confirmar = confirm(`¿Estás seguro de que deseas eliminar la tarea "${task.name}"?`);
    if (confirmar) {
      fetch(`http://localhost:8080/tasks/delete/${task.id}`, {
        method: 'DELETE'
      })
      .then(() => {
        cargarTareas();
      })
      .catch(err => console.error('Error al eliminar:', err));
    }
  });

  div.querySelector('.card-update')?.addEventListener('click', () => {
    tareaEnEdicion = task;
    tareaParaSubtarea = null;
    document.getElementById('modal-title').value = task.name;
    document.getElementById('modal-description').value = task.description;
    document.getElementById('modal-submit').textContent = 'Update';
    openModal();
  });

  div.querySelector('.card-add')?.addEventListener('click', () => {
    tareaParaSubtarea = task;
    tareaEnEdicion = null;
    document.getElementById('modal-title').value = '';
    document.getElementById('modal-description').value = '';
    document.getElementById('modal-submit').textContent = 'Create Subtask';
    openModal();
  });

  // ✅ nuevo botón: generar reporte
  div.querySelector('.card-report')?.addEventListener('click', () => {
    window.location.href = `/report/${task.id}`;
  });

  return div;
}

function renderSubtask(sub, contenedor) {
  const item = document.createElement('div');
  item.className = 'subtask';
  item.textContent = sub.name;
  contenedor.appendChild(item);
}
