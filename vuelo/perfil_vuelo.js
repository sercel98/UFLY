var app = new Vue({
    el: '#perfil-vuelo',
    data: {
        idVuelo: '',
        embarqueVuelo: '',
        desembarqueVuelo: '',
        numSillasEconomica: '',
        numSillasBusiness: '',
        numSillasPrimera: '',
        horaCheckIn: '',
        avionVuelo: '',
        aeropuertoOrigenVuelo: '',
        aeropuertoDestinoVuelo: '',
        aviones: [],
        aeropuertos: [],
        estadosvuelo: [],
        salaAbordaje,
        salas: [],

        vueloActual: '',
        id_vuelo_origen: ''
    },
    methods: {
        procesarFormulario() {

            var sala = this.salas.find(sala => sala.nombre_sala === this.salaAbordaje)

            this.vueloActual.chequeo = this.horaCheckIn; 
            this.vueloActual.embarque = this.embarqueVuelo; 
            this.vueloActual.desembarque = this.desembarqueVuelo;
            this.vueloActual.sillas_disponibles_bussines = this.numSillasBusiness;
            this.vueloActual.sillas_disponibles_economicos = this.numSillasEconomica; 
            this.vueloActual.sillas_disponibles_primera = this.numSillasPrimera; 

            var url = 'http://localhost:8080/rest/vuelos/' + this.vueloActual.id_vuelo;
            var init = {
                method: 'PUT',
                body: JSON.stringify(this.vueloActual),
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
                        toastr.warning('No se ha podido actualizar el vuelo: ' + response.message);

                    } else {
                        toastr.success('Se ha actualizado el vuelo exitosamente: ')
                    }
                })
        },

        validarCampos: function () {
            
            if (this.numSillasBusiness.toString().length > 0 && !this.numSillasBusiness.toString().startsWith(" ") &&
                this.numSillasEconomica.toString().length > 0 && !this.numSillasEconomica.toString().startsWith(" ") &&
                !this.numSillasPrimera.toString().startsWith(" ") && this.numSillasPrimera.toString().length > 0) {
                this.procesarFormulario();

            } else {
                toastr.warning("La información del vuelo es incompleta!");
            }

        }

    },

    computed: {

    },

    mounted() {

        fetch('http://localhost:8080/rest/aeropuertos')
            .then(response => response.json())
            .then(aeropuertos => {
                this.aeropuertos = aeropuertos;
            });

        fetch('http://localhost:8080/rest/aviones')
            .then(response => response.json())
            .then(aviones => {
                this.aviones = aviones;
            });

        fetch('http://localhost:8080/rest/estadosvuelo')
            .then(response => response.json())
            .then(estadosvuelo => {
                this.estadosvuelo = estadosvuelo;
            });


        //arreglar
        var urlSalas = 'http://localhost:8080/rest/salas/1';

        fetch(urlSalas)
            .then(response => response.json())
            .then(salas => {
                this.salas = salas;
            });

        var urlPagina = window.location.href;
        var posicion = urlPagina.indexOf('?');


        idVuelo = urlPagina.substr(posicion + 1, urlPagina.length);

        var urlVuelos = 'http://localhost:8080/rest/vuelos/' + idVuelo;

        fetch(urlVuelos)
            .then(response => response.json())
            .then(vueloActual => {


                this.embarqueVuelo = vueloActual.embarque,
                this.embarqueVuelo = this.embarqueVuelo.toString().substring(0, 16);
                this.desembarqueVuelo = vueloActual.desembarque,
                this.desembarqueVuelo = this.desembarqueVuelo.toString().substring(0, 16);
                this.numSillasEconomica = vueloActual.sillas_disponibles_economicos,
                    //OJO CON BUSSINES
                this.numSillasBusiness = vueloActual.sillas_disponibles_bussines,
                this.numSillasPrimera = vueloActual.sillas_disponibles_primera,
                this.horaCheckIn = vueloActual.chequeo,
                this.horaCheckIn = this.horaCheckIn.toString().substring(0, 16);
                this.avionVuelo = vueloActual.fkaviones.modelo,
                this.salaAbordaje = vueloActual.fksalas.nombre_sala,
                this.aeropuertoOrigenVuelo = vueloActual.fkaeropuertos_origen.nombre_aeropuerto,
                this.aeropuertoDestinoVuelo = vueloActual.fkaeropuertos_destino.nombre_aeropuerto,
                this.id_vuelo_origen = vueloActual.fkaeropuertos_origen.id_aeropuerto,
                this.vueloActual = vueloActual;
            });


    }
})