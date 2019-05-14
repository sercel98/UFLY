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

        nuevoCargo: '',

        tripulanteActual: {},
        cargoTripulante:{},
        
        cargosTripulante: [],
        cargosActuales:[],
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
            console.log( this.tripulanteActual);

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

        registrarCargoTripulante: function() {

            var cargoTripulante = this.cargosTripulante.find(cargoTripulante => cargoTripulante.cargo_tripulante === this.nuevoCargo);

            var cargoActual = {
                "id_cargos_actuales": "",
                "fkcargo_tripulante": cargoTripulante,
                "fktripulantes": this.tripulanteActual
            }

            console.log(cargoActual);

            var url = 'http://localhost:8080/rest/cargosactuales/agregar';
            var init = {
                method: 'POST', 
                body: JSON.stringify(cargoActual), 
                headers:{
                    'Content-Type': 'application/json'
                }};
            var request = new Request(url, init);
            fetch(request)
            .then(response => response.json())
            .catch(error => toastr.error('Error: ' + error))
            .then(response => {
                console.log(response);
                if(response.status == 500)
                {
                    toastr.info('No se ha podido registrar el cargo: ' + response.message);
                }
                else
                {
                    toastr.success('Se ha registrado el cargo exitosamente: ' + response.fkcargo_tripulante.cargo_tripulante);
                    this.cargosActuales.push(cargoTripulante);
                }
            })
        },


        validarCampos: function () {
        if (this.direccionTripulante.length > 5 && !this.direccionTripulante.startsWith(" ") &&
                !this.telefonoTripulante.startsWith(" ") && this.telefonoTripulante.toString().length > 5) {
                this.procesarFormulario();

            }
            else {
                toastr.warning("LA INFORMACIÓN DEL TRIPULANTE ES INCOMPLETA!");
            }

        },
        
    

    },

    mounted() {

        fetch('http://localhost:8080/rest/estadostripulantes')
        .then(response => response.json())
        .then(estadostripulante => {
            this.estadosTripulante = estadostripulante;
        });

        fetch('http://localhost:8080/rest/cargostripulantes')
        .then(response => response.json())
        .then(cargosTripulante => {
            this.cargosTripulante = cargosTripulante;
            console.log(this.cargosTripulante);
        });

        var urlPagina = window.location.href;
        var posicion = urlPagina.indexOf('?');
        idTripulante = urlPagina.substr(posicion + 1, urlPagina.length);

        var urlCargosActuales = 'http://localhost:8080/rest/cargosactuales/' + idTripulante;
        fetch(urlCargosActuales)
        .then(response => response.json())
        .then(cargosactuales => {
            this.cargosActuales = cargosactuales;
        });

        var urlTripulante = 'http://localhost:8080/rest/tripulantes/' + idTripulante;

        fetch(urlTripulante)
            .then(response => response.json())
            .then(tripulante => {
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