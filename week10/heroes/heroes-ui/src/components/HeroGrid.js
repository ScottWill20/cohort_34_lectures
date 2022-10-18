import { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { findAll } from "../services/heroes";
import Hero from "./Hero";


function HeroGrid({ handleEdit, handleDelete }) {

    const [heroes, setHeroes] = useState([]);

    const history = useHistory();

    useEffect(() => {
        findAll()
            .then(setHeroes)
            .catch(() => history.push("/error"));
    }, [history]);

    return (
        <>
            <div className="row row-cols-3 g-2">
                {heroes.map(h => <Hero key={h.heroId} hero={h} handleEdit={handleEdit} handleDelete={handleDelete} />)}
            </div>
        </>
    );
}

export default HeroGrid;