const vuelos = new Vue({
    el: "#vuelos",
    data: {

        vuelos: [],
        buscado: ''

    },
    methods: {

        actualizarVuelo: function (id) {

            location.href = 'perfil_vuelo.html?' + id;
        },

    },
    computed: {
        searchVuelo: function () {

            var origen = document.getElementById('customRadioInline1').checked;
            var destino = document.getElementById('customRadioInline2').checked;
            if (origen) {
                return this.vuelos.filter((vuelo) => vuelo.fkaeropuertos_origen.nombre_aeropuerto.toLowerCase().includes(this.buscado.toLowerCase()));
            } else if (destino) {
                return this.vuelos.filter((vuelo) => vuelo.fkaeropuertos_destino.nombre_aeropuerto.toLowerCase().includes(this.buscado.toLowerCase()));
            } else {
                return this.vuelos.filter((vuelo) => vuelo.fkestados_vuelo.nombre_estado.toLowerCase().includes(this.buscado.toLowerCase()));
            }
        }
    },

mounted() {


    fetch('http://localhost:8080/rest/vuelos', { mode: 'cors' })
    .then(response => response.json())
    .then(vuelos => {
        this.vuelos = vuelos;
    });
},
});