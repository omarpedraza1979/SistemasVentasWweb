package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie()
    {
         String numeroSerie="";
         String sql="select max(numeroserie) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();   
            
            while(rs.next()){
              numeroSerie=rs.getString(1);
            }
        } catch (Exception e) {
            System.err.println("EXCEPCION GenerarSerie : "+e.getMessage());
        }
        return numeroSerie;         
                 
    }
    
    
    public String idventas(){
         String idVentas="";
         String sql="select max(idVentas) from ventas";
         
           try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();   
            
            while(rs.next()){
              idVentas=rs.getString(1);
            }
        } catch (Exception e) {
            System.err.println("EXCEPCION idventas : "+e.getMessage());
        }
        return idVentas;       
    }
    
    
     public int guardarVenta(Venta ve){
         String idVentas="";
         String sql="insert into ventas(idCliente, idEmpleado, numeroSerie, fechaVentas, monto, estado)values(?,?,?,?,?,?)";
         
           try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getIdCliente());
            ps.setInt(2, ve.getIdEmpleado());
            ps.setString(3, ve.getNumSerie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getPrecio());         
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("EXCEPCION guardarVenta : "+e.getMessage());
        }
        return r;       
    }
    
    
     public int guardarDetalleVentas(Venta ve){
         String idVentas="";
         String sql="insert into detalle_ventas(idVentas, idProducto, cantidad, precioVenta)values(?,?,?,?)";
         
           try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getId());
            ps.setInt(2, ve.getIdProducto());
            ps.setInt(3, ve.getCantidad());
            ps.setDouble(4, ve.getPrecio());         
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("EXCEPCION guardarDetalleVentas : "+e.getMessage());
        } 
        return r;       
    }
    
    
    
    
    
    
}
