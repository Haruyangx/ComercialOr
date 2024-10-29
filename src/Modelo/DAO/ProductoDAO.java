/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.ConexionBD;
import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements IProductoDAO {

    private ConexionBD conexionBD;

    public ProductoDAO() {
        this.conexionBD = new ConexionBD();
    }

    @Override
    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.id, p.nombre, p.descripcion, c.nombre AS nombre_categoria, pr.nombre AS nombre_proveedor "
                + "FROM lista_productos p "
                + "JOIN categorias c ON p.categoria_id = c.id "
                + "JOIN proveedores pr ON p.proveedor_id = pr.id";

        try (Connection conn = conexionBD.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("nombre_categoria"),
                        rs.getString("nombre_proveedor")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto obtenerProductoPorId(int id) {
        Producto producto = null;
        String sql = "SELECT p.id, p.nombre, p.descripcion, c.nombre AS nombre_categoria, pr.nombre AS nombre_proveedor "
                + "FROM lista_productos p "
                + "JOIN categorias c ON p.categoria_id = c.id "
                + "JOIN proveedores pr ON p.proveedor_id = pr.id WHERE p.id = ?";

        try (Connection conn = conexionBD.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                producto = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("nombre_categoria"),
                        rs.getString("nombre_proveedor")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void agregarProducto(Producto producto) {
        String sql = "INSERT INTO lista_productos (nombre, categoria_id, proveedor_id, descripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexionBD.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, obtenerIdCategoria(producto.getNombreCategoria())); // Método adicional
            stmt.setInt(3, obtenerIdProveedor(producto.getNombreProveedor())); // Método adicional
            stmt.setString(4, producto.getDescripcion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editarProducto(Producto producto) {
        String sql = "UPDATE lista_productos SET nombre = ?, categoria_id = ?, proveedor_id = ?, descripcion = ? WHERE id = ?";
        try (Connection conn = conexionBD.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, obtenerIdCategoria(producto.getNombreCategoria())); // Método adicional
            stmt.setInt(3, obtenerIdProveedor(producto.getNombreProveedor())); // Método adicional
            stmt.setString(4, producto.getDescripcion());
            stmt.setInt(5, producto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM lista_productos WHERE id = ?";
        try (Connection conn = conexionBD.obtenerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
  @Override
    public List<String> obtenerCategorias() {
        List<String> categorias = new ArrayList<>();
        String sql = "SELECT nombre FROM categorias";
        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                categorias.add(rs.getString("nombre")); // Agrega el nombre a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias; // Devuelve la lista de nombres de categorías
    }

    @Override
    public List<String> obtenerProveedores() {
        List<String> proveedores = new ArrayList<>();
        String sql = "SELECT nombre FROM proveedores";
        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                proveedores.add(rs.getString("nombre")); // Agrega el nombre a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores; // Devuelve la lista de nombres de proveedores
    }

    @Override
    public int obtenerIdCategoria(String nombreCategoria) {
        String sql = "SELECT id FROM categorias WHERE nombre = ?";
        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreCategoria);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id"); // Devuelve el ID encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Devuelve -1 si no se encuentra
    }

    @Override
    public int obtenerIdProveedor(String nombreProveedor) {
        String sql = "SELECT id FROM proveedores WHERE nombre = ?";
        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreProveedor);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id"); // Devuelve el ID encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Devuelve -1 si no se encuentra
    }
}
