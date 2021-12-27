import logo from './logo.svg';
import './App.css';
import StudentTable from './page/StudentTable';
import Login from './page/Login';
import { BrowserRouter,Switch, Route } from 'react-router-dom';
import AuthService from './service/AuthService';

function App() {
  return (
<>
      <BrowserRouter>
        <Switch>
          <Route path='/' exact component={AuthService} />
          <Route path='/login' exact component={Login} />
          <Route path='/student' exact component={StudentTable} />
          <Route path='/:other' component={AuthService}/>
          </Switch>
        </BrowserRouter>

</>

  );
}

export default App;
