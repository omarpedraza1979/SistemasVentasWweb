package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
     public Producto buscar(int id){
        String sql="select * from producto where idProducto="+id;
         Producto prod=new Producto();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();   
           
            while(rs.next()){

                prod.setIdProducto(rs.getInt(1));
                prod.setNom(rs.getString(2));
                prod.setPrecio(rs.getString(3));
                prod.setStock(rs.getString(4));
                prod.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.err.println("EXCEPCION LISTAR : "+e.getMessage());
        }
        return prod;
     }
    
     public int actualizarStock(int id, int stock){
           String sql="update producto set stock=? where idProducto=?";
        try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("EXCEPCION ACTUALIZAR : "+e.getMessage());
        }
       return r;
     }
    
    public List listar() {
        //System.err.println("DENTRO DE METODO LISTAR");
        ArrayList<Producto>list=new ArrayList<>();
        
        String sql="select * from producto";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();   
            
            while(rs.next()){
                
                Producto prod=new Producto();
                prod.setIdProducto(rs.getInt(1));
                prod.setNom(rs.getString(2));
                prod.setPrecio(rs.getString(3));
                prod.setStock(rs.getString(4));
                prod.setEstado(rs.getString(5));
                list.add(prod);
            }
        } catch (Exception e) {
            System.err.println("EXCEPCION LISTAR : "+e.getMessage());
        }
        //System.err.println("elementos lista = "+list.size());
        return list;
    }
    
    
   public int agregar(Producto prod) {
       String sql="insert into producto(nombres,precio,stock,estado)values(?,?,?,?)";
        try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, prod.getNom());
            ps.setString(2, prod.getPrecio());
            ps.setString(3, prod.getStock());
            ps.setString(4, prod.getEstado());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("EXCEPCION AGREGAR : "+e.getMessage());
        }
       return r;
    }
    
    public int actualizar(Producto prod){ 
     System.err.println("DENTRO DE ACTUALIZAR PRODUCTO");
     String sql="update producto set nombres=? , precio=?, stock=?, estado=? where idProducto=?";
        try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, prod.getNom());
            ps.setString(2, prod.getPrecio());
            ps.setString(3, prod.getStock());
            ps.setString(4, prod.getEstado());
            ps.setInt(5, prod.getIdProducto());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("EXCEPCION ACTUALIZAR : "+e.getMessage());
        }
       return r;
    }
    
      public Producto ListarId(int id){
          
        System.err.println("DENTRO DE LISTAR_ID");  
        System.err.println("IDE SELECCIONADO : "+id);  
          
        Producto pr =new Producto();
        String sql="select * from producto where idProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pr.setNom(rs.getString(2));
                pr.setPrecio(rs.getString(3));
                pr.setStock(rs.getString(4));    System.err.println("PASO XXXXXXX");  
                pr.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
             System.err.println("EXCEPCION LISTAR ID : "+e.getMessage());
        }
        //System.err.println("elementos lista = "+list.size());
        return pr;
          
      }
    
    public void delete(int id){
        String sql="delete from producto where idProducto="+id;
        
         try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
           System.err.println("EXCEPCION : "+e.getMessage());
        }
    }
    
}
