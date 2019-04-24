const aeropuertos = new Vue({

    el: '#aeropuertos',
    data: {
        titulo: 'Aeropuertos',
        aeropuertos: [],
        buscarAeropuerto: ''
    },

    methods: {
        actualizarAeropuerto(id) {
            location.href = 'perfil_aeropuerto.html?' + id;
        }
    },

    computed: {
        searchAirport: function () {
            return this.aeropuertos.filter((aeropuerto) => aeropuerto.nombre_aeropuerto.toLowerCase().includes(this.buscarAeropuerto.toLowerCase()));
        }
    },

    mounted() {
        fetch('http://localhost:8080/rest/aeropuertos')
            .then(response => response.json())
            .then(aeropuertos => {
                this.aeropuertos = aeropuertos;
            });
    }
});