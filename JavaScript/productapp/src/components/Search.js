import React, { Component } from 'react'

export default class Search extends Component {
    render() {
        return (
            <React.Fragment>
                <input type="text" onChange={(e) => this.filterEvent(e)} />
            </React.Fragment>
        )
    }

    filterEvent(e) {
        console.log(e.target.value);
        this.props.filterProducts(e.target.value);
    }
}
