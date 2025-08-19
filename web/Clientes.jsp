<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Clientes</title>
        
    </head>
    <body>
       
        
        <div class="d-flex">
             <div class="card col-sm-4">
                <div class="card-body">
                     <form action="Controlador?menu=Cliente" method="POST">
                          
                          <div class="form-group"> 
                            <label>DNI</label>
                             <input type="text" value="${Cliente.getDni()}" class="form-control" name="txtDNI">
                         </div>
                         <div class="form-group"> 
                            <label>Nombres</label>
                             <input type="text" value="${Cliente.getNom()}" class="form-control" name="txtNombres">
                         </div>
                         <div class="form-group">
                             <label>Direccion</label>
                             <input type="text" value="${Cliente.getDir()}" class="form-control" name="txtDir">
                         </div>
                          <div class="form-group">
                             <label>Estado</label>
                             <input type="text" value="${Cliente.getEstado()}" class="form-control" name="txtEstado">
                         </div>
                         <br>
                         <input type="submit" name="accion" value="Agregar" class="btn btn-info" >  
                         <input type="submit" name="accion" value="Actualizar" class="btn btn-success" >  
                            
                     </form>
                </div>
            </div>
        
          <div class="card col-sm-8" style='float: left; margin:0px; padding-left:20px;text-align: left;'>
            <br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">DNI</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">DIRECCION</th>
                        <th class="text-center">ESTADO</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var = "cli" items="${clientes}">
                       <tr>
                        <td class="text-center">${cli.getId()}</td>
                        <td class="text-center">${cli.getDni()}</td>
                        <td class="text-center">${cli.getNom()}</td>
                        <td class="text-center">${cli.getDir()}</td>
                        <td class="text-center">${cli.getEstado()}</td>

                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${cli.getId()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${cli.getId()}">Delete</a>
                        </td>
                       </tr>
                   </c:forEach> 
                </tbody>
            </table>
          </div>
            
        </div>
         
        </section>       
                
     <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
      
        
        
    </body>
</html>
