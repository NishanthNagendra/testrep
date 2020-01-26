import React, { Component } from 'react'
import ListCourses from './ListCourses'

export default class InstrcutorApp extends Component {
    render() {
        return (
            <React.Fragment>
                <h1>Instrcutor App</h1>
                <ListCourses />
            </React.Fragment>
        )
    }
}