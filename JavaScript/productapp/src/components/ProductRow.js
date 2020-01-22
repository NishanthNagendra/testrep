import React, { Component } from "react";

export default class ProductRow extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    const { product } = this.props;
    return (
      <React.Fragment>
        <tr>
          <td>{product.id}</td>
          <td>{product.name}</td>
          <td>
            <button type="button" onClick={() => this.deleteInRow(product.id)}>
              Delete Product
            </button>
          </td>
        </tr>
      </React.Fragment>
    );
  }

  deleteInRow(id) {
      console.log("Delete Product in row", id);
      this.props.deleteInTableProp(id);
  }
}
