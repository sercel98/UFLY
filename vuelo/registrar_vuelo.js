const vuelos = new Vue({

    el: '#registro-vuelo',
    data:
    {
        embarqueVuelo:'',
        desembarqueVuelo:'',
        precioSillaBusiness:'',
        precioSillaPrimera:'',
        precioSillaEconomica:'',
        horaCheckIn:'',
        avionVuelo:'',
        aeropuertoOrigenVuelo:'',
        aeropuertoDestinoVuelo:'', 
        aviones:[], 
        aeropuertos:[],
        estadosvuelo:[],
        
    },
    methods: {
        procesarFormulario(){
            var avion  = this.aviones.find( avion => avion.modelo === this.avionVuelo );
            var aeropuertoOrigen = this.aeropuertos.find( aeropuertoOrigen => aeropuertoOrigen.nombre_aeropuerto === this.aeropuertoOrigenVuelo );
            var aeropuertoDestino = this.aeropuertos.find( aeropuertoDestino => aeropuertoDestino.nombre_aeropuerto === this.aeropuertoDestinoVuelo );

            var precioSillaBusiness = this.precioSillaBusiness;
            var precioSillaPrimera = this.precioSillaPrimera;
            var precioSillaEconomica = this.precioSillaEconomica;

            var vueloActual = {
                "id_vuelo": "",
                "embarque": this.embarqueVuelo,
                "desembarque": this.desembarqueVuelo,
                "sillas_disponibles_primera": avion.numero_sillas_primera,
                "sillas_disponibles_economicos": avion.numero_sillas_economica,
                "sillas_disponibles_business": avion.numero_sillas_business,

                "fkaeropuertos_origen": aeropuertoOrigen,
                "fkaeropuertos_destino": aeropuertoDestino,
                    //por defecto se registra un vuelo como en espera. 
                "fkestados_vuelo": {
                    "id_estado_vuelo": 1,
                    "nombre_estado": "En espera"
                },
                "fkaviones": avion
            }
                
            console.log(vueloActual);

            var url = 'http://localhost:8080/rest/vuelos/agregar/' + precioSillaBusiness
                        + "/" + precioSillaPrimera + "/" + precioSillaEconomica;

            console.log(url);
            
            var init = {
                method: 'POST', 
                body: JSON.stringify(vueloActual), 
                headers:{
                    'Content-Type': 'application/json'
              }};

            var request = new Request(url, init);
            fetch(request)
            .then(response => response.json())
            .catch(error => toastr.error('No se ha podido registrar el vuelo: ' + error))
            .then(response => {
                if(response.status == 500)
                {
                    toastr.info(response.message);
                }
                else
                {
                    toastr.options.timeOut = 600;
                    toastr.options.onHidden = function() { location.href='vuelos.html';};
                    toastr.success('Se ha registrado el vuelo exitosamente: ');

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

        fetch('http://localhost:8080/rest/estadosvuelo')
        .then(response => response.json())
        .then(estadosvuelo =>{
            this.estadosvuelo = estadosvuelo;
        });
    }
});