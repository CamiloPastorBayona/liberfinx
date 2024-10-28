document.addEventListener("DOMContentLoaded", function() {
    // Función para seleccionar días en el calendario
    const days = document.querySelectorAll(".calendario .dias span");
    days.forEach(day => {
        day.addEventListener("click", function() {
            days.forEach(d => d.classList.remove("active"));
            this.classList.add("active");
        });
    });

    // Función para agregar una nueva nota
    const addNoteBtn = document.querySelector(".plus");
    const notesList = document.querySelector(".notas ul");
    let notes = ["Pagar recibo de luz", "Recordar agregar compromisos bancarios", "Agregar ahorro a la cuenta"];

    addNoteBtn.addEventListener("click", function() {
        const newNote = prompt("Escribe una nueva nota:");
        if (newNote) {
            const li = document.createElement("li");
            li.textContent = newNote;
            notesList.appendChild(li);
            notes.push(newNote);
        }
    });

    // Función para actualizar el balance
    const ingresosElement = document.querySelector(".balance .ingresos");
    const gastosElement = document.querySelector(".balance .gastos");
    const balanceElement = document.querySelector(".balance .balance-total");

    const ingresos = 5800000;
    const gastos = 1900000;

    function actualizarBalance() {
        const balance = ingresos - gastos;
        balanceElement.textContent = `Balance: $${balance.toLocaleString()}`;
    }

    actualizarBalance();

    // Manejo de gráfico de estadísticas de gastos por mes
    const meses = document.querySelectorAll(".estadisticas-gastos .barra");
    const gastosMensuales = [1500000, 1800000, 1700000, 1600000, 1900000, 2100000, 2000000, 2200000, 2300000, 2400000, 1900000, 1800000];

    function actualizarEstadisticas() {
        meses.forEach((barra, index) => {
            barra.style.height = `${gastosMensuales[index] / 10000}px`; // altura de las barras
        });
    }

    actualizarEstadisticas();
});
