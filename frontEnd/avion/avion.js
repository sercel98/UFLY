const aviones = new Vue({
    el: '#aviones',
    data: {
        aviones: [],
        buscado: ''
    },

    methods: {
        actualizarAvion(id) {
            location.href = 'perfil_avion.html?' + id;
        }
    },

    computed: {
        searchPlane: function () {
            var fabricante = document.getElementById('customRadioInline1').checked;
            var modelo = document.getElementById('customRadioInline2').checked;
            var año_fabricacion = document.getElementById('customRadioInline3').checked;

            if (fabricante) {
                return this.aviones.filter((avion) => avion.fabricante.toLowerCase().includes(this.buscado.toLowerCase()));
            }
            else if (modelo) {
                return this.aviones.filter((avion) => avion.modelo.toLowerCase().includes(this.buscado.toLowerCase()));
            }
            else if (año_fabricacion) {
                return this.aviones.filter((avion) => avion.anio_fabricacion.toString().toLowerCase().includes(this.buscado.toLowerCase()));
            }
            else {
                return this.aviones.filter((avion) => avion.fkestados_avion.nombre_estado.toLowerCase().startsWith(this.buscado.toLowerCase()));
            }
        }
    },

    mounted() {
        fetch('http://localhost:8080/rest/aviones')
            .then(response => response.json())
            .then(aviones => {
                this.aviones = aviones;
            });
    }
});