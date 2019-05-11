Vue.component('cabecera',
{
props:['title'],

template: ` 
<div>
    <div class="header d-flex justify-content-between align-items-center flex-wrap-reverse py-2 px-2">
     <img src="/img/logo.png" width="8%" height="8%" class="img-fluid px-1 py-1">
        <h1 class="text-center m-0">{{title}}</h1>
        <li class="nav-item dropdown d-flex align-items-center px-1 py-1">
        <a class="nav-link dropdown-toggle  text-white" data-toggle="dropdown" href="#" role="button"
            aria-haspopup="true" aria-expanded="false">Configuración</a>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="#one">Ver mi perfil</a>
             <div role="separator" class="dropdown-divider"></div>
                <a class="dropdown-item" href="#two">Cerrar sesión</a>
             </div>
         </li>
        </div>
</div>
    
    `




})