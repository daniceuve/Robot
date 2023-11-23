package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private ControladorRobot controladorRobot;
    private Orientacion orientacion;
    private Coordenada coordenada;
    private Zona zona;
    private Robot robot;

    private Consola() {

        robot = new Robot();

    }

    public void mostrarMenuPrincipal() {
        System.out.println("-------------------------------Menú-------------------------------");
        System.out.println("Elija entre las siguientes ópciones: ");
        System.out.println("1 - Controlar un robot por defecto");
        System.out.println("2 - Crear un robot con una zona");
        System.out.println("3 - Crear un robot con una zona y orientación");
        System.out.println("4 - Crear un robot con una zona, orientación y coordenada inicial");
        System.out.println("5 - Ejecutar comando");
        System.out.println("6 - Salir");
        System.out.println("------------------------------------------------------------------");
    }

    public int elegitOpcion() {

        mostrarMenuPrincipal();

        int opcion;
        do {
            System.out.print("\nOpción: ");
            opcion = Entrada.entero();
        } while (opcion <= 0 || opcion > 6);

        return opcion;
    }

    public Zona elegirZona() {



    }




}
