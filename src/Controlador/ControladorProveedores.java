/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.DAO.IProveedoresDAO;
import Modelo.Proveedores;
import java.util.List;

public class ControladorProveedores {
    private final IProveedoresDAO proveedoresDAO;

    // Constructor que inicializa el DAO
    public ControladorProveedores(IProveedoresDAO proveedoresDAO) {
        this.proveedoresDAO = proveedoresDAO;
    }

    // Obtener la lista de proveedores
    public List<Proveedores> obtenerProveedores() {
        return proveedoresDAO.obtenerProveedores();
    }

    // Agregar un nuevo proveedor
    public void agregarProveedor(Proveedores nuevoProveedor) {
        proveedoresDAO.agregarProveedor(nuevoProveedor);
    }

    // Editar un proveedor existente
    public void editarProveedor(Proveedores proveedor) {
        proveedoresDAO.editarProveedor(proveedor);
    }

    // Eliminar un proveedor
    public void eliminarProveedor(int proveedorId) {
        proveedoresDAO.eliminarProveedor(proveedorId);
    }
}

