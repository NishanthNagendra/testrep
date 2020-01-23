import React, { Component } from 'react'
import { Button } from '../../Button';
import { ProductConsumer } from '../../Context'

export default class Product extends Component {
    render() {
        const { id, img, inCart } = this.props.product;
        return (
            <ProductConsumer>
                {
                    value => {
                        return <div className="col-md-4 col-lg-3">
                            <div className="card img-container my-2">
                                <img src={img} className="card-img-top" />
                                {
                                    inCart ? (<
                                        Button className="cart-btn">In Cart</Button>) :
                                        (<Button className="cart-btn" onClick={(e) => value.addToCart(id)}><i className="fa fa-cart-plus" /></Button>)
                                }
                            </div>
                        </div>
                    }
                }
            </ProductConsumer>
        )
    }
}
