<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Home</title>
               
    </head>
    <body>
        
     <nav class="navbar navbar-expand-lg navbar-light bg-info" >
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a style="margin-left:3px; border: none" class="btn btn-outline-light"  target="myFrame" href="#">Home</a>
            </li>
            <li class="nav-item">
              <a style="margin-left:3px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame" >Producto</a>
            </li>
            <li class="nav-item">
              <a style="margin-left:3px; border: none" class="btn btn-outline-light"  href="Controlador?menu=Empleado&accion=Listar" target="myFrame" >Empleado</a>
            </li>
            <li class="nav-item">
              <a style="margin-left:3px; border: none" class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame" >Clientes</a>
            </li>
            <li class="nav-item">
              <a style="margin-left:3px; border: none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=Default" target="myFrame" >Nueva Venta</a>
            </li>
          </ul>  
        </div>
          
          <div class="dropdown">
             <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                ${usuario.getNom()}
             </button>
             <div class="dropdown-menu text-center">
                 <a class="dropdown-item" href="#">
                     <img src="img/login.png" alt="100" width="100"/>
                 </a>
               <a class="dropdown-item" href="#"> ${usuario.getUser()}</a>
               <a class="dropdown-item" href="#">usuario@gmail.com</a>
               <div class="dropdown-divider"></div>
               <form action="Validar" method="POST">
                   <button name="accion" value="salir" class="dropdown-item" href="#">Salir</a>                   
               </form>
           </div>
         </nav>
            <div align="center">
              <img class="imagen" src="img/titulo.png" alt="" alt="120" width="140"/>
            </div>
             
               <div class="m-4" style="height:550px;">
                  <iframe name="myFrame"  style="width:100%; height:100%; border:none;"></iframe>      
               </div>  
    
        
   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
  
    </body>
    
  
    
</html>
