/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Categoria;
import Modelo.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class CategoriaDAO implements ICategoriaDAO {
    private final ConexionBD conexionBD;

    public CategoriaDAO() {
        this.conexionBD = new ConexionBD();
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT id, nombre FROM categorias"; // Asegúrate de que el nombre de la tabla sea correcto

        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                categorias.add(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorias;
    }
    
    @Override
    public void agregarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";

        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void editarCategoria(Categoria categoria) {
        String sql = "UPDATE categorias SET nombre = ? WHERE id = ?";

        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void eliminarCategoria(int categoriaId) {
        String sqlProducto = "DELETE FROM lista_productos WHERE categoria_id = ?";
        String sqlCategoria = "DELETE FROM categorias WHERE id = ?";

        try (Connection conn = conexionBD.obtenerConexion()) {
            // Eliminar productos que hacen referencia a la categoría
            try (PreparedStatement stmtProducto = conn.prepareStatement(sqlProducto)) {
                stmtProducto.setInt(1, categoriaId);
                stmtProducto.executeUpdate();
            }

            // Ahora eliminar la categoría
            try (PreparedStatement stmtCategoria = conn.prepareStatement(sqlCategoria)) {
                stmtCategoria.setInt(1, categoriaId);
                stmtCategoria.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar el error
        }
    }
}
