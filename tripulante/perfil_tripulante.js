var app = new Vue({
    el: '#perfil_tripulante',
    data:
    {
        idTripulante:'',
        cedulaTripulante:'',
        primerNombre: '',
        segundoNombre: '',
        primerApellido: '',
        segundoApellido: '',
        nombreTripulante:'',
        estadoTripulante: '',
        generoTripulante: '',
        direccionTripulante: '',
        fechaNacimientoTripulante: '',
        telefonoTripulante: '',
        tripulanteActual: {},
        
      
        estadosTripulante: []
    },
    methods: {
        procesarFormulario: function () {
           
            var estadoTripulante = this.estadosTripulante.find(estadoTripulante => estadoTripulante.nombre_estado === this.estadoTripulante)

            //revisar json
            this.tripulanteActual.direccion = this.direccionTripulante;
            this.tripulanteActual.telefono = this.telefonoTripulante;

            this.tripulanteActual.fkestados_tripulante.id_estado_tripulante = estadoTripulante.id_estado_tripulante;
            this.tripulanteActual.fkestados_tripulante.nombre_estado = this.estadoTripulante;
            console.log( this.tripulanteActual.fkestados_tripulante.nombre_estado);

            var url = 'http://localhost:8080/rest/tripulantes/' + this.tripulanteActual.id_tripulante;
            var init = {
                method: 'PUT',
                body: JSON.stringify(this.tripulanteActual),
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            var request = new Request(url, init);

            fetch(request)
            .then(response => response.json())
            .catch(error => toastr.error('No se ha podido actualizar el tripulante: ' + error))
           .then(response => toastr.success('Se ha actualizado el tripulante exitosamente: ' + response.primer_nombre))
            
        },


        retornarGenero: function()
        {

            if(generoTripulante=1)
            {
                return "Masculino";
            }
            else
            {
                return "femenino"; 
            }

        },


        validarCampos: function () {
        if (this.direccionTripulante.length > 5 && !this.direccionTripulante.startsWith(" ") &&
                !this.telefonoTripulante.startsWith(" ") && this.telefonoTripulante.toString().length > 5) {
                this.procesarFormulario();

            }
            else {
                toastr.warning("LA INFORMACIÓN DEL TRIPULANTE ES INCOMPLETA!");
            }

        }

    },

    mounted() {
     
        fetch('http://localhost:8080/rest/estadostripulantes')
            .then(response => response.json())
            .then(estadostripulante => {
                this.estadosTripulante = estadostripulante;
            });


        var urlPagina = window.location.href;
        var posicion = urlPagina.indexOf('?');
        idTripulante = urlPagina.substr(posicion + 1, urlPagina.length);

        var url = 'http://localhost:8080/rest/tripulantes/' + idTripulante;

        fetch(url)
            .then(response => response.json())
            .then(tripulante => {

                //REVISAR JSON
                this.idTripulante = tripulante.id_tripulante,
                this.cedulaTripulante = tripulante.cedula_tripulante,
                
                this.primerNombre = tripulante.primer_nombre,
                this.segundoNombre = tripulante.segundo_nombre,
                this.primerApellido = tripulante.primer_apellido,
                this.segundoApellido = tripulante.segundo_apellido,
                this.telefonoTripulante = tripulante.telefono,
                this.generoTripulante = tripulante.genero,
                this.direccionTripulante = tripulante.direccion,
                this.fechaNacimientoTripulante = tripulante.fecha_nacimiento,
                this.estadoTripulante = tripulante.fkestados_tripulante.nombre_estado,

                this.nombreTripulante = this.primerNombre + " " + this.segundoNombre + " " + this.primerApellido + " " + this.segundoApellido,
                this.tripulanteActual = tripulante;
            });
    }   
})