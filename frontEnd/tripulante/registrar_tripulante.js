var app = new Vue({
    el: '#registrar_tripulante',
    data:
    {
        identificacion: '',
        primerNombre: '',
        segundoNombre: '',
        primerApellido: '',
        segundoApellido: '',
        telefono: '',
        genero: '',
        direccion: '',
        fechaNacimiento: '',
        estadoTripulante: '',
        estadosTripulantes: []



    },
    methods: {

        validarCampos: function () {

            if (this.primerNombre.length > 2 && !this.primerNombre.startsWith(" ") &&
                this.primerApellido.length > 3 && !this.primerNombre.startsWith(" ") &&
                this.segundoApellido.length > 3 && !this.segundoApellido.startsWith(" ") &&
                this.direccion.length > 5 && !this.direccion.startsWith(" ") &&
                 !this.direccion.startsWith(" ") &&
                !this.telefono.startsWith(" ") && this.telefono.toString().length > 5 &&
                this.identificacion.toString().length > 7 && !this.identificacion.startsWith(" ")) {
                this.procesarFormulario();

            }
            else {
                toastr.warning("Los datos ingresados no son válidos!");
            }
        },

        procesarFormulario: function () {


            var estadosTripulantes = this.estadosTripulantes.find(estadosTripulantes => estadosTripulantes.nombre_estado === this.estadoTripulante);
            console.log(this.estadosTripulantes)


            var obj = {
                "id_tripulante": "",
                "cedula_tripulante": this.identificacion,
                "primer_nombre": this.primerNombre,
                "segundo_nombre": this.segundoNombre,
                "primer_apellido": this.primerApellido,
                "segundo_apellido": this.segundoApellido,
                "fkestados_tripulante": {
                    "id_estado_tripulante": estadosTripulantes.id_estado_tripulante,
                    "nombre_estado": estadosTripulantes.nombre_estado
                    },
                "direccion": this.direccion,
                "fecha_nacimiento": this.fechaNacimiento,
                "genero": this.genero,
                "telefono": this.telefono,

            }

            console.log(obj);
            var url = 'http://localhost:8080/rest/tripulantes/agregar';
            var init = {
                method: 'POST', body: JSON.stringify(obj), headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);

            toastr.options.onHidden = function() { location.href='tripulantes.html';}
            toastr.options.timeOut = 600;
            
            fetch(request)
                .then(response => response.json())
                .catch(error =>  toastr.error('No se ha podido registrar el tripulante: ' + error))
                .then(response =>  toastr.success('Se ha registrado el tripulante exitosamente: ' + response.primer_nombre))
            
      
        }

    },
    mounted() {
        fetch('http://localhost:8080/rest/estadostripulantes')
            .then(response => response.json())
            .then(estadosTripulantes => {
                this.estadosTripulantes = estadosTripulantes;
                console.log(estadosTripulantes)
            });
    },

})
