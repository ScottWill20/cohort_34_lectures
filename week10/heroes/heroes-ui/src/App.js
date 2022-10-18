import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import HeroGrid from "./components/HeroGrid";
import HeroForm from "./components/HeroForm";
import HeroConfirmDelete from "./components/HeroConfirmDelete";
import NotFound from "./components/NotFound";
import Error from "./components/Error";
import NavBar from "./components/NavBar";

function App() {

  return (
    <Router>
      <NavBar />
      <div className="container">
        <Switch>
          <Route path={["/add", "/edit/:heroId"]}>
            <HeroForm />
          </Route>
          <Route path="/delete/:heroId">
            <HeroConfirmDelete />
          </Route>
          <Route exact path="/">
            <HeroGrid />
          </Route>
          <Route path="/error">
            <Error />
          </Route>
          <Route path="*">
            <NotFound />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
