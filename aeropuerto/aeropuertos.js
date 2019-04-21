const aeropuertos = new Vue({

    el: '#aeropuertos',
    data: {
        titulo: 'Aeropuertos',
        aeropuertos: [],
        buscarAeropuerto: ''
    },

    methods: {
        verificarBusqueda(){
            
        }
    },

    computed: {
        searchAirport: function () {
            return this.aeropuertos.filter((aeropuerto) => aeropuerto.nombre_aeropuerto.toLowerCase().includes(this.buscarAeropuerto.toLowerCase()));
        }
    },

    mounted(){
        //fetch('http://localhost:8080/aeropuertos/listar', {mode: cors})
        fetch('tabla.json')
        .then(response => response.json())
        .then(aeropuertos =>{
            this.aeropuertos = aeropuertos;
        });
    }
});