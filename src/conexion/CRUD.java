/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mabel
 */
public class CRUD {
    public ConexionBase cb;

    public CRUD() {
        cb= new ConexionBase();
    }
public boolean Crear(int id,String nombre, int id_cate,float precioUni,int existencia) throws SQLException{
        Connection conn = cb.getConnection();
        boolean isSuccess = false;
        String query = "INSERT INTO producto VALUES (?,?,?,?)";
        String query2 = "SELECT * FROM producto WHERE id= ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            PreparedStatement pstm2 = conn.prepareStatement(query2);
            pstm.setString(2, nombre);
            pstm.setInt(3, id_cate);
            pstm.setFloat(4, precioUni);
            pstm.setInt(5, existencia);
            
            pstm2.setInt(1, id);
            if(!pstm2.executeQuery().isFirst()){
                pstm.execute();
                isSuccess = true;
            }
            //conn.close();
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
        return isSuccess;
    }

   public List<Producto> ReadAll(){
        Connection conn = cb.getConnection();
        List<Producto> pro = new ArrayList();
        String query = "SELECT p.id_producto,p.nombre_producto,cp.nombre_categoria,p.precio_unitario,p.cantidad_existencia \n" +
"FROM producto p, categoria_producto cp WHERE p.id_categoria=cp.id_categoria;";
        try{
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre_producto"));
                producto.setNombre_categoria(rs.getString("nombre_categoria"));
                producto.setPrecioUni(rs.getFloat("precio_unitario"));
                producto.setExistencia(rs.getInt("cantidad_existencia"));
                pro.add(producto);
            }
            //conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return pro;
    }  
    
   public boolean updateProducto(int id,Producto producto) throws SQLException{
        boolean flag = false;
        Connection conn = cb.getConnection();
        String query = "UPDATE producto SET nombre_producto = ?, id_categoria= ?, precio_unitario= ?, cantidad_existencia = ?  WHERE id_producto = ?";
        try{
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, producto.getId());
            stm.setString(2, producto.getNombre());
            stm.setInt(3, producto.getIdCategoria());
            stm.setFloat(4, producto.getPrecioUni());
            stm.setInt(5, producto.getExistencia());
            
            if(stm.executeUpdate()!=0) flag = true; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return flag;
    }
   public boolean deleteProducto(int id)throws SQLException{
        boolean flag = false;
        Connection conn = cb.getConnection();
        String query = "DELETE FROM producto WHERE id = ?";
        try{
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            int rows = stm.executeUpdate();
            if(rows!=0) flag = true;
            conn.close();
        }catch(SQLException ex){
            System.out.println("Error " + ex.getMessage());
            ex.printStackTrace();
        }
        return flag;
    }
}
