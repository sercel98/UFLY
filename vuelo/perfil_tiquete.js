var app = new Vue({
    el: '#perfil-tiquete',
    data: {
        tiquete: {},
        usuario: {},
        pasajero: {},
        tipoTiquete: '',
        estadoTiquete: '',
        nombreUsuario: '',
        nombrePasajero: '',
    },

    methods: {
        validarCampos() {

        },

        volverPaginaAtras(id_vuelo)
        {
            location.href = 'perfil_vuelo.html?' + id_vuelo;
        }
    },

    mounted() {
        var urlPagina = window.location.href;
        var posicion = urlPagina.indexOf('?');
        idAeropuerto = urlPagina.substr(posicion + 1, urlPagina.length);
        var urlTiquete = 'http://localhost:8080/rest/tiquetes/' + idAeropuerto;
        fetch(urlTiquete)
        .then(response => response.json())
        .then(tiqueteActual => {
            this.tiquete = tiqueteActual;
            this.tipoTiquete = tiqueteActual.fktipos_tiquete.nombre_tipo;
            this.estadoTiquete = tiqueteActual.fkestado_tiquete.nombre_estado;

            if(tiqueteActual.fkusuarios != null)
            {
                this.usuario = tiqueteActual.fkusuarios;
                if(this.usuario.segundo_nombre != "")
                {
                    this.nombreUsuario = this.usuario.primer_nombre + " " + this.usuario.segundo_nombre + " " + this.usuario.primer_apellido + " "  + this.usuario.segundo_apellido;
                }
                else
                {
                    this.nombreUsuario = this.usuario.primer_nombre + " "  + this.usuario.primer_apellido + " " + this.usuario.segundo_apellido;
                }
            }

            if(tiqueteActual.fkpasajeros != null)
            {
                this.pasajero = tiqueteActual.fkpasajeros;
                if(this.pasajero.segundo_nombre = "")
                {
                    this.nombrePasajero = this.pasajero.primer_nombre + " " + this.pasajero.segundo_nombre + " " + this.pasajero.primer_apellido + " "  + this.pasajero.segundo_apellido;
                }
                else
                {
                    this.nombrePasajero = this.pasajero.primer_nombre + " "  + this.pasajero.primer_apellido + " " + this.pasajero.segundo_apellido;
                }
            }
        })
    }
});