/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dismaelectric
 */
public class ConexionBase {
public void realizaConexion(){
            Connection conn = null;
            String urlDatabase =  "jdbc:postgresql://localhost:5432/labo8"; 
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(urlDatabase,  "postgres", "1234");
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
            }
            System.out.println("La conexión se realizo sin problemas! =) ");
}
    
   
    
 }