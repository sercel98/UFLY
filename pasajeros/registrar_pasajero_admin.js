var app = new Vue({
    el: '#registro_pasajero_admin',
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
        fechaNacimiento: ''
    },
    methods: {

        validarCampos: function () {

            if (this.primerNombre.length > 2 && !this.primerNombre.startsWith(" ") &&
                this.primerApellido.length > 3 && !this.primerApellido.startsWith(" ") &&
                this.segundoApellido.length > 3 && !this.segundoApellido.startsWith(" ") &&
                this.direccion.length > 5 && !this.direccion.startsWith(" ") &&
                this.telefono.toString().length > 5 && !this.telefono.startsWith(" ") &&
                this.identificacion.toString().length > 7 && !this.identificacion.startsWith(" "))
            {
                this.procesarFormulario();
            }
            else
            {
                toastr.warning("Los datos ingresados no son válidos!");
            }
        },

        procesarFormulario: function () {
            
            var pasajero = {
                "id_pasajero": "",
                "cedula": this.identificacion,
                "primer_nombre": this.primerNombre,
                "segundo_nombre": this.segundoNombre,
                "primer_apellido": this.primerApellido,
                "segundo_apellido": this.segundoApellido,
                "telefono": this.telefono,
                "genero": this.genero,
                "direccion": this.direccion,
                "fecha_nacimiento": this.fechaNacimiento
            }

            console.log(pasajero);
            var url = 'http://localhost:8080/rest/pasajeros/agregar';
            var init = {
                method: 'POST', 
                body: JSON.stringify(pasajero),
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);

            fetch(request)
            .then(response => response.json())
            .catch(error =>  toastr.error('Error: ' + error))
            .then(response => {
                console.log(response);
                if(response.status == 500)
                {
                    toastr.warning('No se ha podido registrar el usuario: ' + response.message);
                }
                else
                {
                    toastr.options.onHidden = function() { location.href='pasajeros.html';}
                    toastr.options.timeOut = 1000;
                    toastr.success('Se ha registrado el usuario exitosamente: ' + response.primer_nombre + " " + response.primer_apellido)
                }
            })
            
        }

    }

})
