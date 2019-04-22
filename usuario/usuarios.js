const usuarios = new Vue({
    el: "#usuarios",
    data: {

        usuarios: [],
        documentoBuscado: ''

    },
    methods: {

    },
    computed: {
        searchUser: function () {
            return this.usuarios.filter((usuario) => usuario.primer_nombre.toLowerCase().includes(this.documentoBuscado.toLowerCase()));
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
