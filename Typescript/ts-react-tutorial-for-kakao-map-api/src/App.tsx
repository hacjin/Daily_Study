import React, { useEffect } from 'react';
import Router, { Link, BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import App2 from './App2';

const App: React.FC = () => {
  function getUser() {
    fetch('http://13.125.55.96:8080/user/login?email=join@test.com&password=1234', {
      method: 'GET'
    })
      .then(res => res.json())
      .then(json => {
        window.sessionStorage.setItem('user', JSON.stringify(json.data));
      });
  }
  useEffect(() => {
    getUser();
  });

  return (
    <div>
      <BrowserRouter>
        <Switch>
          <Route path="/map" component={App2} />
          <Link to="/map">클릭</Link>
        </Switch>
      </BrowserRouter>
    </div>
  );
};

export default App;
