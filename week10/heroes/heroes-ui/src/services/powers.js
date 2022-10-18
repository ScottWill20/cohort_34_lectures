const POWER_API_URL = "http://localhost:8080/api/power";

export async function findAll() {
    const response = await fetch(POWER_API_URL);
    if (response.ok) {
        return response.json();
    } else {
        return Promise.reject();
    }
}