package org.iesalandalus.programacion.robot.modelo;

public enum Orientacion {
    NORTE("Norte"),
    NOROESTE("Noroeste"),
    OESTE("Oeste"),
    SUROESTE("Suroeste"),
    SUR("Sur"),
    SURESTE("Sureste"),
    ESTE("Este"),
    NORESTE("Noreste");

    private String nombre;

    private Orientacion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }
}
