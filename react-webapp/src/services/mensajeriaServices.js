const { BehaviorSubject } = require("rxjs");

class MensajeriaService {

    constructor() {
        if(!MensajeriaService.instance) {
            this.mensajeSubject = new BehaviorSubject({});
            this.currentData = this.mensajeSubject.asObservable();

            this.updateMensaje = (nuevoMensaje) => {
                this.mensajeSubject.next(nuevoMensaje);
            }
        
            this.getCurrent = () => {
                return this.currentData;
            }
        
            this.error = (errorObj) => {
                const error = {
                    mensaje: errorObj.message || 'Error inesperado',
                    type: 'alert alert-danger'
                };
                this.mensajeSubject.next(error);
            }

            this.success = (message) => {
                const newMessage = {
                    mensaje: message,
                    type: 'alert alert-success'
                };
                this.mensajeSubject.next(newMessage);
            }
        
            this.clearMensaje = () => {
                const newMessage = {
                    mensaje: null,
                    type: null
                };
                this.mensajeSubject.next(newMessage);
            }
        }

        MensajeriaService.instance = this;
        return this;
    }

}

const instance = new MensajeriaService();

Object.freeze(instance);

export default MensajeriaService;