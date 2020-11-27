import React from 'react';
import AppService from '../services/appService';
import MensajeriaService from '../services/mensajeriaServices';

class Login extends React.Component {

    constructor() {
        super();
        
        this.state = {
            username: "",
            password: ""
        };

        this.handleChange = event => {
            this.setState(
                {
                    [event.target.name] : event.target.value
                }
            );
        }

        this.appService = AppService.instance;
        this.mensajeriaService = MensajeriaService.instance;
    }
    
    login = event => {

        event.preventDefault();
        
        this.appService.login(this.state.username,this.state.password)
            .subscribe(
                response =>  {
                    this.appService.updateLogged({logged:true});
                    this.mensajeriaService.clearMensaje();
                },
                error => {
                    this.mensajeriaService.error(error);
                }
        )
    }

    componentWillUnmount() {
        this.mensajeriaService.clearMensaje();
    }
    
    render() {
        return (
            <div className="row alert alert-warning">
                <div className="col-4">
                    <form onSubmit={this.login}>
                        <div className="form-group">
                            <label>User Name</label>
                            <input 
                                name="username" 
                                id="username" 
                                type="text" 
                                className="form-control"
                                vaue={this.state.username}
                                onChange={this.handleChange}
                                >
                            </input>
                        </div>
                        <div className="form-group">
                            <input 
                                name="password" 
                                id="password" 
                                type="password"
                                className="form-control"
                                value={this.state.password}
                                onChange={this.handleChange}
                                >
                            </input>
                        </div>
                        <button className="btn btn-primary">Login</button>
                    </form>
                </div>
            </div>
        );
    }
}
export default Login;