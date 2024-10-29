/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.DAO;

import Modelo.Categoria;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ICategoriaDAO {
    List<Categoria> obtenerCategorias();
    void agregarCategoria(Categoria categoria);
    void editarCategoria(Categoria categoria);
    void eliminarCategoria(int categoriaId);
}
