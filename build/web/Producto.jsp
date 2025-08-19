<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
             <div class="card col-sm-4">
                <div class="card-body">
                     <form action="Controlador?menu=Producto" method="POST">
                         <div class="form-group"> 
                            <label>Nombres</label>
                             <input type="text" value="${producto.getNom()}" class="form-control" name="txtNombres">
                         </div>
                         <div class="form-group">
                             <label>Precio</label>
                             <input type="text" value="${producto.getPrecio()}" class="form-control" name="txtPrecio">
                         </div>
                         <div class="form-group">
                             <label>Stock</label>
                             <input type="text" value="${producto.getStock()}" class="form-control" name="txtStock">
                         </div>
                          <div class="form-group">
                             <label>Estado</label>
                             <input type="text" value="${producto.getEstado()}" class="form-control" name="txtEstado">
                         </div>
                         <br>
                         <input type="submit" name="accion" value="Agregar" class="btn btn-info" >  
                         <input type="submit" name="accion" value="Actualizar" class="btn btn-success" >  
                            
                     </form>
                </div>
            </div>
        
          <div class="card col-sm-8" style='float: left; margin:0px; padding-left:20px;text-align: left;'>
            <br>
            <table class="table table-hover"  >
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">PRECIO</th>
                        <th class="text-center">STOCK</th>
                        <th class="text-center">ESTADO</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var = "prod" items="${productos}">
                       <tr>
                        <td class="text-center">${prod.getIdProducto()}</td>
                        <td class="text-center">${prod.getNom()}</td>
                        <td class="text-center">${prod.getPrecio()}</td>
                        <td class="text-center">${prod.getStock()}</td>
                        <td class="text-center">${prod.getEstado()}</td>

                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${prod.getIdProducto()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${prod.getIdProducto()}">Delete</a>
                        </td>
                       </tr>
                   </c:forEach> 
                </tbody>
            </table>
          </div>
            
        </div>
         
                
                
     <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
      
        
        
    </body>
</html>
