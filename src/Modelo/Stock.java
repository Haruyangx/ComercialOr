/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Stock {
    private int id;
    private String nombreProducto;
    private String nombreCategoria;
    private String nombreProveedor;
    private int stockDisponible;

    public Stock(int id, String nombreProducto, String nombreCategoria, String nombreProveedor, int stockDisponible) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.nombreCategoria = nombreCategoria;
        this.nombreProveedor = nombreProveedor;
        this.stockDisponible = stockDisponible;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombreProducto() { return nombreProducto; }
    public String getNombreCategoria() { return nombreCategoria; }
    public String getNombreProveedor() { return nombreProveedor; }
    public int getStockDisponible() { return stockDisponible; }
}

