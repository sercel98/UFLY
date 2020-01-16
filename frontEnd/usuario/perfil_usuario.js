var app = new Vue({
    el: "#perfil-usuario",
    data: {

        idUsuario: '',
        identificacion: '',
        primerNombre: '',
        segundoNombre: '',
        primerApellido: '',
        segundoApellido: '',
        nombre: '',
        correo: '',
        telefono: '',
        direccion: '',
        fkTipoUsuario: '',
        fechaNacimiento: '',
        genero: '',
        contrasenia: '',

        usuarioActual: {}

    },
    methods: {
        abrirMenu: function () {
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("menuDisplayed");

            });
        },

        validarCampos: function () {
            if (this.telefono.toString().length > 7 && !this.telefono.startsWith(" ") &&
                this.direccion.length > 5 && !this.direccion.startsWith(" ")) 
            {
                this.procesarFormulario();

            }
            else {
                toastr.warning("La información del usuario está incompleta!");
            }
        },

        procesarFormulario: function () {
            var obj = {
                "id_usuario": this.idUsuario,
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
            console.log(this.idUsuario);

            //
            var url = 'http://localhost:8080/rest/usuarios/' + this.idUsuario;
            var init = {
                method: 'PUT', body: JSON.stringify(obj), headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);

            fetch(request)
            .then(response => response.json())
            .catch(error =>  toastr.error('Error: ' + error))
            .then(response => {
                if(response.status == 500)
                {
                    toastr.warning('No se ha podido editar el usuario: ' + response.message);
                }
                else
                {
                    toastr.success('Se ha editado el usuario exitosamente:'+response.primer_nombre)
                }
            })
        },

        verMisTiquetes() {
            location.href = 'usuarios.html';
        }
    },

    mounted() {
        var urlPagina = window.location.href;
        var posicion = urlPagina.indexOf('?');
        idUsuario = urlPagina.substr(posicion+1,urlPagina.length);
        var url = 'http://localhost:8080/rest/usuarios/' + idUsuario;

        fetch(url)
        .then(response => response.json())
        .then(usuario => {
        
            console.log(usuario);
            this.idUsuario = usuario.id_usuario,
            this.identificacion = usuario.cedula,
            this.contrasenia = usuario.contrasenia,

            this.primerNombre = usuario.primer_nombre,
            this.segundoNombre = usuario.segundo_nombre,

            this.primerApellido = usuario.primer_apellido,
            this.segundoApellido = usuario.segundo_apellido,

            this.correo = usuario.correo_electronico,
            this.telefono = usuario.telefono,


            this.genero = usuario.genero,
            this.direccion = usuario.direccion,
            this.fechaNacimiento = usuario.fecha_nacimiento,

            this.nombre = this.primerNombre + " " + this.segundoNombre + " " + this.primerApellido + " " + this.segundoApellido,
            this.usuarioActual = usuario;
        });
    },
});
