const usuarios = new Vue({
    el: "#usuarios",
    data: {

        usuarios: [],
        buscado: ''

    },
    methods: {

        actualizarUsuario: function (id) {

            location.href = 'perfil_usuario.html?' + id;
        },
    },
    computed: {
        searchUser: function () {
            var cedula = document.getElementById('customRadioInline1').checked;
            var nombre = document.getElementById('customRadioInline2').checked;
            
            if (cedula) 
            {
                return this.usuarios.filter((usuario) => usuario.cedula.toString().includes(this.buscado.toLowerCase()));
            }
            else if(nombre)
            {
                return this.usuarios.filter((usuario) => (usuario.primer_nombre.toLowerCase() + usuario.segundo_nombre.toLowerCase() + usuario.primer_apellido.toLowerCase() + usuario.segundo_apellido.toLowerCase()).includes(this.buscado.replace(' ', '').replace(' ', '').replace(' ', '').toLowerCase()));
            }
            else
            {
                return this.usuarios.filter((usuario) => usuario.correo_electronico.toLowerCase().includes(this.buscado.toLowerCase()));

            }
        }
    },

    mounted() {
        

        fetch('http://localhost:8080/rest/usuarios', { mode: 'cors' })
            .then(response => response.json())
            .then(usuarios => {
                this.usuarios = usuarios;
            });
    },
});
