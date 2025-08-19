<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Ventas</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display:none;
                }
            }
            
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4 parte01"> 
                <div class="card">
                   <form action="Controlador?menu=NuevaVenta" method="POST">
                    <div class="card-body">
                         <div class="form-group"> 
                            <label>Datos del Cliente</label>
                         </div>
                          <div class="form-group d-flex"> 
                              <div class="col-sm-6 d-flex">
                                  <input type="text"   class="form-control" value="${c.getDni()}" name="codigoCliente" placeholder="codigo">
                                  <button type="submit" class="btn-outline-info" name="accion" placeholder="codigo" value="BuscarCliente">Buscar</button>                                                             
                              </div> 
                              <div class="col-sm-6">
                                  <input type="text"   class="form-control" value="${c.getNom()}" name="nombresCliente"  placeholder="Datos Cliente">                                  
                              </div>  
                         </div>
                         <br>
                          <div class="form-group"> 
                              <label>Datos Producto</label>
                          </div>
                          <div class="form-group d-flex"> 
                               <div class="col-sm-6 d-flex">
                                  <input type="text"   class="form-control" value="${producto.getIdProducto()}" name="codigoProducto" placeholder="codigo">
                                  <button type="submit" class="btn-outline-info" name="accion" placeholder="codigo" value="BuscarProd">Buscar</button>
                              </div> 
                              <div class="col-sm-6">
                                  <input type="text"   class="form-control" value="${producto.getNom()}" name="nombresProducto" placeholder="Datos Producto">                                  
                              </div> 
                         </div>
                         <br>
                         <div class="form-group d-flex"> 
                              <div class="col-sm-4 d-flex">
                                  <input type="text"   class="form-control" value="${producto.getPrecio()}" name="precio" placeholder="$/. 0.00">
                              </div> 
                              <div class="col-sm-3">
                                  <input type="number"  value="1" class="form-control" name="cant">                                  
                              </div> 
                              <div class="col-sm-3">
                                  <input type="text"   class="form-control" value="${producto.getStock()}" name="stock" placeholder="Stock">                                  
                              </div> 
                         </div>
                         <br>
                         <div class="form-group">
                             <button type="submit" class="btn-outline-info" name="accion" value="Agregar" >Agregar Producto</button>                                                                
                         </div>          
                    
                   </div>
                   </form> 
                </div>
            </div>

             <div class="col-sm-7"> 
                 <div class="card">
                   <div class="card-body">
                       <div class="form-group col-sm-3 ml-auto">
                            <label>Nro. Serie</label>
                            <input type="text"   class="form-control" value="${numeroSerie}" name="NroSerie">
                       </div>
                       <br>
                       <table class="table table-hover">
                            <thead>
                             <tr>
                                <th>Nro</th>
                                <th>Codigo</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>Subtotal</th>
                                <th class="accion">Acciones</th>
                             </tr>
                            </thead>
                            
                            <tbody>
                            <c:forEach var = "list" items="${listaVenta}">
                             <tr>
                                <td>${list.getItem()}</td>
                                <td>${list.getIdProducto()}</td>
                                <td>${list.getDescripcionProd()}</td>
                                <td>${list.getPrecio()}</td>
                                <td>${list.getCantidad()}</td>
                                <td>${list.getSubtotal()}</td>
                                  <td class="d-flex">
                                    <a class="btn btn-warning" style="margin-left:10px;"href="Controlador?menu=Producto&accion=Editar&id=${prod.getIdProducto()}">Editar</a>
                                    <a class="btn btn-danger"  style="margin-left:10px;" href="Controlador?menu=Producto&accion=Delete&id=${prod.getIdProducto()}">Delete</a>
                               </td>
                                 
                             </tr>
                             </c:forEach>  
                            </tbody>
                       </table>
                   </div>
                     
                     <div class="card-footer d-flex ml-auto">
                       <div class="col-sm-10">
                          <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onClick="print()"class="btn btn-success">Generar Venta</a>
                          <input type="submit"  name="accion" value="Cancelar"  class="btn btn-danger">                                 
                       </div>  
                       <div class="col-sm-2 ml-auto">
                         <input type="text"   class="form-control text-center font-weight-bold" value="$/. ${totalPagar}" name="txtTotalPagar">                                  
                       </div>
                     </div>   
                 </div>    
             </div> 
        </div>  
        
        
        
        
     <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
        
    </body>
</html>
