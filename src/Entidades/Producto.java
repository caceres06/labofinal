/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Mabel
 */
public class Producto {
    private int id;
    private String nombre;
    private int idCategoria;
    private String nombre_categoria; 
    private float precioUni;
    private int existencia;

    public Producto() {
    }

    public Producto(int id, String nombre, int idCategoria, float precioUni, int existencia) {
        this.id = id;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.precioUni = precioUni;
        this.existencia = existencia;
    }
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public float getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(float precioUni) {
        this.precioUni = precioUni;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
}
