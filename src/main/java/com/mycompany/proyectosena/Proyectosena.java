package com.mycompany.proyectosena;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Proyectosena {

    public static void main(String[] args) {
        String usuario="root";
        String password="Ereyes87/*-+";
        String url="jdbc:mysql://localhost:3306/proyectosena";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //Inserción de datos
            statement.execute("INSERT INTO `usuarios` (`id_usaurio`, `nombre`, `contasena`, `id_rol`, `id_cliente`) VALUES (NULL, 'Fanny Galindo', 'qwsdf48', '1236', '1236');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Actualizacoón de datos
             statement.execute("UPDATE `usuarios` SET `nombre` = 'Ewdard Galingo' WHERE `usuarios`.`id_usaurio` = 4;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Eliminar datos
            statement.execute("DELETE FROM `usuarios` WHERE `usuarios`.`id_usaurio` = 4");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
        } catch (SQLException ex) {
            System.getLogger(Proyectosena.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
}
