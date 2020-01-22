import React, { Component } from "react";
import ProductRow from "./ProductRow";

export default class ProductTable extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        const { products } = this.props;
        return (
            <React.Fragment>
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            products.map(p => {
                                return <ProductRow product={p} key={p.id} deleteInTableProp={(id) => this.deleteInTable(id)} />;
                            })
                        }
                    </tbody>
                </table>
            </React.Fragment>
        );
    }

    deleteInTable(id) {
        this.props.deleteInParentProp(id);
        console.log("Delete Product in Table", id);
    }
}
