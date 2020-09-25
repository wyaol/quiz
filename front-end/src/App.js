import React from 'react';
import './App.css';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Header from './components/Herder';
import GoodsAdd from './components/GoodsAdd';

function App() {
  return (
    <Router>
      <Header />
      <Switch>
        <Route path="/goods/add" component={GoodsAdd}/>
      </Switch>
    </Router>
  );
}

export default App;
