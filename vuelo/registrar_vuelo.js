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
        estadosvuelo:[],
        salaAbordaje,
        salas:[],
        
    },
    methods: {

        cargarSalas: function()
        {

            salas = this.salas.filter((sala) => sala.fkaeropuertos.id_aeropuerto === this.aeropuertoOrigenVuelo.id_aeropuerto);
        },
    
        procesarFormulario(){

            var avion  = this.aviones.find( avion => avion.modelo === this.avionVuelo )

            var sala = this.salas.find(sala => sala.nombre_sala === this.salaAbordaje )
            
            var aeropuertoOrigen = this.aeropuertos.find( aeropuertoOrigen => aeropuertoOrigen.nombre_aeropuerto === this.aeropuertoOrigenVuelo )
            var aeropuertoDestino = this.aeropuertos.find( aeropuertoDestino => aeropuertoDestino.nombre_aeropuerto === this.aeropuertoDestinoVuelo )

            console.log(avion); 
            console.log(aeropuertoOrigen); 
            console.log(aeropuertoDestino); 


            var vueloActual = {
                            "id_vuelo": "",
                            "embarque": this.embarqueVuelo,
                            "desembarque": this.desembarqueVuelo,
                            "sillas_disponibles_primera": this.numSillasPrimera,
                            "sillas_disponibles_economicos": this.numSillasEconomica,
                            "sillas_disponibles_bussines": this.numSillasBusiness,

                            "fkaeropuertos_origen": {
                                "id_aeropuerto": aeropuertoOrigen.id_aeropuerto,
                                "nombre_aeropuerto": aeropuertoOrigen.nombre_aeropuerto,
                                "direccion_aeropuerto": aeropuertoOrigen.direccion_aeropuerto,
                                "telefono": aeropuertoOrigen.telefono,

                                "fkestados_aeropuerto": {
                                    "id_estado_aeropuerto": aeropuertoOrigen.fkestados_aeropuerto.id_estado_aeropuerto,
                                    "nombre_estado":aeropuertoOrigen.fkestados_aeropuerto.nombre_estado
                                    },
                                "fkciudades": {
                                    "id_ciudad": aeropuertoOrigen.fkciudades.id_ciudad,
                                    "nombre_ciudad": aeropuertoOrigen.fkciudades.nombre_ciudad,
                                    "fkpais": {
                                        "id_pais": aeropuertoOrigen.fkciudades.fkpais.id_pais,
                                        "nombre_pais": aeropuertoOrigen.fkciudades.fkpais.nombre_pais
                                        }
                                    }
                                },
                            "fkaeropuertos_destino": {
                                "id_aeropuerto": aeropuertoDestino.id_aeropuerto,
                                "nombre_aeropuerto": aeropuertoDestino.nombre_aeropuerto,
                                "direccion_aeropuerto": aeropuertoDestino.direccion_aeropuerto,
                                "telefono": aeropuertoDestino.telefono,

                                "fkestados_aeropuerto": {
                                    "id_estado_aeropuerto": aeropuertoDestino.fkestados_aeropuerto.id_estado_aeropuerto,
                                    "nombre_estado":aeropuertoDestino.fkestados_aeropuerto.nombre_estado
                                    },
                                "fkciudades": {
                                    "id_ciudad": aeropuertoDestino.fkciudades.id_ciudad,
                                    "nombre_ciudad": aeropuertoDestino.fkciudades.nombre_ciudad,
                                    "fkpais": {
                                        "id_pais": aeropuertoDestino.fkciudades.fkpais.id_pais,
                                        "nombre_pais": aeropuertoDestino.fkciudades.fkpais.nombre_pais
                                        }
                                    }
                                },
                                //por defecto se registra un vuelo como en espera. 
                            "fkestados_vuelo": {
                                "id_estado_vuelo": 1,
                                "nombre_estado": "En espera"
                            },
                            "fkaviones": {
                                "id_avion": avion.id_avion,
                                "fabricante": avion.fabricante,
                                "modelo": avion.modelo,
                                "anio_fabricacion": avion.anio_fabricacion,
                                "numero_sillas_business": avion.numero_sillas_business,
                                "numero_sillas_primera": avion.numero_sillas_primera,
                                "numero_sillas_economica": avion.numero_sillas_economica,
                                "fkestados_avion": {
                                    "id_estado_avion": avion.fkestados_avion.id_estado_avion,
                                    "nombre_estado": avion.fkestados_avion.nombre_estado
                                    }
                                },
                            "fksalas": {
                                "id_sala": salaAbordaje.id_sala,
                                "nombre_sala": salaAbordaje.nombre_sala,
                                "fkestado_sala": {
                                    "id_estado_sala": salaAbordaje.fkestado_sala.id_estado_sala,
                                    "nombre_estado": salaAbordaje.fkestado_sala.nombre_estado
                                    },
                                "fkaeropuertos": {
                                    "id_aeropuerto": salaAbordaje.fkaeropuertos.id_aeropuerto,
                                    "nombre_aeropuerto": salaAbordaje.fkaeropuertos.nombre_aeropuerto,
                                    "direccion_aeropuerto": salaAbordaje.fkaeropuertos.direccion_aeropuerto,
                                    "telefono": salaAbordaje.fkaeropuertos.telefono,
    
                                    "fkestados_aeropuerto": {
                                        "id_estado_aeropuerto": salaAbordaje.fkaeropuertos.fkestados_aeropuerto.id_estado_aeropuerto,
                                        "nombre_estado":salaAbordaje.fkaeropuertos.fkestados_aeropuerto.nombre_estado
                                        },
                                    "fkciudades": {
                                        "id_ciudad": salaAbordaje.fkaeropuertos.fkciudades.id_ciudad,
                                        "nombre_ciudad": salaAbordaje.fkaeropuertos.fkciudades.nombre_ciudad,
                                        "fkpais": {
                                            "id_pais": salaAbordaje.fkaeropuertos.fkciudades.fkpais.id_pais,
                                            "nombre_pais": salaAbordaje.fkaeropuertos.fkciudades.fkpais.nombre_pais
                                            }
                                        }}
                            },
                            "chequeo": this.horaCheckIn,

                            }
                
              

            var url = 'http://localhost:8080/rest/aeropuertos/agregar';
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

        //arreglar
        var urlSalas = 'http://localhost:8080/rest/salas/'+this.aeropuertoOrigenVuelo.id_aeropuerto ;

        fetch(urlSalas)
        .then(response => response.json())
        .then(salas => {
            this.salas = salas;
        });

        
    }
});