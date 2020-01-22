import React, { Component } from "react";
import Ingredients from "./Ingredients";
import Instructions from "./Instructions";

export default class Recipe extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        const { recipe } = this.props;
        return (
            <React.Fragment>
                <h2>{recipe.name}</h2>
                <ul>{recipe.ingredients.map(ingd => { return <Ingredients ingredients={ingd} />; })}</ul>
                <h1>Cooking Instructions</h1>
                {recipe.steps.map(inst => {return <Instructions steps={inst} />; })}
            </React.Fragment>
        );
    }
}
