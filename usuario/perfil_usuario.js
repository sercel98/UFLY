var app = new Vue({
    el: "#perfil-usuario",
    data: {

        usuario: [{

            idUsuario: "",
            identificacion: "",
            primerNombre: "",
            segundoNombre: "",
            primerApellido: "",
            segundoApellido: "",
            nombre: this.primerNombre + " " + this.segundoNombre + " " + this.primerApellido + " " + this.segundoApellido,
            correo: "",
            telefono: "",
            direccion: "",
            fkTipoUsuario: "",
            fechaNacimiento: "",
            genero: "",

            usuarioActual: {},

        }]

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
                this.direccion.length > 5 && !this.direccionstartsWith(" ")) {
                this.procesarFormulario();

            }
            else {
                alert("La información del usuario está incompleta!");
            }



        },

        procesarFormulario: function () {


            //REVISAR
            var obj = {
                "id_usuario": this.idUsuario,
                "cedula": this.identificacion,
                "contrasenia": this.contrasena,
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

            //
            var url = 'http://localhost:8080/rest/usuarios/modificar/' + this.usuarioActual.id_usuario;
            var init = {
                method: 'PUT', body: JSON.stringify(obj), headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);

            fetch(request)
                .then(response => response.json())
                .catch(error => alert('No se ha podido  el usuario: ' + error))
                .then(response => alert('Se ha actualizado el usuario exitosamente: ' + response))



        }

    },

    mounted() {

        var urlPagina = window.location.href;
        idUsuario = urlPagina.charAt(urlPagina.length - 1);

        //revisar
        var url = 'http://localhost:8080/rest/usuarios/' + idUsuario;

        fetch(url)
            .then(response => response.json())
            .then(usuarioActual => {

                this.idUsuario = usuarioActual.id_usuario,
                    this.identificacion = usuarioActual.cedula,
                    this.contrasenia = usuarioActual.direccion_aeropuerto,
                    this.primerNombre = usuarioActual.primer_nombre,
                    this.segundoNombre = usuarioActual.segundo_nombre,
                    this.primerApellido = usuarioActual.primer_apellido,
                    this.segundoApellido = usuarioActual.segundo_apellido,
                    this.correo = usuarioActual.correo_electronico,
                    this.telefono = usuarioActual.telefono,
                    this.genero = usuarioActual.genero,
                    this.fechaNacimiento = usuarioActual.fecha_nacimiento,
                    this.direccion = usuarioActual.direccion,
                    this.fkTipoUsuario = usuarioActual.fktipo_usuario,
                    this.usuarioActual = usuarioActual;
            });



    },
});
