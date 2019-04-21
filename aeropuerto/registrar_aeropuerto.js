const aeropuertos = new Vue({

    el: '#formulario-registro-aeropuerto',
    data:
    {
        nombreAeropuerto: '',
        codigoAeropuerto: '',
        ciudadAeropuerto: '',
        paisAeropuerto: '',
        direccionAeropuerto: '',
        telefonoAeropuerto: '',
        estadoAeropuerto: '',

        ciudades: [],
        paises: [],
        estadosAeropuerto: []
    },
    methods: {
        procesarFormulario(){

            var pais = paises.find( pais => pais.nombre_pais === this.paisAeropuerto )
            var ciudad = ciudades.find( ciudad => ciudad.nombre_ciudad === this.ciudadAeropuerto )
            var estadoAeropuerto = estadosAeropuerto.find( estadoAeropuerto => estadoAeropuerto.nombre_estado === this.estadoAeropuerto )

            var aeropuertoActual = {
                "id_aeropuerto": "",
                "nombre_aeropuerto": this.nombreAeropuerto,
                "direccion_aeropuerto": this.direccionAeropuerto,
                "telefono": this.telefonoAeropuerto,
                "fkestados_aeropuerto": {
                    "id_estado_aeropuerto": estadoAeropuerto.nombre_estado,
                    "nombre_estado": this.estadoAeropuerto.nombre_estado
                },
                "fkciudades": {
                    "id_ciudad": ciudad.id_ciudad,
                    "nombre_ciudad": this.ciudadAeropuerto,
                    "fkpais": {
                        "id_pais": pais.id_aeropuerto,
                        "nombre_pais": this.paisAeropuerto.nombre_pais
                    }
                }
            }

            console.log(aeropuertoActual);
            var url = 'http://localhost:8080/aeropuertos/agregar';
            var init = {method: 'POST', body: JSON.stringify(aeropuertoActual), mode: cors};
            var request = new Request(url, init);

            fetch(request)
            .then(response => response.json())
            .catch(error => alert('No se ha podido registrar el aeropuerto: ' + error))
            .then(response => alert('Se ha registrado el aeropuerto exitosamente: ' + response))
            location.href='aeropuertos.html'
        }
    },

    computed: {
        buscarCiudades: function () {
            return this.ciudades.filter((ciudad) => ciudad.fkpais.nombre_pais.toLowerCase().includes(this.paisAeropuerto.toLowerCase()));
        }
    },

    mounted(){
        fetch('http://localhost:8080/paises/listar')
        .then(response => response.json())
        .then(paises =>{
             this.paises = paises;
             console.log(paises)
        });

        fetch('http://localhost:8080/ciudades/listar')
        .then(response => response.json())
        .then(ciudades =>{
            this.ciudades = ciudades;
            console.log(ciudades)
        });

        fetch('http://localhost:8080/estadosaeropuerto/listar')
        .then(response => response.json())
        .then(estadosaeropuerto =>{
            this.estadosaeropuerto = estadosaeropuerto;
            console.log(estadosaeropuerto)
        });
    }
});