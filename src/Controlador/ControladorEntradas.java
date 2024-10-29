/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Entrada;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ControladorEntradas {

    private ConexionBD conexionBD; // Asegúrate de tener una clase para manejar la conexión a la base de datos

    public ControladorEntradas() {
        this.conexionBD = new ConexionBD(); // Inicializa tu conexión a la base de datos
    }

    // Método para obtener la lista de entradas con nombres
    public List<Entrada> obtenerEntradas() {
        List<Entrada> entradas = new ArrayList<>();
    String sql = "SELECT e.id, e.categoria_id, e.proveedor_id, e.producto_id, "
               + "e.cantidad, e.precio_compra, e.precio_venta, e.fecha_entrada, "
               + "c.nombre AS nombre_categoria, pr.nombre AS nombre_proveedor, p.nombre AS nombre_producto "
               + "FROM entradas e "
               + "JOIN categorias c ON e.categoria_id = c.id "
               + "JOIN proveedores pr ON e.proveedor_id = pr.id "
               + "JOIN lista_productos p ON e.producto_id = p.id";

    try (Connection conn = conexionBD.obtenerConexion(); 
         PreparedStatement stmt = conn.prepareStatement(sql); 
         ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            // Obtener la fecha como Date
            Date fechaEntradaDate = rs.getDate("fecha_entrada");

            Entrada entrada = new Entrada(
                rs.getInt("id"),
                rs.getInt("categoria_id"),
                rs.getInt("proveedor_id"),
                rs.getInt("producto_id"),
                rs.getInt("cantidad"),
                rs.getDouble("precio_compra"),
                rs.getDouble("precio_venta"),
                fechaEntradaDate, // Utilizar la fecha como Date
                rs.getString("nombre_producto"),
                rs.getString("nombre_proveedor"),
                rs.getString("nombre_categoria")
            );
            entradas.add(entrada);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return entradas;
}
}
