var app = new Vue({
    el: '#formulario-registro-usuario',
    data:
    {
        identificacion: '',
        contrasenia: '',
        primerNombre: '',
        segundoNombre: '',
        primerApellido: '',
        segundoApellido: '',
        telefono: '',
        genero: '',
        direccion: '',
        correoElectronico: '',
        fechaNacimiento: '',
    },
    methods: {

        validarCampos: function () {

            if (this.primerNombre.length > 2 && !this.primerNombre.startsWith(" ") &&
                this.primerApellido.length > 3 && !this.primerNombre.startsWith(" ") &&
                this.segundoApellido.length > 3 && !this.segundoApellido.startsWith(" ") &&
                this.direccion.length > 5 && !this.direccion.startsWith(" ") &&
                this.correoElectronico.length > 5 && !this.direccion.startsWith(" ") &&
                !this.telefono.startsWith(" ") && this.telefono.toString().length > 5 &&
                this.identificacion.toString().length > 7 && !this.identificacion.startsWith(" ")) {

                this.procesarFormulario();
            }
            else {
                toastr.warning("Los datos ingresados no son válidos!");
            }
        },

        procesarFormulario: function () {

            var obj = {
                "id_usuario": "",
                "cedula": this.identificacion,
                "contrasenia": this.contrasenia,
                "primer_nombre": this.primerNombre,
                "segundo_nombre": this.segundoNombre,
                "primer_apellido": this.primerApellido,
                "segundo_apellido": this.segundoApellido,
                "correo_electronico": this.correoElectronico,
                "telefono": this.telefono,
                "genero": this.genero,
                "direccion": this.direccion,
                "fecha_nacimiento": this.fechaNacimiento,

                //AL SER ESTA LA VISTA DE CLIENTE, ESTO SERÁ CONSTANTE
                "fktipo_usuario": {
                    "id_tipo_usuario": 2,
                    "tipo_usuario": "Cliente"
                }
            }

            console.log(obj);
            var url = 'http://localhost:8080/rest/usuarios/agregar';
            var init = {
                method: 'POST', body: JSON.stringify(obj), headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);

            fetch(request)
            .then(response => response.json())
            .catch(error => toastr.error('Error: ' + error))
            .then(response => {
                if(response.status == 500)
                {
                    toastr.warning('No se ha podido registrar el usuario: ' + error)
                }
                else
                {
                    toastr.options.timeOut=600; 
                    toastr.options.onHidden = function() { location.href='usuarios.html';}
                    toastr.success('Se ha registrado el usuario exitosamente: ' + response.primer_nombre)
            
                }
            })
        },
    },
})
