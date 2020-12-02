const { BehaviorSubject } = require("rxjs");

class ProuctoDataService {

    constructor() {
        if(!ProuctoDataService.instance) {
            this.mensajeSubject = new BehaviorSubject([]);
            this.currentData = this.mensajeSubject.asObservable();

            this.updateProductos = (productos) => {
                this.mensajeSubject.next(productos);
            }

            this.getProductos = () => {
                return this.currentData;
            }

            this.getProductosValue = () => {
                return this.currentData.source.value;
            }
        }
        ProuctoDataService.instance = this;
        return this;
    }
}

const instance = new ProuctoDataService();

Object.freeze(instance);

export default ProuctoDataService;