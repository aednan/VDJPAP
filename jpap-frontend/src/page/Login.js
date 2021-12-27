import React, { Component } from 'react'
import Signin from '../component/signin';


export default class Login extends Component {

    constructor(props) {
        super(props);

        };

    render() {
        return (
        <div className="App">
      <header className="App-header">
        <Signin/>      
      </header>
    </div>
        )
    }
}
