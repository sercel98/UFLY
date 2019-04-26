const aeropuertos = new Vue({

    el: '#aeropuertos',
    data: {
        titulo: 'Aeropuertos',
        aeropuertos: [],
        buscado: ''
    },

    methods: {
        actualizarAeropuerto(id) {
            location.href = 'perfil_aeropuerto.html?' + id;
        }
    },

    computed: {
        searchAirport: function () {
            var nombre = document.getElementById('customRadioInline1').checked;
            var ciudad = document.getElementById('customRadioInline2').checked;
            var pais = document.getElementById('customRadioInline3').checked;

            if (nombre) {
                return this.aeropuertos.filter((aeropuerto) => aeropuerto.nombre_aeropuerto.toLowerCase().includes(this.buscado.toLowerCase()));
            }
            else if (ciudad) {
                return this.aeropuertos.filter((aeropuerto) => aeropuerto.fkciudades.nombre_ciudad.toLowerCase().includes(this.buscado.toLowerCase()));
            }
            else if (pais) {
                return this.aeropuertos.filter((aeropuerto) => aeropuerto.fkciudades.fkpais.nombre_pais.toLowerCase().includes(this.buscado.toLowerCase()));
            }
            else {
                return this.aeropuertos.filter((aeropuerto) => aeropuerto.fkestados_aeropuerto.nombre_estado.toLowerCase().startsWith(this.buscado.toLowerCase()));
            }
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