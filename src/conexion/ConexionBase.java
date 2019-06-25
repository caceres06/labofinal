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
   private final String DRIVER = "org.postgresql.Driver";  
    //Cadena de conexión
    private final String URL = "jdbc:postgresql://localhost:5432/LaboFinal";  
    //usuario de la base de datos
    private final String USERNAME = "postgres";    
    // contraseña de la base de datos
    private final String PASSWORD = "1234"; 
    
    private Connection connection;

    //metodo que establece la conexion
    public ConexionBase() {
        connection = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
    public Connection getConnection(){
        return connection;
    }
    
 }