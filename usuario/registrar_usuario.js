var app = new Vue({
    el: '#formulario-registro-usuario',
    data:
    {
        primerNombre: '',
        segundoNombre: '',
        primerApellido: '',
        segundoApellido: '',
        identificacion: '',
        genero: '',
        correoElectronico: '',
        telefono: '',
        direccion: '',
        fechaNacimiento: '',
        contrasena: '',


    },
    methods: {
        procesarFormulario: function () {

            var obj = {
                "id_usuario": "",
                "cedula": this.identificacion,
                "contrasenia": this.contrasena,
                "primer_nombre": this.primerNombre,
                "segundo_nombre": this.segundoNombre,
                "primer_apellido": this.primerApellido,
                "segundo_apellido": this.segundoApellido,
                "genero": this.genero,
                "correo_electronico": this.correoElectronico,
                "telefono": this.telefono,
                "fktipo_usuario": '1'
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
                .then(response => alert('Se ha registrado el usuario exitosamente: ' + response))



        },






    },



})
