/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.ConexionBD;
import Modelo.Proveedores;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author USER
 */
public class ProveedoresDAO implements IProveedoresDAO {
    private final ConexionBD conexionBD;

    public ProveedoresDAO() {
        this.conexionBD = new ConexionBD();
    }

    @Override
    public List<Proveedores> obtenerProveedores() {
        List<Proveedores> proveedores = new ArrayList<>();
        String sql = "SELECT id, nombre, persona_contacto FROM proveedores";

        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Proveedores proveedor = new Proveedores(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("persona_contacto")
                );
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores más específico puede ser implementado aquí
        }
        return proveedores;
    }

    @Override
    public void agregarProveedor(Proveedores nuevoProveedor) {
        String sql = "INSERT INTO proveedores (nombre, persona_contacto) VALUES (?, ?)";

        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevoProveedor.getNombre());
            stmt.setString(2, nuevoProveedor.getPersonaContacto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    @Override
    public void editarProveedor(Proveedores proveedor) {
        String sql = "UPDATE proveedores SET nombre = ?, persona_contacto = ? WHERE id = ?";

        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getPersonaContacto());
            stmt.setInt(3, proveedor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    @Override
    public void eliminarProveedor(int proveedorId) {
        String sqlProducto = "DELETE FROM lista_productos WHERE proveedor_id = ?";
        String sqlProveedor = "DELETE FROM proveedores WHERE id = ?";

        try (Connection conn = conexionBD.obtenerConexion()) {
            // Eliminar productos que hacen referencia al proveedor
            try (PreparedStatement stmtProducto = conn.prepareStatement(sqlProducto)) {
                stmtProducto.setInt(1, proveedorId);
                stmtProducto.executeUpdate();
            }

            // Ahora eliminar el proveedor
            try (PreparedStatement stmtProveedor = conn.prepareStatement(sqlProveedor)) {
                stmtProveedor.setInt(1, proveedorId);
                stmtProveedor.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }
}
