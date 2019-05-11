var app = new Vue({
    el: '#registrar_tripulante',
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
        tipoUsuario: '',
        tiposUsuarios: []



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
                alert("Los datos ingresados no son válidos!");
            }
        },

        procesarFormulario: function () {

            var tiposUsuarios = this.tiposUsuarios.find(tiposUsuarios => tiposUsuarios.tipo_usuario === this.tipoUsuario);
            console.log(this.tiposUsuarios)


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

                "fktipo_usuario": {
                    "id_tipo_usuario": tiposUsuarios.id_tipo_usuario,
                    "tipo_usuario": tiposUsuarios.tipo_usuario
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
                .catch(error => alert('No se ha podido registrar el usuario: ' + error))
                .then(response => alert('Se ha registrado el usuario exitosamente: ' + response.primer_nombre))

        }

    },
    mounted() {
        fetch('http://localhost:8080/rest/tiposusuario')
            .then(response => response.json())
            .then(tiposUsuarios => {
                this.tiposUsuarios = tiposUsuarios;
                console.log(tiposUsuarios)
            });
    },

})
