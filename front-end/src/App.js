import React from 'react';
import './App.css';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Header from './components/Herder';
import GoodsAdd from './components/GoodsAdd';
import GoodsList from './components/GoodsList';
import OrdersList from './components/OrdersList';

function App() {
  return (
    <Router>
      <Header />
      <Switch>
        <Route path="/goods/add" component={GoodsAdd}/>
        <Route path="/goods" component={GoodsList}/>
        <Route path="/orders" component={OrdersList}/>
      </Switch>
    </Router>
  );
}

export default App;
