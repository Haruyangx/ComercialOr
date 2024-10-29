/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.DAO;

import Modelo.ConexionBD;
import Modelo.Stock;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class StockDAO implements IStockDAO {
    private final ConexionBD conexionBD;

    public StockDAO() {
        this.conexionBD = new ConexionBD();
    }

    @Override
    public List<Stock> obtenerStockConDetalles() {
        List<Stock> stockList = new ArrayList<>();
        String sql = "SELECT s.id, s.stock_disponible, p.nombre AS producto_nombre, " +
                     "c.nombre AS categoria_nombre, pr.nombre AS proveedor_nombre " +
                     "FROM stock s " +
                     "JOIN lista_productos p ON s.producto_id = p.id " +
                     "JOIN categorias c ON p.categoria_id = c.id " +
                     "JOIN proveedores pr ON p.proveedor_id = pr.id";

        try (Connection conn = conexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Crear el objeto Stock con la información requerida
                Stock stock = new Stock(
                    rs.getInt("id"),
                    rs.getString("producto_nombre"),
                    rs.getString("categoria_nombre"),
                    rs.getString("proveedor_nombre"),
                    rs.getInt("stock_disponible")
                );

                stockList.add(stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockList;
    }
}
