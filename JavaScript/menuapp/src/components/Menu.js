import React, { Component } from "react";
import Recipe from "./Recipe";
import "./../index.css"

export default class Menu extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        const { recipes, title } = this.props;
        return (
            <React.Fragment>
                <div id="border">
                    <h1>{title}</h1>
                    {recipes.map(r => { return <Recipe recipe={r} />; })}
                </div>
            </React.Fragment>

        );
    }
}
