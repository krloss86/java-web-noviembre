import React from 'react';
import Contador from './Contador';

class App extends React.Component {

  constructor() {
    super();

    this.state = {
      mostrarContador:false
    }

    this.mostrar = () => this.setState({
      mostrarContador: true
    });

    this.ocultar = () => this.setState({
      mostrarContador: false
    });
  }

  render() {
    return (
      <div className="container">
        { this.state.mostrarContador && 
          <Contador contadoInicial={10}></Contador>
        }
        <div className="row">
          <div className="col-12 mt-5">
            <button onClick={this.mostrar} className="btn btn-info ml-2">Mostrar Contador</button>
            <button onClick={this.ocultar} className="btn btn-info ml-2">Ocultar Contador</button>
          </div>
        </div>
    </div>
    );
  }
}

export default App;
