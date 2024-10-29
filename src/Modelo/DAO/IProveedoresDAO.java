/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Proveedores;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IProveedoresDAO {
    List<Proveedores> obtenerProveedores();
    void agregarProveedor(Proveedores nuevoProveedor);
    void editarProveedor(Proveedores proveedor);
    void eliminarProveedor(int proveedorId);
}
