import React from 'react';
import Producto from './Producto';
// import axios from 'axios';
import ProuctoDataService from '../services/productoDataService';
import ProductoServie from '../services/productoService';

class Listado extends React.Component {

    constructor() {
        super();

        this.state = {
            productos: []
        };

        this.productoDataService = ProuctoDataService.instance;
        this.productoService = ProductoServie.instance;
    }

    componentDidMount() {
        this.productoService.findAll().subscribe(
            data =>  {
                console.log('this.productoService.findAll()');
                this.productoDataService.updateProductos(data.response)
            }
        );

        this.productoDataService.getProductos().subscribe(
            data => {
                console.log('this.productoDataService.getProductos()');
                this.setState(
                    {
                        productos: data
                    }
                )
            }
        );
    }

    render() {

        return (
            <div className="row">
                <div className="col-12">
                    <div className="row mt-3">
                        <div className="col-12">
                            <table className="table">
                                <thead>
                                    <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Código</th>
                                    <th scope="col">Descripción</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Tipo Produto</th>
                                    <th></th>
                                    </tr>
                                </thead>
                                <tbody>                        
                                    {
                                        this.state.productos
                                            .map(function(producto, index){
                                                return <Producto key={index} producto={producto}></Producto>
                                        })
                                    }
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
export default Listado;