/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Categoria;
import Modelo.ConexionBD;
import Modelo.DAO.ICategoriaDAO;
import java.util.List;

public class ControladorCategoria {
    private final ICategoriaDAO categoriaDAO;

    // Constructor que recibe el DAO como dependencia
    public ControladorCategoria(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    // Método para obtener todas las categorías
    public List<Categoria> obtenerCategorias() {
        return categoriaDAO.obtenerCategorias();
    }

    // Método para agregar una nueva categoría
    public void agregarCategoria(Categoria categoria) {
        categoriaDAO.agregarCategoria(categoria);
    }

    // Método para editar una categoría existente
    public void editarCategoria(Categoria categoria) {
        categoriaDAO.editarCategoria(categoria);
    }

    // Método para eliminar una categoría
    public void eliminarCategoria(int categoriaId) {
        categoriaDAO.eliminarCategoria(categoriaId);
    }

    
}