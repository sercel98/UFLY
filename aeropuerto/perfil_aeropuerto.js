var app = new Vue({
    el: '#perfil-aeropuerto',
    data:
    {
        idAeropuerto: '',
        nombreAeropuerto: '',
        codigoAeropuerto: '',
        ciudadAeropuerto: '',
        paisAeropuerto: '',
        direccionAeropuerto: '',
        telefonoAeropuerto: '',
        estadoAeropuerto: '',
        nuevaSala: '',
        nuevoEstadoSala: '',

        aeropuertoActual: {},
        salasActuales: {},

        ciudades: [],
        paises: [],
        estadosAeropuerto: [],
        estadosSala: []
    },
    methods: {
        procesarFormulario() {
            var pais = this.paises.find(pais => pais.nombre_pais === this.paisAeropuerto)
            var ciudad = this.ciudades.find(ciudad => ciudad.nombre_ciudad === this.ciudadAeropuerto)
            var estadoAeropuerto = this.estadosAeropuerto.find(estadoAeropuerto => estadoAeropuerto.nombre_estado === this.estadoAeropuerto)

            this.aeropuertoActual.nombre_aeropuerto = this.nombreAeropuerto;
            this.aeropuertoActual.direccion_aeropuerto = this.direccionAeropuerto;
            this.aeropuertoActual.telefono = this.telefonoAeropuerto;

            this.aeropuertoActual.fkestados_aeropuerto.id_estado_aeropuerto = estadoAeropuerto.id_estado_aeropuerto;
            this.aeropuertoActual.fkestados_aeropuerto.nombre_estado = this.estadoAeropuerto;

            this.aeropuertoActual.fkciudades.id_ciudad = ciudad.id_ciudad;
            this.aeropuertoActual.fkciudades.nombre_ciudad = this.ciudadAeropuerto;

            this.aeropuertoActual.fkciudades.fkpais.id_pais = pais.id_pais;
            this.aeropuertoActual.fkciudades.fkpais.nombre_pais = this.paisAeropuerto;

            var url = 'http://localhost:8080/rest/aeropuertos/' + this.aeropuertoActual.id_aeropuerto;
            var init = {
                method: 'PUT',
                body: JSON.stringify(this.aeropuertoActual),
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);

            fetch(request)
            .then(response => response.json())
            .catch(error => toastr.error('No se ha podido actualizar el aeropuerto: ' + error))
            .then(response => {
                console.log(response);
                if(response.status == 500)
                {
                    toastr.info(response.message);
                }
                else
                {
                    toastr.options.onHidden = function() { location.href='aeropuertos.html';}
                    toastr.options.timeOut = 1000;
                    toastr.success('Se ha actualizado el aeropuerto exitosamente: ' + response.nombre_aeropuerto)
                }
            })
        },

        registrarSala: function() {

        },

        actualizarSala: function(sala) {
            
            var estadosSala = this.estadosSala.find(estadoSala => estadoSala.nombre_estado === sala.fkestado_sala.nombre_estado);
            sala.fkestado_sala = estadosSala;

            var url = 'http://localhost:8080/rest/salas/' + sala.id_sala;
            var init = {
                method: 'PUT',
                body: JSON.stringify(sala),
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);

            fetch(request)
            .then(response => response.json())
            .catch(error => toastr.error('No se ha podido actualizar la sala: ' + error))
            .then(response => {
                console.log(response);
                if(response.status == 500)
                {
                    toastr.info(response.message);
                }
                else
                {
                    toastr.success('Se ha actualizado la sala exitosamente: ' + response.nombre_sala)
                }
            })
        },

        validarCampos: function () {
            if (this.nombreAeropuerto.length > 3 && !this.nombreAeropuerto.startsWith(" ") &&
                this.direccionAeropuerto.length > 5 && !this.direccionAeropuerto.startsWith(" ") &&
                !this.telefonoAeropuerto.startsWith(" ") && this.telefonoAeropuerto.toString().length > 5) {
                this.procesarFormulario();

            }
            else {
                toastr.warning("LA INFORMACIÓN DEL AEROPUERTO ES INCOMPLETA!");
            }

        }

    },

    computed: {
        buscarCiudades: function () {
            return this.ciudades.filter((ciudad) => ciudad.fkpais.nombre_pais.toLowerCase().includes(this.paisAeropuerto.toLowerCase()));
        }
    },

    mounted() {
        fetch('http://localhost:8080/rest/paises')
        .then(response => response.json())
        .then(paises => {
            this.paises = paises;
        });

        fetch('http://localhost:8080/rest/ciudades')
        .then(response => response.json())
        .then(ciudades => {
            this.ciudades = ciudades;
        });

        fetch('http://localhost:8080/rest/estadosaeropuerto')
        .then(response => response.json())
        .then(estadosaeropuerto => {
            this.estadosAeropuerto = estadosaeropuerto;
        });

        fetch('http://localhost:8080/rest/estadossala')
        .then(response => response.json())
        .then(estadossala => {
            console.log(estadossala);
            this.estadosSala = estadossala;
        });
            
        var urlPagina = window.location.href;
        var posicion = urlPagina.indexOf('?');
        idAeropuerto = urlPagina.substr(posicion + 1, urlPagina.length);

        var urlAeropuertos = 'http://localhost:8080/rest/aeropuertos/' + idAeropuerto;

        fetch(urlAeropuertos)
        .then(response => response.json())
        .then(aeropuertoActual => {
            this.nombreAeropuerto = aeropuertoActual.nombre_aeropuerto,
            this.direccionAeropuerto = aeropuertoActual.direccion_aeropuerto,
            this.telefonoAeropuerto = aeropuertoActual.telefono,
            this.estadoAeropuerto = aeropuertoActual.fkestados_aeropuerto.nombre_estado,
            this.ciudadAeropuerto = aeropuertoActual.fkciudades.nombre_ciudad,
            this.paisAeropuerto = aeropuertoActual.fkciudades.fkpais.nombre_pais

            this.aeropuertoActual = aeropuertoActual;
        });

        var urlSalas = 'http://localhost:8080/rest/salas/' + idAeropuerto;

        fetch(urlSalas)
        .then(response => response.json())
        .then(salas => {
            console.log(salas);
            this.salasActuales = salas;
        });
    }
})