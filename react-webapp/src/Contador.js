import React from 'react';

class Contador extends React.Component {

    constructor(){
        //obligatorio invocar al constructor del padre
        super();

        //ahora tengo acceso al this        
        this.state = {
            contador: 0
        }

        //agregar metodos propios del this
        this.incrementar = () => this.setState(
            {
                contador: this.state.contador + 1
            }
        );

        this.decrementar = () => this.setState(
            {
                contador: this.state.contador-1
            }
        );
    }

    //CLICLO DE VIDA
    componentWillMount() {
        let contadorenviadodesdeapp = this.props.contadoInicial;
        this.setState({contador:contadorenviadodesdeapp});
        console.log('componentWillMount', contadorenviadodesdeapp);
    }

    //metodo ppal de un componente react
    render() {
        console.log('render');

        let contadorenviadodesdeapp = this.props.contadoInicial;
        console.log(contadorenviadodesdeapp);

        //jsx
        return(
            //aca va el codigo html que mostraremos
            <div className="row">
                <div className="col-12">
                    <div className="alert alert-warning">
                        {this.state.contador}
                    </div>
                </div>
                <div className="col-12">
                    <button className="btn btn-info ml-2" onClick={this.incrementar}>Incrementar</button>
                    <button className="btn btn-success ml-2" onClick={this.decrementar}>Decrementar</button>
                </div>
            </div>
        );
    }

    componentDidMount() {
        console.log('componentDidMount');
        this.setState({
            contador: this.state.contador+1
        });
    }

    componentWillUnmount() {
        console.log('componentWillUnmount');
        alert('Adios mundo cruel')
    }
}

export default Contador;