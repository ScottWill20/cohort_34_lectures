const HERO_API_URL = "http://localhost:8080/api/hero";

export async function findAll() {
    const response = await fetch(HERO_API_URL);
    if (response.ok) {
        return response.json();
    } else {
        return Promise.reject();
    }
}

export async function findById(heroId) {
    const response = await fetch(`${HERO_API_URL}/${heroId}`);
    if (response.ok) {
        return response.json();
    } else {
        return Promise.reject();
    }
}

async function add(hero) {

    const init = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(hero)
    };

    const response = await fetch(HERO_API_URL, init);
    if (response.ok) {
        return Promise.resolve();
    } else if (response.status === 400) {
        const errs = await response.json();
        return Promise.reject(errs);
    } else {
        return Promise.reject();
    }
}

async function update(hero) {

    const init = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(hero)
    };

    const response = await fetch(`${HERO_API_URL}/${hero.heroId}`, init);
    if (response.ok) {
        return Promise.resolve();
    } else if (response.status === 400) {
        const errs = await response.json();
        return Promise.reject(errs);
    } else {
        return Promise.reject();
    }
}

export async function save(hero) {
    return hero.heroId > 0 ? update(hero) : add(hero);
}

export async function deleteById(heroId) {
    const init = { method: "DELETE" };
    const response = await fetch(`${HERO_API_URL}/${heroId}`, init);
    if (response.ok) {
        return Promise.resolve();
    } else {
        return Promise.reject();
    }
}