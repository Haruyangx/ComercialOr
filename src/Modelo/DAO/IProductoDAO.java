/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.DAO;

import Modelo.Producto;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IProductoDAO {
    List<Producto> obtenerProductos();
    Producto obtenerProductoPorId(int id);
    void agregarProducto(Producto producto);
    void editarProducto(Producto producto);
    void eliminarProducto(int id);
    List<String> obtenerCategorias(); // Método para obtener nombres de categorías
    List<String> obtenerProveedores(); // Método para obtener nombres de proveedores
    int obtenerIdCategoria(String nombreCategoria); // Método para obtener ID de categoría
    int obtenerIdProveedor(String nombreProveedor);
}



