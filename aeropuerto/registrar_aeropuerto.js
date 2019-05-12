const aeropuertos = new Vue({

    el: '#registro-aeropuerto',
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

            var pais = this.paises.find( pais => pais.nombre_pais === this.paisAeropuerto )
            var ciudad = this.ciudades.find( ciudad => ciudad.nombre_ciudad === this.ciudadAeropuerto )
            var estadoAeropuerto = this.estadosAeropuerto.find( estadoAeropuerto => estadoAeropuerto.nombre_estado === this.estadoAeropuerto )

            var aeropuertoActual = {
                "id_aeropuerto": "",
                "nombre_aeropuerto": this.nombreAeropuerto,
                "direccion_aeropuerto": this.direccionAeropuerto,
                "telefono": this.telefonoAeropuerto,
                "fkestados_aeropuerto": {
                    "id_estado_aeropuerto": estadoAeropuerto.id_estado_aeropuerto,
                    "nombre_estado": estadoAeropuerto.nombre_estado
                },
                "fkciudades": {
                    "id_ciudad": ciudad.id_ciudad,
                    "nombre_ciudad": this.ciudadAeropuerto,
                    "fkpais": {
                        "id_pais": pais.id_pais,
                        "nombre_pais": this.paisAeropuerto
                    }
                }
            }

            console.log(aeropuertoActual);
            var url = 'http://localhost:8080/rest/aeropuertos/agregar';
            var init = {method: 'POST', body: JSON.stringify(aeropuertoActual), headers:{
                'Content-Type': 'application/json'
              }};
            var request = new Request(url, init);
            fetch(request)
            .then(response => response.json())
            .catch(error => toastr.error('No se ha podido registrar el aeropuerto: ' + error))
            .then(response => toastr.success('Se ha registrado el aeropuerto exitosamente: ' + response.nombre_aeropuerto)); 
            toastr.options.onHidden = function() { location.href='aeropuertos.html';}
            toastr.options.onclick = function() { location.href='aeropuertos.html'; }
        },
        validarCampos:function()
        {
            if (this.nombreAeropuerto.length > 3 && !this.nombreAeropuerto.startsWith(" ") &&
            this.direccionAeropuerto.length > 5 && !this.direccionAeropuerto.startsWith(" ") &&
            !this.telefonoAeropuerto.startsWith(" ") && this.telefonoAeropuerto.toString().length > 5 ) 
            {
                this.procesarFormulario();

            } 
            else 
            {
                toastr.warning("LA INFORMACIÓN DEL AEROPUERTO ES INCOMPLETA!"); 
            }
        }
    },

    computed: {
        buscarCiudades: function () {
            return this.ciudades.filter((ciudad) => ciudad.fkpais.nombre_pais.toLowerCase().includes(this.paisAeropuerto.toLowerCase()));
        }
    },

    mounted(){
        fetch('http://localhost:8080/rest/paises')
        .then(response => response.json())
        .then(paises =>{
             this.paises = paises;
             console.log(paises)
        });

        fetch('http://localhost:8080/rest/ciudades')
        .then(response => response.json())
        .then(ciudades =>{
            this.ciudades = ciudades;
            console.log(ciudades)
        });

        fetch('http://localhost:8080/rest/estadosaeropuerto')
        .then(response => response.json())
        .then(estadosaeropuerto =>{
            this.estadosAeropuerto = estadosaeropuerto;
            console.log(estadosaeropuerto)
        });
    }
});