import React from 'react';
import AppService from '../services/appService';


class Navbar extends React.Component  {

    constructor() {
        super();
        let base64 = atob(localStorage.getItem('Access-Token'));
        
        let username = base64.split(":")[0];
        localStorage.setItem("username", username);

        this.state = {
            username: username
        }

        this.appService = AppService.instance;
    }

    logout = event => {
        event.preventDefault();
        this.appService.logout();
    }

    render() {
        return (
            <div className="row">
                <div className="col-12">
                    <form onSubmit={this.logout}>
                        <div className="form-gruop">
                            <label>Usuario: {this.state.username}</label>
                            <button className="btn btn-info pull-right">Logout</button>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}

export default Navbar;