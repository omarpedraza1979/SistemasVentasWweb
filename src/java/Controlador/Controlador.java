package Controlador;

import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.ClienteDAO;
import Modelo.Venta;
import Modelo.VentasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    
    Empleado em   =new Empleado();
    Producto prod =new Producto();
    Cliente  cli  =new Cliente();
    EmpleadoDAO edao  =new EmpleadoDAO();
    ProductoDAO pdao  =new ProductoDAO();
    ClienteDAO clidao =new ClienteDAO();
    Venta   v =new Venta();
    List<Venta> listaVenta= new ArrayList<>();
    int item;
    int codProd;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    String numeroSerie;
    VentasDAO vdao= new VentasDAO();
    
    int ide;
    int idp;
    int idCli;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
          String action=request.getParameter("accion");
          
          System.err.println("DENTRO DEL CONTROLADOR PROCESSREQUEST");

          switch(action){
              case "Principal":
                  //System.err.println("CASE PRINCIPAL");
                  request.getRequestDispatcher("Principal.jsp").forward(request, response);  
                  break;
              case "Producto": 
                  //System.err.println("CASE PRODUCTO");
                  request.getRequestDispatcher("Producto.jsp").forward(request, response);  
                  break;    
              case "Clientes": 
                  //System.err.println("CASE CLIENTES");
                  request.getRequestDispatcher("Clientes.jsp").forward(request, response);  
                  break;    
              case "RegistrarVenta": 
                  //System.err.println("CASE REGISTRAR VENTA");
                  request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);  
                  break;    
              case "Empleado": 
                  //System.err.println("CASE EMPLEADO");
                  request.getRequestDispatcher("Empleado.jsp").forward(request, response);  
                  break;    
              default:
                  //System.err.println("CASE DEFAULT");
                  throw new AssertionError();
          }
           
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
           System.err.println("METODO GET");
           String action=request.getParameter("accion");
           String menu=request.getParameter("menu");
           
           System.err.println("action = "+action);
           System.err.println("menu = "+menu);
          
            if(menu.equals("Empleado")){
                switch(action){
                  case "Listar":                      
                      List lista=edao.listar();
                      request.setAttribute("empleados",lista);
                      break;
                  case "Agregar": 
                      String dni=request.getParameter("txtDni");
                      String nom=request.getParameter("txtNombres"); 
                      String tel=request.getParameter("txtTelefono");
                      String est=request.getParameter("txtEstado");
                      String user=request.getParameter("txtUsuario");
                      em.setDni(dni);
                      em.setNom(nom);
                      em.setTel(tel);
                      em.setEstado(est);
                      em.setUser(user);
                      edao.agregar(em);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                      break;    
                   case "Editar": 
                      ide=Integer.parseInt(request.getParameter("id"));
                      Empleado e=edao.ListarId(ide);
                      request.setAttribute("empleado",e);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);  
                      break;    
                   case "Actualizar": 
                      String dni1=request.getParameter("txtDni");
                      String nom1=request.getParameter("txtNombres"); 
                      String tel1=request.getParameter("txtTelefono");
                      String est1=request.getParameter("txtEstado");
                      String user1=request.getParameter("txtUsuario");
                      em.setDni(dni1);
                      em.setNom(nom1);
                      em.setTel(tel1);
                      em.setEstado(est1);
                      em.setUser(user1);
                      em.setId(ide);
                      edao.actualizar(em);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);  
                      break;        
                      
                  case "Delete": 
                      ide=Integer.parseInt(request.getParameter("id"));
                      edao.delete(ide);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response); 
                      break;       
                  default:
                      throw new AssertionError();
              }
              
               request.getRequestDispatcher("Empleado.jsp").forward(request, response); 
            }
          
            if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);  
            }

            if(menu.equals("Cliente")){
                            switch(action){
                  case "Listar":                      
                      List lista=clidao.listar();
                      request.setAttribute("clientes",lista);
                      break;
                  case "Agregar": 
                      
                      String dni=request.getParameter("txtDNI"); 
                      String nom=request.getParameter("txtNombres");
                      String dir=request.getParameter("txtDir");
                      String estado=request.getParameter("txtEstado");
                      cli.setDni(dni);
                      cli.setNom(nom);
                      cli.setDir(dir);
                      cli.setEstado(estado);
                      clidao.agregar(cli);
                      request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                      break;    
                  case "Editar": 
                      idCli=Integer.parseInt(request.getParameter("id"));      System.err.println("PASO AA GET");
                      Cliente cl=clidao.ListarId(idCli);
                      request.setAttribute("Cliente",cl);
                      request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response); 
                      break;    
                   case "Actualizar":                                          System.err.println("PASO BB GET");
                      String dni2   =request.getParameter("txtDNI"); 
                      String nom2   =request.getParameter("txtNombres");
                      String dir2   =request.getParameter("txtDir");
                      String estado2=request.getParameter("txtEstado");
                      cli.setDni(dni2);
                      cli.setNom(nom2);
                      cli.setDir(dir2);
                      cli.setEstado(estado2);
                      cli.setId(idCli);
                      clidao.actualizar(cli);
                      request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response); 
                      break;       
                  case "Delete": 
                      idCli=Integer.parseInt(request.getParameter("id"));
                      clidao.delete(idCli);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response); 
                      break;      
                  default:
                      throw new AssertionError();
              }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);  
            }

             if(menu.equals("NuevaVenta")){   
                  switch(action){
                  case "BuscarCliente":                      
                      String dni1 =request.getParameter("codigoCliente");  
                      cli.setDni(dni1);
                      cli = clidao.buscar(dni1);   
                      request.setAttribute("c",cli); 
                      request.setAttribute("numeroSerie",numeroSerie); 
                      break;
                   case "BuscarProd":                      
                      int id = Integer.parseInt(request.getParameter("codigoProducto")); 
                      prod=pdao.ListarId(id);
                      prod.setIdProducto(id);
                      request.setAttribute("c",cli); 
                      request.setAttribute("producto",prod);   
                      request.setAttribute("listaVenta",listaVenta);
                      request.setAttribute("totalPagar",totalPagar);
                      request.setAttribute("numeroSerie",numeroSerie); 
                      break;    
                   case "Agregar":  
                      request.setAttribute("c",cli); 
                      totalPagar=0.0;
                      item =item +1;
                      codProd=prod.getIdProducto();
                      descripcion=request.getParameter("nombresProducto");  
                      precio=Double.parseDouble(request.getParameter("precio"));
                      cant=Integer.parseInt(request.getParameter("cant"));
                      subtotal=precio*cant;
                      v=new Venta();
                      v.setItem(item);
                      v.setIdProducto(codProd);
                      v.setDescripcionProd(descripcion);
                      v.setPrecio(precio);
                      v.setCantidad(cant);
                      v.setSubtotal(subtotal);
                      listaVenta.add(v);
                       for(int i=0;i<listaVenta.size();i++){
                         totalPagar=totalPagar+listaVenta.get(i).getSubtotal();
                      }                      
                      request.setAttribute("totalPagar",totalPagar);
                      request.setAttribute("listaVenta",listaVenta); 
                      request.setAttribute("numeroSerie",numeroSerie); 
                      break;
                     case "GenerarVenta":   
                       for(int i=0;i<listaVenta.size();i++){
                          Producto prod=new Producto();
                          int cantidad=listaVenta.get(i).getCantidad();
                          int idProducto=listaVenta.get(i).getIdProducto();
                          ProductoDAO pd= new ProductoDAO();
                          prod=pd.buscar(idProducto);
                          int sac=Integer.parseInt(prod.getStock())- cantidad;
                          pd.actualizarStock(idProducto, sac);
                      }   
                      v.setIdCliente(cli.getId());
                      v.setIdEmpleado(1);
                      v.setNumSerie(numeroSerie);
                      v.setFecha("2019-05-06");
                      v.setMonto(totalPagar);
                      vdao.guardarVenta(v);
                      //Detalle de Ventas
                      int idv=Integer.parseInt(vdao.idventas());
                      for(int i=0;i<listaVenta.size();i++){
                          v=new Venta();
                          v.setId(idv);
                          v.setIdProducto(listaVenta.get(i).getIdProducto());
                          v.setCantidad(listaVenta.get(i).getCantidad());
                          v.setPrecio(listaVenta.get(i).getPrecio());
                          vdao.guardarDetalleVentas(v);
                      }                      
                      
                      break;         
                   default:
                      numeroSerie=vdao.GenerarSerie();
                      if(numeroSerie==null){
                          numeroSerie="00000001";
                          request.setAttribute("numeroSerie",numeroSerie); 
                      }else{                                                System.err.println("PASO 1");
                          int incrementar=Integer.parseInt(numeroSerie);System.err.println("PASO 2");
                          GenerarSerie gs=new GenerarSerie();                   System.err.println("PASO 3");
                          numeroSerie=gs.numeroSerie(incrementar);System.err.println("PASO 4");
                          request.setAttribute("numeroSerie",numeroSerie); System.err.println("PASO 5");
                      }
                      request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);     
                     
              }
                 request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);  
            }
          
            if(menu.equals("Producto")){
                switch(action){
                  case "Listar":                      
                      List lista=pdao.listar();
                      request.setAttribute("productos",lista);
                      break;
                  case "Agregar": 
                      String nom=request.getParameter("txtNombres"); 
                      String precio=request.getParameter("txtPrecio");
                      String stock=request.getParameter("txtStock");
                      String estado=request.getParameter("txtEstado");
                      prod.setNom(nom);
                      prod.setPrecio(precio);
                      prod.setStock(stock);
                      prod.setEstado(estado);
                      pdao.agregar(prod);
                      request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                      break;    
                  case "Editar": 
                      idp=Integer.parseInt(request.getParameter("id"));
                      Producto pr=pdao.ListarId(idp);
                      request.setAttribute("producto",pr);
                      request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response); 
                      break;    
                   case "Actualizar": 
                      String nom1=request.getParameter("txtNombres"); 
                      String pre1=request.getParameter("txtPrecio");
                      String stk1=request.getParameter("txtStock");
                      String sta1=request.getParameter("txtEstado");
                      prod.setNom(nom1);
                      prod.setPrecio(pre1);
                      prod.setStock(stk1);
                      prod.setEstado(sta1);
                      prod.setIdProducto(idp);
                      pdao.actualizar(prod);
                      request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response); 
                      break;        
                  case "Delete": 
                      idp=Integer.parseInt(request.getParameter("id"));
                      pdao.delete(idp);
                      request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response); 
                      break;      
                  default:
                      throw new AssertionError();
              }
              request.getRequestDispatcher("Producto.jsp").forward(request, response);  
           }
               
         } catch (Exception e) {
             System.err.println("EXCEPCION GET : "+e.getMessage());
        }  
          
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
           try {
           System.err.println("METODO POST");
           String action=request.getParameter("accion");
           String menu=request.getParameter("menu");
           
           System.err.println("action = "+action);
           System.err.println("menu = "+menu);
          
            if(menu.equals("Empleado")){
                switch(action){
                  case "Listar":                      
                      List lista=edao.listar();
                      request.setAttribute("empleados",lista);
                      break;
                  case "Agregar": 
                      String dni=request.getParameter("txtDni");
                      String nom=request.getParameter("txtNombres"); 
                      String tel=request.getParameter("txtTelefono");
                      String est=request.getParameter("txtEstado");
                      String user=request.getParameter("txtUsuario");
                      em.setDni(dni);
                      em.setNom(nom);
                      em.setTel(tel);
                      em.setEstado(est);
                      em.setUser(user);
                      edao.agregar(em);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                      break;    
                  case "Editar": 
                      ide=Integer.parseInt(request.getParameter("id"));
                      Empleado e=edao.ListarId(ide);
                      request.setAttribute("empleado",e);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);  
                      break;    
                   case "Actualizar": 
                      String dni1=request.getParameter("txtDni");
                      String nom1=request.getParameter("txtNombres"); 
                      String tel1=request.getParameter("txtTelefono");
                      String est1=request.getParameter("txtEstado");
                      String user1=request.getParameter("txtUsuario");
                      em.setDni(dni1);
                      em.setNom(nom1);
                      em.setTel(tel1);
                      em.setEstado(est1); 
                      em.setUser(user1);
                      em.setId(ide);
                      edao.actualizar(em);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);  
                      break;        
                      
                  case "Delete": 
                      ide=Integer.parseInt(request.getParameter("id"));
                      edao.delete(ide);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response); 
                      break;       
                  default:
                      throw new AssertionError();
              }
               request.getRequestDispatcher("Empleado.jsp").forward(request, response); 
            }
          
            if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);  
            }

            if(menu.equals("Cliente")){
                switch(action){
                  case "Listar":                      
                      List lista=clidao.listar();
                      request.setAttribute("clientes",lista);
                      break;
                  case "Agregar": 
                      String dni=request.getParameter("txtDNI"); 
                      String nom=request.getParameter("txtNombres");
                      String dir=request.getParameter("txtDir");
                      String estado=request.getParameter("txtEstado");
                      cli.setDni(dni);
                      cli.setNom(nom);
                      cli.setDir(dir);
                      cli.setEstado(estado);
                      clidao.agregar(cli);
                      request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                      break;                   
                  case "Editar":                                                     
                      idCli=Integer.parseInt(request.getParameter("id"));
                      Cliente cl=clidao.ListarId(idCli);
                      request.setAttribute("Cliente",cl);
                      request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response); 
                      break;    
                   case "Actualizar":                                               
                      String dni2   =request.getParameter("txtDNI"); 
                      String nom2   =request.getParameter("txtNombres");
                      String dir2   =request.getParameter("txtDir");
                      String estado2=request.getParameter("txtEstado");
                      cli.setDni(dni2);
                      cli.setNom(nom2);
                      cli.setDir(dir2);
                      cli.setEstado(estado2);
                      cli.setId(idCli);
                      clidao.actualizar(cli);
                      request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response); 
                      break;                         
                  case "Delete": 
                      idCli=Integer.parseInt(request.getParameter("id"));
                      clidao.delete(idCli);
                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response); 
                      break;      
                  default:
                      throw new AssertionError();
              }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);  
            } 
             if(menu.equals("NuevaVenta")){    
                 switch(action){
                  case "BuscarCliente":                      
                      String dni1 =request.getParameter("codigoCliente");  
                      cli.setDni(dni1);
                      cli = clidao.buscar(dni1);   
                      request.setAttribute("c",cli); 
                      request.setAttribute("numeroSerie",numeroSerie); 
                      break;
                  case "BuscarProd":                      
                      int id = Integer.parseInt(request.getParameter("codigoProducto"));  
                      prod=pdao.ListarId(id);
                      prod.setIdProducto(id);
                      request.setAttribute("c",cli); 
                      request.setAttribute("producto",prod);   
                      request.setAttribute("listaVenta",listaVenta); 
                      request.setAttribute("totalPagar",totalPagar);
                      request.setAttribute("numeroSerie",numeroSerie); 
                      break;  
                    case "Agregar":  
                      request.setAttribute("c",cli); 
                      totalPagar=0.0;
                      item =item +1;
                      codProd=prod.getIdProducto();
                      descripcion=request.getParameter("nombresProducto");  
                      precio=Double.parseDouble(request.getParameter("precio"));
                      cant=Integer.parseInt(request.getParameter("cant"));
                      subtotal=precio*cant;
                      v=new Venta();
                      v.setItem(item);
                      v.setIdProducto(codProd);
                      v.setDescripcionProd(descripcion);
                      v.setPrecio(precio);
                      v.setCantidad(cant);
                      v.setSubtotal(subtotal);
                      listaVenta.add(v);
                      for(int i=0;i<listaVenta.size();i++){
                         totalPagar=totalPagar+listaVenta.get(i).getSubtotal();
                      }                      
                      request.setAttribute("totalPagar",totalPagar);
                      request.setAttribute("listaVenta",listaVenta); 
                      request.setAttribute("numeroSerie",numeroSerie); 
                      break;  
                  case "GenerarVenta":       
                      for(int i=0;i<listaVenta.size();i++){
                          Producto prod=new Producto();
                          int cantidad=listaVenta.get(i).getCantidad();
                          int idProducto=listaVenta.get(i).getIdProducto();
                          ProductoDAO pd= new ProductoDAO();
                          prod=pd.buscar(idProducto);
                          int sac=Integer.parseInt(prod.getStock())- cantidad;
                          pd.actualizarStock(idProducto, sac);
                      }
                      v.setIdCliente(cli.getId());
                      v.setIdEmpleado(1);
                      v.setNumSerie(numeroSerie);
                      v.setFecha("2019-05-06");
                      v.setMonto(totalPagar);
                      vdao.guardarVenta(v);
                      //Detalle de Ventas
                      int idv=Integer.parseInt(vdao.idventas());
                      for(int i=0;i<listaVenta.size();i++){
                          v=new Venta();
                          v.setId(idv);
                          v.setIdProducto(listaVenta.get(i).getIdProducto());
                          v.setCantidad(listaVenta.get(i).getCantidad());
                          v.setPrecio(listaVenta.get(i).getPrecio());
                          vdao.guardarDetalleVentas(v);
                      }                      
                      
                      break;      
                  default:
                      numeroSerie=vdao.GenerarSerie();
                      if(numeroSerie==null){
                          numeroSerie="00000001";
                          request.setAttribute("numeroSerie",numeroSerie); 
                      }else{
                          int incrementar=Integer.parseInt(numeroSerie);
                          GenerarSerie gs=new GenerarSerie();
                          numeroSerie=gs.numeroSerie(incrementar);
                          request.setAttribute("numeroSerie",numeroSerie); 
                      }
                      request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);   
              }
                 request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);  
            }
            if(menu.equals("Producto")){
                switch(action){
                  case "Listar":                      
                      List lista=pdao.listar();
                      request.setAttribute("productos",lista);
                      break;
                  case "Agregar": 
                      String nom=request.getParameter("txtNombres"); 
                      String precio=request.getParameter("txtPrecio");
                      String stock=request.getParameter("txtStock");
                      String estado=request.getParameter("txtEstado");
                      prod.setNom(nom);
                      prod.setPrecio(precio);
                      prod.setStock(stock);
                      prod.setEstado(estado);
                      pdao.agregar(prod);
                      request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                      break;    
                   case "Editar": 
                      idp=Integer.parseInt(request.getParameter("id"));
                      Producto pr=pdao.ListarId(idp);
                      request.setAttribute("producto",pr);
                      request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response); 
                      break;    
                   case "Actualizar": 
                      String nom1=request.getParameter("txtNombres"); 
                      String pre1=request.getParameter("txtPrecio");
                      String stk1=request.getParameter("txtStock");
                      String sta1=request.getParameter("txtEstado");
                      prod.setNom(nom1);
                      prod.setPrecio(pre1);
                      prod.setStock(stk1);
                      prod.setEstado(sta1);
                      prod.setIdProducto(idp);
                      pdao.actualizar(prod);
                      request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response); 
                      break;        
                  case "Delete": 
                      idp=Integer.parseInt(request.getParameter("id"));
                      pdao.delete(idp);
                      request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response); 
                      break;      
                  default:
                      throw new AssertionError();
              }
              request.getRequestDispatcher("Producto.jsp").forward(request, response);  
           }
               
         } catch (Exception e) {
             System.err.println("EXCEPCION POST : "+e.getMessage());
        } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
