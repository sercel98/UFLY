var app = new Vue({
    el: '#formulario-perfil-aeropuerto',
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

        aeropuertoActual: {},

        ciudades: [],
        paises: [],
        estadosAeropuerto: []
    },
    methods: {
        procesarFormulario: function () {
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
                .catch(error => alert('No se ha podido actualizar el aeropuerto: ' + error))
                .then(response => alert('Se ha actualizado el aeropuerto exitosamente: '))
        },

        validarCampos: function () {
            if (this.nombreAeropuerto.length > 3 && !this.nombreAeropuerto.startsWith(" ") &&
                this.direccionAeropuerto.length > 5 && !this.direccionAeropuerto.startsWith(" ") &&
                !this.telefonoAeropuerto.startsWith(" ") && this.telefonoAeropuerto.toString().length > 5 ) 
                {
                    this.procesarFormulario();

                } 
                else 
                {
                    alert("LA INFORMACIÓN DEL AEROPUERTO ES INCOMPLETA!"); 
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

        var urlPagina = window.location.href;
        idAeropuerto = urlPagina.charAt(urlPagina.length - 1);

        var url = 'http://localhost:8080/rest/aeropuertos/' + idAeropuerto;

        fetch(url)
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
    }
})