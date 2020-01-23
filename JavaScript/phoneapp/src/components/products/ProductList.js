import React, { Component } from 'react'
import { ProductConsumer } from '../../Context'
import Product from './Product'

export default class ProductList extends Component {
    render() {
        return (
            <div className="container">
                {/* container is from bootstrap it ensures components adjust according to size*/}
                <div className="row">
                    <ProductConsumer>
                        {
                            value => {
                                return value.products.map(product => {
                                    return <Product product={product} key={product.id}/>
                                })
                            }
                        }
                    </ProductConsumer>
                </div>
            </div>
        )
    }
}
