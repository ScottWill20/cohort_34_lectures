import { Link } from "react-router-dom";

function NavBar() {
    return (
        <nav className="navbar navbar-dark bg-dark mb-2">
            <div className="container">
                <Link to="/" className="navbar-brand">Heroes</Link>
                <div className="col d-flex justify-content-end">
                    <Link to="/add" className="btn btn-primary">Add a Hero</Link>
                </div>
            </div>
        </nav>
    );
}

export default NavBar;