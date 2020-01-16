const aeropuertos = new Vue({

    el: '#tiquetes_usuario',
    data: {
        titulo: 'Tiquetes',
        tiquetes: [],
        usuario: {},
        nombreUsuario: {},
        buscado: ''
    },

    methods: {
        actualizarTiquete(id) {
            location.href = 'perfil_aeropuerto.html?' + id;
        }
    },

    computed: {
        searchTiquete: function () {
            var cedula = document.getElementById('customRadioInline1').checked;
            var nombre = document.getElementById('customRadioInline2').checked;
            var tipo = document.getElementById('customRadioInline2').checked;
            
            if (cedula) 
            {
                return this.usuarios.filter((usuario) => usuario.cedula.toString().includes(this.buscado.toLowerCase()));
            }
            else if(nombre)
            {
               return this.usuarios.filter((usuario) => (usuario.primer_nombre.toLowerCase() + usuario.primer_apellido.toLowerCase() + usuario.segundo_apellido.toLowerCase()).includes(this.buscado.replace(' ', '').replace(' ', '').replace(' ', '').toLowerCase()));
            }
            else if(tipo)
            {
                return this.usuarios.filter((usuario) => usuario.correo_electronico.toLowerCase().includes(this.buscado.toLowerCase()));
            }
            else
            {

            }
        }
    },

    mounted() {
        var urlPagina = window.location.href;
        var posicion = urlPagina.indexOf('?');
        idUsuario = urlPagina.substr(posicion + 1, urlPagina.length);
        var urlTiquetes = 'http://localhost:8080/rest/tiquetes/listar/' + idUsuario;
        fetch(urlTiquetes)
        .then(response => response.json())
        .then(tiquetes => {
            this.tiquetes = tiquetes;

            if(tiquetes.length > 0)
            {
                this.usuario = this.tiquetes[0].fkusuarios;
                if(this.usuario.segundo_nombre != "")
                {
                    this.nombreUsuario = this.usuario.primer_nombre + " " + this.usuario.segundo_nombre + " " + this.usuario.primer_apellido + " "  + this.usuario.segundo_apellido;
                }
                else
                {
                    this.nombreUsuario = this.usuario.primer_nombre + " "  + this.usuario.primer_apellido + " " + this.usuario.segundo_apellido;
                }
            }
            else
            {
                this.usuario = null;
                this.nombreUsuario = null;
            }
        });
    }
});