const vuelos = new Vue({

    el: '#registro-vuelo',
    data:
    {
     
        //campos del vuelo
        embarqueVuelo:'',
        desembarqueVuelo:'',
        numSillasEconomica:'',
        numSillasBusiness:'',
        numSillasPrimera:'',
        horaCheckIn:'',
        avionVuelo:'',
        aeropuertoOrigenVuelo:'',
        aeropuertoDestinoVuelo:'', 
        aviones:[], 
        aeropuertos:[],
        
    },
    methods: {
        procesarFormulario(){

            var avion  = this.aviones.find( avion => avion.modelo === this.avionVuelo )

            var aeropuertoOrigen = this.aeropuertos.find( aeropuertoOrigen => aeropuertoOrigen.nombre_aeropuerto === this.aeropuertoOrigenVuelo )
            var aeropuertoDestino = this.aeropuertos.find( aeropuertoDestino => aeropuertoDestino.nombre_aeropuerto === this.aeropuertoDestinoVuelo )

            console.log(avion); 
            console.log(aeropuertoOrigen); 
            console.log(aeropuertoDestino); 


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

            var url = 'http://localhost:8080/rest/aeropuertos/agregar';
            var init = {
                method: 'POST', 
                body: JSON.stringify(aeropuertoActual), 
                headers:{
                    'Content-Type': 'application/json'
              }};
            var request = new Request(url, init);
            fetch(request)
            .then(response => response.json())
            .catch(error => toastr.error('No se ha podido registrar el aeropuerto: ' + error))
            .then(response => {
                if(response.status == 500)
                {
                    toastr.info(response.message);
                }
                else
                {
                    toastr.options.timeOut = 600;
                    toastr.options.onHidden = function() { location.href='aeropuertos.html';};
                    toastr.success('Se ha registrado el aeropuerto exitosamente: ' + response.nombre_aeropuerto);

                }
            })
        }
    },

    computed: {
      
    },

    mounted(){
        fetch('http://localhost:8080/rest/aeropuertos')
        .then(response => response.json())
        .then(aeropuertos =>{
             this.aeropuertos = aeropuertos;
        });

        fetch('http://localhost:8080/rest/aviones')
        .then(response => response.json())
        .then(aviones =>{
            this.aviones = aviones;
        });

    }
});