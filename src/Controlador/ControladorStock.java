/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.DAO.IStockDAO;
import Modelo.Stock;
import java.util.List;
/**
 *
 * @author USER
 */
public class ControladorStock {
    private final IStockDAO stockDAO;

    public ControladorStock(IStockDAO stockDAO) {
        this.stockDAO = stockDAO; // Inyectamos la dependencia
    }

    public List<Stock> obtenerStockConDetalles() {
        return stockDAO.obtenerStockConDetalles(); // Delegamos al DAO
    }
}
