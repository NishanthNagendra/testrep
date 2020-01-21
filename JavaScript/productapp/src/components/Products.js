import React, { Component } from 'react'
import Search from './Search'
import ProductTable from './ProductTable'
import ProductRow from './ProductRow'

export default class Products extends Component {
    render() {
        return (
            <div>
                Products Parent!!!
                <Search/>
                <ProductTable/>
                <ProductRow/>
            </div>
        )
    }
}
