package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar(String user, String password){
         
            Empleado em = new Empleado();
            String sql="select * from empleado where user = ? and dni = ?";
            //System.err.println("VALIDAR VALIDAR");
             try {
                  con= cn.Conexion();
                  ps=con.prepareStatement(sql);
                  ps.setString(1, user);
                  ps.setString(2, password);
                  rs=ps.executeQuery();
                  
               while(rs.next()){
                  em.setUser(rs.getString("User"));
                  em.setDni(rs.getString("Dni"));
                  em.setNom(rs.getString("Nombres"));
                  em.setId(rs.getInt("idEmpleado"));
                }  
               
            } catch (Exception e) {
            }
             
           return em; 
    }
    
    public List listar() {
        //System.err.println("DENTRO DE METODO LISTAR");
        ArrayList<Empleado>list=new ArrayList<>();
        
        String sql="select * from empleado";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();   
            
            while(rs.next()){
                
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                list.add(em);
            }
        } catch (Exception e) {
            System.err.println("EXCEPCION LISTAR : "+e.getMessage());
        }
        //System.err.println("elementos lista = "+list.size());
        return list;
    }
    
    
   public int agregar(Empleado em) {
       String sql="insert into empleado(dni,nombres,telefono, estado, user)values(?,?,?,?,?)";
        try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("EXCEPCION AGREGAR : "+e.getMessage());
        }
       return r;
    }
    
    public int actualizar(Empleado em){
     String sql="update empleado set dni=? , nombres=?, telefono=?, estado=?, user=? where idEmpleado=?";
        try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("EXCEPCION ACTUALIZAR : "+e.getMessage());
        }
       return r;
    }
    
      public Empleado ListarId(int id){
          
        //System.err.println("DENTRO DE LISTAR_ID");  
        //System.err.println("IDE SELECCIONADO : "+id);  
          
        Empleado emp =new Empleado();
         String sql="select * from empleado where idEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                emp.setDni(rs.getString(2));   System.err.println("PASO C");  
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));System.err.println("PASO D");  
                emp.setUser(rs.getString(6));
            }
        } catch (Exception e) {
             System.err.println("EXCEPCION LISTAR ID : "+e.getMessage());
        }
        //System.err.println("elementos lista = "+list.size());
        return emp;
          
      }
    
    public void delete(int id){
        String sql="delete from empleado where idEmpleado="+id;
        
         try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
           System.err.println("EXCEPCION : "+e.getMessage());
        }
    }
    
}
