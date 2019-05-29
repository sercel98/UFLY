var app = new Vue({
    el: '#perfil-avion',
    data:
    {
        idAvion: '',
        fabricante: '',
        modelo: '',
        anio_fabricacion: '',
        numero_sillas_business: '',
        numero_sillas_primera: '',
        numero_sillas_economica: '',
        estadoAvion: '',
        estadosavion: [],
        avionActual: {}
    },

    methods: {
        procesarFormulario() {
            var estadoAvion = this.estadosavion.find(estadoAvion => estadoAvion.nombre_estado === this.estadoAvion)

            console.log(estadoAvion);

            this.avionActual.fabricante = this.fabricante;
            this.avionActual.modelo = this.modelo;
            this.avionActual.anio_fabricacion = this.anio_fabricacion;
            this.avionActual.numero_sillas_business = this.numero_sillas_business;
            this.avionActual.numero_sillas_primera = this.numero_sillas_primera;
            this.avionActual.numero_sillas_economica = this.numero_sillas_economica;
            this.avionActual.fkestados_avion.id_estado_avion = estadoAvion.id_estado_avion;
            this.avionActual.fkestados_avion.nombre_estado = this.estadoAvion;

            var url = 'http://localhost:8080/rest/aviones/' + this.avionActual.id_avion;
            var init = {
                method: 'PUT',
                body: JSON.stringify(this.avionActual),
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);

            fetch(request)
                .then(response => response.json())
                .catch(error => toastr.error('Error: ' + error))
                .then(response => {
                    console.log(response);
                    if (response.status == 500) {
                        toastr.warning('No se ha podido actualizar el avion: ' + response.message);

                    }
                    else {
                        toastr.success('Se ha actualizado el avion exitosamente: ')
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

            } else {
                toastr.warning("La información del avion es incompleta!");
            }
        }
    },

    computed: {
    },

    mounted() {

        fetch('http://localhost:8080/rest/aviones')
            .then(response => response.json())
            .then(aviones => {
                this.aviones = aviones;
            });

        fetch('http://localhost:8080/rest/estadosavion')
            .then(response => response.json())
            .then(estadosavion => {
                console.log(estadosavion);
                this.estadosavion = estadosavion;
            });

        var urlPagina = window.location.href;
        var posicion = urlPagina.indexOf('?');
        idAvion = urlPagina.substr(posicion + 1, urlPagina.length);

        var urlAviones = 'http://localhost:8080/rest/aviones/' + idAvion;

        fetch(urlAviones)
            .then(response => response.json())
            .then(avionActual => {
                this.fabricante = avionActual.fabricante,
                this.modelo = avionActual.modelo
                this.anio_fabricacion = avionActual.anio_fabricacion,
                this.numero_sillas_business = avionActual.numero_sillas_business,
                this.numero_sillas_primera = avionActual.numero_sillas_primera,
                this.numero_sillas_economica = avionActual.numero_sillas_economica
                this.estadoAvion = avionActual.fkestados_avion.nombre_estado,
                this.avionActual = avionActual
            });
    }
})