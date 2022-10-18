import { useEffect, useState } from "react";
import { Link, useHistory, useParams } from "react-router-dom";
import { deleteById, findById } from "../services/heroes";

function HeroConfirmDelete() {

    const [hero, setHero] = useState({});

    const history = useHistory();
    const { heroId } = useParams();

    useEffect(() => {
        if (!heroId) {
            history.push("/");
        }

        findById(heroId)
            .then(setHero)
            .catch(() => history.push("/"));
    }, [history, heroId])

    function handleDelete() {
        deleteById(hero.heroId)
            .then(() => history.push("/"))
            .catch(() => history.push("/error"));
    }

    return (
        <div>
            <h2>Delete {hero.superName}?</h2>
            <div className="alert alert-danger">
                <p>
                    This will permanently delete {hero.realName}.
                </p>
                <p>
                    Are you sure?
                </p>
            </div>
            <div>
                <button className="btn btn-danger me-2" onClick={handleDelete}>Delete</button>
                <Link to="/" className="btn btn-warning">Cancel</Link>
            </div>
        </div>
    );
}

export default HeroConfirmDelete;