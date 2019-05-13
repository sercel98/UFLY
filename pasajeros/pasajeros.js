const pasajeros = new Vue({

    el: '#pasajeros',
    data: {
        titulo: 'Pasajeros',
        pasajeros: [],
        buscado: ''
    },

    methods: {
        actualizarAeropuerto(id) {
            location.href = 'perfil_pasajero.html?' + id;
        }
    },

    computed: {
        buscarPasajero: function () {
            var cedula = document.getElementById('customRadioInline1').checked;
            var nombre = document.getElementById('customRadioInline2').checked;
            
            if (cedula) 
            {
                return this.pasajeros.filter((pasajero) => pasajero.cedula.toString().includes(this.buscado.toLowerCase()));
            }
            else if(nombre)
            {
               return this.pasajeros.filter((pasajero) => (pasajero.primer_nombre.toLowerCase() + pasajero.primer_apellido.toLowerCase() + pasajero.segundo_apellido.toLowerCase()).includes(this.buscado.replace(' ', '').replace(' ', '').replace(' ', '').toLowerCase()));
            }
            else
            {
                return this.pasajeros.filter((pasajero) => pasajero.telefono.toLowerCase().includes(this.buscado.toLowerCase()));
            }
        }
    },

    mounted() {
        fetch('http://localhost:8080/rest/pasajeros')
            .then(response => response.json())
            .then(pasajeros => {
                this.pasajeros = pasajeros;
            });
    }
});