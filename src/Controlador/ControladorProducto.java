/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.DAO.IProductoDAO;
import Modelo.Producto;
import java.util.List;

/**
 *
 * @author USER
 */
public class ControladorProducto {

    private IProductoDAO productoDAO;

    public ControladorProducto(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public List<Producto> obtenerProductos() {
        return productoDAO.obtenerProductos();
    }

    public Producto obtenerProductoPorId(int id) {
        return productoDAO.obtenerProductoPorId(id);
    }

    public void agregarProducto(Producto producto) {
        productoDAO.agregarProducto(producto);
    }

    public void editarProducto(Producto producto) {
        productoDAO.editarProducto(producto);
    }

    public void eliminarProducto(int id) {
        productoDAO.eliminarProducto(id);
    }

    public List<String> obtenerCategorias() {
        return productoDAO.obtenerCategorias(); // Llama al método en el DAO para obtener categorías
    }

    public List<String> obtenerProveedores() {
        return productoDAO.obtenerProveedores(); // Llama al método en el DAO para obtener proveedores
    }

    public int obtenerIdCategoria(String nombreCategoria) {
        return productoDAO.obtenerIdCategoria(nombreCategoria); // Llama al método en el DAO para obtener el ID
    }

    public int obtenerIdProveedor(String nombreProveedor) {
        return productoDAO.obtenerIdProveedor(nombreProveedor);
    }
}
