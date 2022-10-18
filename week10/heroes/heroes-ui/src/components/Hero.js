import { Link } from "react-router-dom";

function Hero({ hero }) {

    return (
        <div className="col">
            <div className="card">
                <img src={hero.imageUrl} className="card-img-top" alt={hero.superName} />
                <div className="card-body">
                    <h5 className="card-title">{hero.superName}</h5>
                    <h5>{hero.realName}</h5>
                </div>
                <div className="card-footer">
                    <Link to={`/delete/${hero.heroId}`} className="btn btn-danger me-2">Delete</Link>
                    <Link to={`/edit/${hero.heroId}`} className="btn btn-secondary">Edit</Link>
                </div>
            </div>
        </div>
    );
}

export default Hero;