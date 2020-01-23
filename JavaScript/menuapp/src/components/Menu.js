import React, { Component } from "react";
import Recipe from "./Recipe";
export default class Menu extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        const { recipes, title } = this.props;
        let styles = {
            margin: '20px',
            width: 'max-content',
            height: 'max-content',
            border: "solid 1px",
            paddingLeft: "15px",
            paddingRight: "15px"
          };
        return (
            <React.Fragment>
                <div style={styles}>
                    <h1>{title}</h1>
                    {recipes.map(r => { return <Recipe recipe={r} />; })}
                </div>
            </React.Fragment>

        );
    }
}
