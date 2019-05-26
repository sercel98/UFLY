Vue.component('cabecera',
{
props:['title'],

template: ` 
<div>
    <div class="header d-flex justify-content-between align-items-center flex-wrap-reverse py-2 px-2">
        <img src="/img/logo.png" width="7%" height="7%" class="img-fluid px-1 py-1">
        <div>
            <h1 class="text-center mb-3 mx-5">{{title}}</h1>
            <div>
                <nav class="p-0 navbar navbar-dark navbar-expand-lg" style="background-color: #393E46;">
                    <ul class="navbar-nav list-group list-group-horizontal footer-main-links row text-center">
                        <li class="nav-item col-6 col-md">
                            <a class="py-0 nav-link " href="/usuario/usuarios.html">Usuarios</a>
                        </li>
                        <li class="nav-item col-6 col-md">
                            <a class="py-0 nav-link" href="/tripulante/tripulantes.html">Tripulantes</a>
                        </li>
                        <li class="nav-item col-6 col-md">
                            <a class="py-0 nav-link" href="/aeropuerto/aeropuertos.html">Aeropuertos</a>
                        </li>
                        <li class="nav-item col-6 col-md">
                            <a class="py-0 nav-link" href="/pasajeros/pasajeros.html">Pasajeros</a>
                        </li>
                        <li class="nav-item col-6 col-md">
                        <a class="py-0 nav-link" href="/vuelo/vuelos.html">Vuelos</a>
                        </li>
                        <li class="nav-item col-6 col-md">
                        <a class="py-0 nav-link" href="/avion/aviones.html">Aviones</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <nav class="navbar navbar-dark navbar-expand-lg" style="background-color: #393E46;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" 
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Configuración
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="#">Ver mi perfil</a>
                            <a class="dropdown-item" href="#">Cerrar sesión</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
    
    `




})