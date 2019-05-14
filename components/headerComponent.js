Vue.component('cabecera',
{
props:['title'],

template: ` 
<div>
    <div class="header d-flex justify-content-between align-items-center flex-wrap-reverse py-2 px-2">
     <img src="/img/logo.png" width="8%" height="8%" class="img-fluid px-1 py-1">
    
    <h1 class="text-center m-0  mx-5">{{title}}</h1>
  
    <nav class="navbar navbar-dark navbar-expand-lg" style="background-color: #393E46;">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" 
        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/usuario/usuarios.html">Usuarios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/tripulante/tripulantes.html">Tripulantes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/aeropuerto/aeropuertos.html">Aeropuertos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/pasajeros/pasajeros.html">Pasajeros</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Configuraciones
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