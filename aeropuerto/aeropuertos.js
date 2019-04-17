const aeropuertos = new Vue({

    el: '#aeropuertos',
    data: {
        titulo: 'Aeropuertos',
        aeropuertos: []
    },

    methods: {
        buscar() {
            const busqueda = document.getElementById('buscarAeropuerto');
            const contenido = document.querySelector('#contenido')
            const texto = busqueda.value.toLowerCase();
            contenido.innerHTML = '';
            for(let aeropuerto of this.aeropuertos)
            {
                let nombre = aeropuerto.nombre_aeropuerto;
                if(nombre.indexOf(texto) !== -1)
                {
                    contenido.innerHTML += `    
                    <tr>
                        <td>${ aeropuerto.nombre_aeropuerto }</td>
                        <td>${ aeropuerto.ciudad_pais }</td>
                        <td>${ aeropuerto.estado }</td>
                        <td>${ aeropuerto.telefono }</td>
                    </tr>

                    `
                }
            }
        }
    },

    mounted(){
        fetch('tabla.json')
        .then(response => response.json())
        .then(aeropuertos =>{
            this.aeropuertos = aeropuertos;
        });
    }
});