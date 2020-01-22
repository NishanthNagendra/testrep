import React, { Component } from "react";
import Search from "./Search";
import ProductTable from "./ProductTable";

export default class Products extends Component {
    state = {
        filterText: "",
        products: [
            { id: 1, name: "iPhone" },
            { id: 2, name: "Oppo" },
            { id: 3, name: "iPhone XR" },
            { id: 4, name: "One plus 7" }
        ],
        complete: [
            { id: 1, name: "iPhone" },
            { id: 2, name: "Oppo" },
            { id: 3, name: "iPhone XR" },
            { id: 4, name: "One plus 7" }
        ]
    };
    render() {
        return (
            <div>
                <Search filterProducts={(txt) => this.doFilter(txt)} />
                <ProductTable products={this.state.products} deleteInParentProp={(id) => this.deleteInParent(id)} />
                {/* These are the props passed onto productTable */}
            </div>
        );
    }
    
    doFilter(txt) {
        this.state.filterText = txt;
        console.log("Parent ", txt);
        let res = this.state.complete.filter(p => p.name.toLowerCase().indexOf(txt.toLowerCase()) >= 0);

        this.setState({
            products: res
        })
    }

    deleteInParent(id) {
        console.log("Delete Product In Parent", id);

        let res = this.state.complete.filter(p => p.id !== id);

        this.setState({
            complete: res,
            products: res
        })
    }
}
