import React, { Component } from 'react'
import { ProductConsumer } from '../../Context'
import CartList from './CartList'

export default class Cart extends Component {
    render() {
        return (
            <React.Fragment>
            <ProductConsumer>
                {
                    value => {
                        return value.cart.map(item => {
                            return <CartList item={item}/>
                        })
                    }
                }
            </ProductConsumer>
            </React.Fragment>
        )
    }
}

{/* <ProductConsumer>
               {
                   value => {
                       return value.cart.map(item => {
                           return <div className="container">
                                    <CartList item={item} />
                                     <div className="float-right mx-10">
                                                SubTotal: {value.cartSubTotal}
                                                <Button onClick={()=> value.checkOut()}>Checkout</Button>
                                    </div>    
                                    </div>
                       })
                    }
               }

           </ProductConsumer> */}