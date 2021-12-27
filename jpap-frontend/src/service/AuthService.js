import React, { Component } from 'react'
import axios from 'axios';


export default class AuthService extends Component {


    authCheck(){
        axios.get('http://localhost:8080/',{headers : { 'Authorization' : 'Basic AA' }} , {credentials: "include"})
        .then( response => {
            window.location = "/student";
        })
        .catch ( error => {
            window.location = "/login";
        });
    }


    componentDidMount(){
        this.authCheck();
    }

    render() {
        return null;
    }
}