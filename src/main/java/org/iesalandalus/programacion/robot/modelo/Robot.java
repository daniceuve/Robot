package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {

    private Coordenada coordenada;
    private Orientacion orientacion;
    private Zona zona;
    public Robot() {
        zona = new Zona();
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona) {
        this();
        this.zona = zona;
        this.coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this.zona = zona;
        this.orientacion = orientacion;
        this.coordenada = zona.getCentro();
    }
    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        this.zona = zona;
        this.orientacion = orientacion;
        this.coordenada = coordenada;
    }

    public Robot(Robot robot) {
        this(robot.zona, robot.orientacion, robot.coordenada);
    }

    public Zona getZona() {
        return zona;
    }
    private void setZona(Zona zona) {
        if (zona == null) {
            throw new NullPointerException("El valor no puede ser nulo");
        }

        this.zona = zona;

    }
    public Coordenada getCoordenada() {
        return coordenada;
    }
    private void setCoordenada(Coordenada coordenada) {
        if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("No puedes salirte de los límites.");
        }
        if (coordenada == null) {
            throw new NullPointerException("El valor no puede ser nulo");
        }

        this.coordenada = coordenada;
    }
    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void avanzar() {
        switch (getOrientacion()) {
            case NORTE -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() + 1));
            case NORESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() + 1));
            case ESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y()));
            case SURESTE -> setCoordenada(new Coordenada(coordenada.x() + 1, coordenada.y() - 1));
            case SUR -> setCoordenada(new Coordenada(coordenada.x(), coordenada.y() - 1));
            case SUROESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y()));
            case OESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y() - 1));
            case NOROESTE -> setCoordenada(new Coordenada(coordenada.x() - 1, coordenada.y() + 1));
        }
    }
    public void girarALaDerecha() {
        orientacion = switch (getOrientacion()) {
            case NORTE -> Orientacion.NORESTE;
            case NORESTE -> Orientacion.ESTE;
            case ESTE -> Orientacion.SURESTE;
            case SURESTE -> Orientacion.SUR;
            case SUR -> Orientacion.SUROESTE;
            case SUROESTE -> Orientacion.OESTE;
            case OESTE -> Orientacion.NOROESTE;
            case NOROESTE -> Orientacion.NORTE;
        };
    }
    public void girarALaIzquierda() {
        orientacion = switch (getOrientacion()) {
            case NORTE -> Orientacion.NOROESTE;
            case NORESTE -> Orientacion.NORTE;
            case ESTE -> Orientacion.NORESTE;
            case SURESTE -> Orientacion.ESTE;
            case SUR -> Orientacion.SURESTE;
            case SUROESTE -> Orientacion.SUR;
            case OESTE -> Orientacion.SUROESTE;
            case NOROESTE -> Orientacion.OESTE;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot robot)) return false;
        return Objects.equals(coordenada, robot.coordenada) && orientacion == robot.orientacion && Objects.equals(zona, robot.zona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, orientacion, zona);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "coordenada=" + coordenada +
                ", orientacion=" + orientacion +
                ", zona=" + zona +
                '}';
    }
}
