package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;
import java.util.Random;

public record Zona(int ancho, int alto) {

    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;
    public static final int NUMERO_MINIMO_OBSTACULOS = 4;
    public static final int NUMERO_MAXIMO_OBSTACULOS = 24;
    private static char[][] obstaculos;
    private static Random obstaculosRandom;

    public Zona {
        validarAlto(alto);
        validarAncho(ancho);
        obstaculosRandom = new Random();
        obstaculos = new char[NUMERO_MAXIMO_OBSTACULOS][NUMERO_MAXIMO_OBSTACULOS];
        for ()
    }
    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO);
    }
    public void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO)
            throw new IllegalArgumentException("Ancho no válido.");
    }
    public void validarAlto(int alto) {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO )
            throw new IllegalArgumentException("Alto no válido.");
    }
    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }
    public boolean pertenece(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        return perteneceX(coordenada.x()) && perteneceY(coordenada.y());
    }

    private boolean perteneceX(int x) {
        return (x >= 0 && x < ancho);
    }
    private boolean perteneceY(int y) {
        return (y >= 0 && y < alto);
    }

}
