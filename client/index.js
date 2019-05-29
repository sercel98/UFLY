const index = new Vue({
    el: '#main',
    data: {
        vuelosDisponibles: [],
        origenes: [],
        destinos: [],
        origenSeleccionado: ''
    },

    methods: {
        
    },

    computed: {
        buscarDestinos: function () {
            return this.vuelosDisponibles.filter((vuelo) => vuelo.fkaeropuertos_origen.nombre_aeropuerto.toLowerCase().includes(this.origenSeleccionado.toLowerCase()));
        },
    },

    mounted() {
        fetch('http://localhost:8080/rest/vuelos/listar/1', {mode: 'cors' })
            .then(response => response.json())
            .then(vuelos => {
                this.vuelosDisponibles = vuelos;
            });
    },
});