import { useEffect, useState } from "react";
import { Link, useHistory, useParams } from "react-router-dom";
import { findById, save } from "../services/heroes";
import { findAll } from "../services/powers";

function HeroForm() {

    const [hero, setHero] = useState({
        heroId: 0,
        superName: "",
        realName: "",
        imageUrl: "",
        powers: []
    });

    const [powers, setPowers] = useState([]);
    const [errs, setErrs] = useState([]);

    const history = useHistory();
    const { heroId } = useParams();

    useEffect(() => {
        if (heroId) {
            findById(heroId)
                .then(setHero)
                .catch(() => history.push("/"));
        }
    }, [history, heroId]);

    useEffect(() => {
        findAll()
            .then(setPowers)
            .catch(() => history.push("/error"));
    }, [history, heroId])

    function handleChange(evt) {
        const nextHero = { ...hero };
        if (evt.target.name === "powers") {
            const powerId = parseInt(evt.target.value, 10);
            if (evt.target.checked) {
                nextHero.powers.push(powers.find(p => p.powerId === powerId));
            } else {
                nextHero.powers = nextHero.powers.filter(p => p.powerId !== powerId);
            }
        } else {
            nextHero[evt.target.name] = evt.target.value;
        }
        setHero(nextHero);
    }

    function handleSubmit(evt) {
        evt.preventDefault();

        save(hero)
            .then(() => history.push("/"))
            .catch(errs => {
                if (errs) {
                    setErrs(errs);
                } else {
                    history.push("/error")
                }
            });
    }

    return (
        <form onSubmit={handleSubmit}>
            <h2>{heroId > 0 ? "Edit Hero" : "Add Hero"}</h2>
            <div className="mb-3">
                <label htmlFor="superName" className="form-label">Super Name</label>
                <input type="text" name="superName" id="superName" className="form-control"
                    value={hero.superName} onChange={handleChange} />
            </div>
            <div className="mb-3">
                <label htmlFor="realName" className="form-label">Real Name</label>
                <input type="text" name="realName" id="realName" className="form-control"
                    value={hero.realName} onChange={handleChange} />
            </div>
            <div className="mb-3">
                <label htmlFor="imageUrl" className="form-label">Image URL</label>
                <input type="url" name="imageUrl" id="imageUrl" className="form-control"
                    value={hero.imageUrl} onChange={handleChange} />
            </div>
            <div className="mb-3 form-check">
                {powers.map(power => (
                    <div>
                        <input type="checkbox"
                            className="form-check-input"
                            name="powers"
                            id={"power" + power.powerId}
                            value={power.powerId}
                            checked={hero.powers.find(p => p.powerId === power.powerId) !== undefined}
                            onChange={handleChange}></input>
                        <label htmlFor={"power" + power.powerId} className="form-check-label">{power.name}</label>
                    </div>
                ))}
            </div>
            {errs.length !== 0 && <div className="alert alert-danger">
                <ul>
                    {errs.map(err => <li key={err}>{err}</li>)}
                </ul>
            </div>}
            <div className="mb-3">
                <button className="btn btn-primary me-2" type="submit">Save</button>
                <Link to="/" className="btn btn-warning">Cancel</Link>
            </div>
        </form>
    );
}

export default HeroForm;