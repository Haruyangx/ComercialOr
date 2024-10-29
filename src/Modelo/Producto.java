/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String nombreCategoria; // Atributo para el nombre de la categoría
    private String nombreProveedor; // Atributo para el nombre del proveedor

    public Producto(int id, String nombre, String descripcion, String nombreCategoria, String nombreProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombreCategoria = nombreCategoria;
        this.nombreProveedor = nombreProveedor; // Inicialización del nuevo atributo
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getNombreProveedor() { // Nuevo método para obtener el nombre del proveedor
        return nombreProveedor;
    }
}
