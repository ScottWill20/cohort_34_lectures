// HTML Elements
const form = document.getElementById("test-form");
const h1 = document.getElementById("greeting-insert");
const input = document.getElementById("greeting-input");

// Functions
const handleFormSubmit = (event) => {
    event.preventDefault();
    const inputText = input.value;
    h1.innerText = inputText;
}

// Event Triggers
form.addEventListener("submit", handleFormSubmit);