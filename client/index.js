const index = new Vue({
    el: '#main',
    data: 
    {
        vuelosDisponibles: []

    },
    methods: {

    },

mounted() {


    fetch('http://localhost:8080/rest/vuelos', { mode: 'cors' })
    .then(response => response.json())
    .then(vuelos => {
        this.vuelos = vuelos;
    });
},
});















})