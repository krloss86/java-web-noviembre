import React from 'react';
import MensajeriaService from '../services/mensajeriaServices';

class Mensajeria extends React.Component {

    constructor() {
        super();

        this.state = {
            mensaje: null,
            type: null
        };

        this.mensajeriaService = MensajeriaService.instance;
    }

    componentDidMount() {
        this.mensajeriaService.getCurrent().subscribe(
            data =>  {
                this.setState(
                    {
                        mensaje: null || data.mensaje,
                        type: null || data.type
                    }
                );
            }
        );
    }

    render() {
        let className = `row ${this.state.type}`;
        return (
            <>
                { this.state.mensaje !=null && 
                    <div className={className} role="alert">
                        <div className="col-12">
                            {this.state.mensaje}
                        </div>
                    </div> 
                }    
            </>
        );
    }
}

export default Mensajeria;