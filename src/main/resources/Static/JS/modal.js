function openModal() {
  document.getElementById("overlay").style.display = "flex";

  if (tareaEnEdicion) {
    document.getElementById('modal-submit').textContent = 'Update';
  } else if (tareaParaSubtarea) {
    document.getElementById('modal-submit').textContent = 'Create Subtask';
  } else {
    document.getElementById('modal-submit').textContent = 'Create';
  }
}

function closeModal() {
  document.getElementById("overlay").style.display = "none";

  document.getElementById('modal-title').value = '';
  document.getElementById('modal-description').value = '';
  document.getElementById('modal-submit').textContent = 'Create';

  tareaEnEdicion = null;
  tareaParaSubtarea = null;
}

document.getElementById('modal-submit').addEventListener('click', () => {
  const name = document.getElementById('modal-title').value;
  const description = document.getElementById('modal-description').value;

  if (tareaEnEdicion) {
    const updatedTask = {
      ...tareaEnEdicion,
      name,
      description
    };

    fetch(`http://localhost:8080/tasks/update/${tareaEnEdicion.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(updatedTask)
    })
    .then(() => {
      closeModal();
      cargarTareas();
    })
    .catch(err => console.error('Error al actualizar:', err));
  }

  else if (tareaParaSubtarea) {
    const nuevaSubtarea = {
      name,
      description,
      completed: false,
      task: {
        id: tareaParaSubtarea.id
      }
    };

    fetch('http://localhost:8080/subtasks/add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(nuevaSubtarea)
    })
    .then(() => {
      closeModal();
      cargarTareas();
    })
    .catch(err => console.error('Error al crear subtarea:', err));
  }
});
