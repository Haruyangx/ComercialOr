/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.DAO;

import Modelo.Stock;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IStockDAO {
    List<Stock> obtenerStockConDetalles();
}
