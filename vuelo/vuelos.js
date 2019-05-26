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
