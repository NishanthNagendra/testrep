import React, { Component } from 'react'
import { ProductConsumer } from '../../Context'
import {Button} from '../../Button'
export default class CartList extends Component {
    render() {
        const { item } = this.props;
        return (
            <ProductConsumer>
                {
                    value => {
                        return (
                            <div className="row">
                                <div className="col-md-2">
                                    <img src={item.img} width="10px" height="10px"/>
                                </div>
                                <div className="col-md-2">
                                    {item.title}
                                </div>
                                <div className="col-md-2">
                                    <Button onClick={(e) => value.increment(item.id)}>+</Button>
                                    <Button onClick={(e) => value.decrement(item.id)}>-</Button>
                                </div>
                                <div className="col-md-2">
                                    {item.count}
                                </div>
                                <div className="col-md-2">
                                    {item.price}
                                </div>
                                <div className="col-md-2">
                                    {item.total}
                                </div>
                            </div>
                        )
                    }
                }
            </ProductConsumer>
        )
    }
}
