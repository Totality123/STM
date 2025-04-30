fetch('/card_task.html')
  .then(res => res.text())
  .then(html => {
    const board = document.querySelector('.board')
    const div = document.createElement('div')
    div.innerHTML = html
    board.appendChild(div)
  })
