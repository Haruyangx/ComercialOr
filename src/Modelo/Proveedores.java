/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Proveedores {
    private int id;
    private String nombre;
    private String personaContacto; // Cambiado de numeroContacto a personaContacto

    public Proveedores(int id, String nombre, String personaContacto) {
        this.id = id;
        this.nombre = nombre;
        this.personaContacto = personaContacto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPersonaContacto() {
        return personaContacto; // Cambiado de getNumeroContacto a getPersonaContacto
    }
}
