import React, { Component } from 'react'

export default class Instructions extends Component {
    constructor(props){
        super(props);
    }
    render() {
        const {steps} = this.props;
        return (
            <React.Fragment>
                {steps} <br/> <br />
            </React.Fragment>
        )
    }
}
