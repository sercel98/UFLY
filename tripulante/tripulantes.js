const tripulantes = new Vue({
    el: "#tripulantes",
    data: {

        tripulantes: [],
        buscado: ''

    },
    methods: {

        actualizarTripulante: function (id) {

            location.href = 'perfil_tripulante.html?' + id;
        },

    },
    computed: {
        searchTripulantes: function () {
            var cedula = document.getElementById('customRadioInline1').checked; 
            var nombre = document.getElementById('customRadioInline2').checked;
            
            if (cedula) 
            {
                return this.tripulantes.filter((tripulante) => tripulante.cedula_tripulante.toString().includes(this.buscado.toLowerCase()));
            }
            else if(nombre)
            {   
                return this.tripulantes.filter((tripulante) => (tripulante.primer_nombre.toLowerCase() + tripulante.primer_apellido.toLowerCase() + tripulante.segundo_apellido.toLowerCase()).includes(this.buscado.replace(' ', '').replace(' ', '').toLowerCase()));
            }
            else
            {
                return this.tripulantes.filter((tripulante) => tripulante.fkestados_tripulante.nombre_estado.toLowerCase().includes(this.buscado.toLowerCase()));

            }
        }
    },


    mounted() {
        
        fetch('http://localhost:8080/rest/tripulantes', { mode: 'cors' })
            .then(response => response.json())
            .then(tripulantes => {
                this.tripulantes = tripulantes;
            });
    },
});
