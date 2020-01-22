import React, { Component } from 'react'

export default class Ingredients extends Component {
    constructor(props){
        super(props);
    }
    render() {
        const {ingredients} = this.props;
        return (
            <React.Fragment>
                <li>{ingredients.name}</li>
            </React.Fragment>
        )
    }
}
