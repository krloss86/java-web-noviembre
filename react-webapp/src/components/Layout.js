import React from 'react';
import AppService from '../services/appService';
// import Form from './Form';
// import Listado from './Listado';
import Login from './Login';
// import Mensajeria from './Mensajeria';
// import Navbar from './Navbar';

class Layout extends React.Component {

    //constructor
    constructor() {
        super();
        this.appService = AppService.instance;
        
        //obtiene el token desde el localStorage
        let token = localStorage.getItem('Access-Token');
        
        this.state = {
            logged: token != null
        };
    }

    render() {

        return(
            <div className="container-fluid">
                {/* <Mensajeria></Mensajeria> */}
                {
                    !this.state.logged && 
                    <Login></Login>
                }               
            </div>
        );
    }

    componentDidMount() {
        this.appService.getCurrent().subscribe(
            data => {
                this.setState({
                    logged: data.logged
                })
            }
        );
    }

    componentWillUnmount() {
        this.appService.getCurrent().unsubscribe();
    }
}

export default Layout;