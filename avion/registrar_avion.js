const aeropuertos = new Vue({

    el: '#registro-avion',
    data:
    {
        fabricante: '',
        modelo: '',
        añoFabricacion: '',
        numeroSillasBusiness: '',
        numeroSillasPrimera: '',
        numeroSillasEconomica: '',
        estadoAvion: '',
        estadosAvion: []
    },

    methods: {
        procesarFormulario() {

            var estadoAvion = this.estadosAvion.find(estadoAvion => estadoAvion.nombre_estado === this.estadoAvion)

            var avionActual = {
                "id_avion": "",
                "fabricante": this.fabricante,
                "modelo": this.modelo,
                "anio_fabricacion": this.añoFabricacion,
                "numero_sillas_business": this.numeroSillasBusiness,
                "numero_sillas_primera": this.numeroSillasPrimera,
                "numero_sillas_economica": this.numero_sillas_economica,
                "fkestados_avion": {
                    "id_estado_avion": estadoAvion.id_estado_avion,
                    "nombre_estado": estadoAvion.nombre_estado
                }
            }

            var url = 'http://localhost:8080/rest/aviones/agregar';
            var init = {
                method: 'POST',
                body: JSON.stringify(avionActual),
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);
            fetch(request)
                .then(response => response.json())
                .catch(error => toastr.error('No se ha podido registrar el avion: ' + error))
                .then(response => {
                    if (response.status == 500) {
                        toastr.info(response.message);
                    }
                    else {
                        toastr.options.timeOut = 600;
                        toastr.options.onHidden = function () { location.href = 'avion.html'; };
                        toastr.success('Se ha registrado el avion exitosamente: ');

                    }
                })
        },

        validarCampos: function () {
            if (this.fabricante.length > 3 && !this.fabricante.startsWith(" ") &&
                this.modelo.length > 5 && !this.modelo.startsWith(" ") &&
                !this.añoFabricacion.startsWith(" ") && this.añoFabricacion.toString().length > 5 &&
                this.numeroSillasBusiness.length > 5 && !this.numeroSillasBusiness.startsWith(" ") &&
                this.numeroSillasPrimera.length > 5 && !this.numeroSillasPrimera.startsWith(" ") &&
                this.numeroSillasEconomica.length > 5 && !this.numeroSillasEconomica.startsWith(" ")) {
                this.procesarFormulario();

            }
            else {
                toastr.warning("LA INFORMACIÓN DEL AVION ES INCOMPLETA!");
            }
        },
    },

    mounted(){

        fetch('http://localhost:8080/rest/estadosavion')
        .then(response => response.json())
        .then(estadosAvion => {
            
            this.estadosAvion = estadosAvion;
            console.log(this.estadosAvion);
        });
    }
});