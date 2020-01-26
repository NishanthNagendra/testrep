import React, { Component } from 'react';
// import {storeProducts, detailProduct} from './data';
import axios from 'axios';

const ProductContext = React.createContext();

// Provider
// Consumer

class ProductProvider extends Component {
    state = {
        products : [],
        cart: [],
        detailProduct: {},
        cartSubTotal : 0,
        cartTax : 0,
        cartTotal : 0
    }
    componentDidMount(){
        //  this.setProducts();
        // above line is required only if static data is used
        axios.get("http://localhost:8080/phones")
        .then((response) => {
            var prds = [...response.data];
            this.setState({
                products : prds,
                detailProduct : prds[0]
            })
        })
    }
    setProducts = () => {
        // let prds = [];
        // storeProducts.forEach(p => {
        //     let product = {...p};
        //     prds = [...prds,product];
        // });

        // this.setState({
        //     products: prds,
        //     detailProduct : detailProduct
        // })
    }

    getItem =(id) => {
       let p = this.state.products.filter(prd => prd.id === id) [0];
       return p;
    }

    handleDetail = (id) => {
       console.log("detail " + id);
    }

    addToCart = (id) => {
        let p = this.getItem(id);
        p.total = p.price;
        p.count = 1;
        p.inCart = true;
        let cartContent = this.state.cart;
        this.setState({
            cart : [...cartContent, p]
        }, () => this.addTotal())
    }

    increment = (id) => {
        let p = this.getItem(id);
        p.count += 1
        p.total += p.price;
        this.addTotal()
    }

    decrement = (id) => {
        let p = this.getItem(id);
        if (p.count === 1){
            this.removeItem(id);
        }
        else{
            p.count -= 1
            p.total -= p.price;
            this.addTotal();
        }
    }

    removeItem = (id) => {
        let cartcontent = this.state.cart;
        let res = cartcontent.filter(p => p.id!==id)
        this.setState({
            cart : [...res]
        }, () => this.addTotal())
    }

    clearCart = () => {
        
    }

    checkOut = () => {
       
    }
    addTotal = () => {
        let subTotal = 0.0;
        this.state.cart.map(item => {
            subTotal += item.total;
        }); 

        const tempTax = subTotal *0.1;
        const tax = parseFloat(tempTax.toFixed(2));
        const total = subTotal + tax ;
        this.setState(() => {
            return {
                cartSubTotal : subTotal,
                cartTax : tax,
                cartTotal : total
            }
        });
    }
    render() {
        return (
            <ProductContext.Provider value={{
                ...this.state,
                handleDetail: this.handleDetail,
                addToCart: this.addToCart,
                increment: this.increment,
                decrement: this.decrement,
                removeItem : this.removeItem,
                clearCart: this.clearCart,
                checkOut: this.checkOut
            }}>
                {this.props.children}                
            </ProductContext.Provider>
        );
    }
}


const ProductConsumer = ProductContext.Consumer;

export {ProductProvider, ProductConsumer};