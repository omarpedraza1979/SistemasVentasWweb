/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedrazao
 */
public class ClienteDAO {
 
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
     public Cliente buscar(String dni) {
        Cliente cli =new Cliente();
        String sql="select * from cliente where Dni="+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDir(rs.getString(4));    //System.err.println("PASO XXXXXXX");  
                cli.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
             System.err.println("EXCEPCION LISTAR ID : "+e.getMessage());
        }
        //System.err.println("elementos lista = "+list.size());
        return cli;
     }
    
    public List listar() {
        //System.err.println("DENTRO DE METODO LISTAR");
        ArrayList<Cliente>list=new ArrayList<>();
        
        String sql="select * from cliente";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();   
            
            while(rs.next()){
                
                Cliente cli=new Cliente();
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setEstado(rs.getString(5));
                list.add(cli);
            }
        } catch (Exception e) {
            System.err.println("EXCEPCION LISTAR CLIENTE : "+e.getMessage());
        }
        //System.err.println("elementos lista = "+list.size());
        return list;
    }
    
    
   public int agregar(Cliente cli) {
       String sql="insert into cliente(dni,nombres,direccion,estado)values(?,?,?,?)";
        try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getEstado());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("EXCEPCION AGREGAR : "+e.getMessage());
        }
       return r;
    }
    
    public int actualizar(Cliente cli){ 
        
     System.err.println("DENTRO DE ACTUALIZAR CLIENTE");
        
     String sql="update Cliente set dni=? , nombres=?, direccion=?, estado=? where idcliente=?";
        try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getEstado());
            ps.setInt(5, cli.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("EXCEPCION ACTUALIZAR : "+e.getMessage());
        }
       return r;
    }
    
      public Cliente ListarId(int id){
          
        System.err.println("DENTRO DE LISTAR_ID");  
        System.err.println("IDE SELECCIONADO : "+id);  
          
        Cliente cli =new Cliente();
        String sql="select * from cliente where idCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDir(rs.getString(4));    System.err.println("PASO XXXXXXX");  
                cli.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
             System.err.println("EXCEPCION LISTAR ID : "+e.getMessage());
        }
        //System.err.println("elementos lista = "+list.size());
        return cli;
           
      }
    
    public void delete(int id){
        String sql="delete from cliente where idCliente="+id;
        
         try { 
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
           System.err.println("EXCEPCION : "+e.getMessage());
        }
    }
    
}

