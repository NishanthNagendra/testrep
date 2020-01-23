import React from 'react';
import './App.css';
import {Route, Switch} from 'react-router-dom';
import Navbar from './components/NavBar';
import ProductList from './components/products/ProductList';
import Cart from './components/cart/Cart';
import Default from './components/Default';

function App() {
  return (
    <React.Fragment>
      <Navbar/>
      <Switch>
        <Route path="/cart" component={Cart}/>
        <Route exact path="/" component={ProductList}/>
        <Route component={Default}/>
      </Switch>
    </React.Fragment>
  );
}

export default App;
