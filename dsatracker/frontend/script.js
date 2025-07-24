let problems = [];

document.getElementById("modeBtn").addEventListener("click", () => {
  document.body.classList.toggle("dark-mode");
  const modeText = document.body.classList.contains("dark-mode") ? "🌙 Dark Mode" : "🌞 Light Mode";
  document.getElementById("modeBtn").textContent = modeText;
});

function addProblem() {
  const title = document.getElementById("titleInput").value.trim();
  const link = document.getElementById("linkInput").value.trim();
  const notes = document.getElementById("notesInput").value.trim();
  const difficulty = document.getElementById("difficultySelect").value;

  if (!title) {
    alert("Please enter a title.");
    return;
  }

  const problem = {
    id: Date.now(),
    title,
    link,
    notes,
    difficulty,
    solved: false
  };

  problems.push(problem);
  alert(`✅ "${title}" added!`);
  clearForm();
  renderProblems();
}

function clearForm() {
  document.getElementById("titleInput").value = "";
  document.getElementById("linkInput").value = "";
  document.getElementById("notesInput").value = "";
  document.getElementById("difficultySelect").value = "Easy";
}

function renderProblems() {
  const sortType = document.getElementById("sortSelect").value;
  const filterType = document.getElementById("filterSelect").value;
  let filtered = [...problems];

  if (filterType === "solved") filtered = filtered.filter(p => p.solved);
  if (filterType === "unsolved") filtered = filtered.filter(p => !p.solved);

  if (sortType === "title") filtered.sort((a, b) => a.title.localeCompare(b.title));
  if (sortType === "difficulty") {
    const levels = { Easy: 1, Medium: 2, Hard: 3 };
    filtered.sort((a, b) => levels[a.difficulty] - levels[b.difficulty]);
  }

  const tbody = document.getElementById("problemTableBody");
  tbody.innerHTML = "";

  filtered.forEach(problem => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${problem.title}</td>
      <td><a href="${problem.link}" target="_blank">🔗</a></td>
      <td>${problem.difficulty}</td>
      <td>${problem.notes}</td>
      <td>
        <button onclick="editProblem(${problem.id})">✏️</button>
        <button onclick="deleteProblem(${problem.id})">🗑️</button>
      </td>
    `;
    tbody.appendChild(row);
  });
}

function editProblem(id) {
  const problem = problems.find(p => p.id === id);
  if (!problem) return;

  const newTitle = prompt("Update title:", problem.title);
  if (newTitle !== null) problem.title = newTitle;

  const newNotes = prompt("Update notes:", problem.notes);
  if (newNotes !== null) problem.notes = newNotes;

  renderProblems();
}

function deleteProblem(id) {
  problems = problems.filter(p => p.id !== id);
  renderProblems();
}
