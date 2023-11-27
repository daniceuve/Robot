package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import org.iesalandalus.programacion.utilidades.Entrada;


public class Consola {

    private Consola() {

    }

    public static void mostrarMenuPrincipal() {
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

    public static int elegirOpcion() {
        int opcion = 0;
        do {
            try {
                System.out.print("Elige una opción del menú: ");
                opcion = Entrada.entero();
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida." + e.getMessage());
            }
        } while (opcion < 1 || opcion > 6);
        return opcion;
    }

    public static Zona elegirZona() {
        int ancho, alto;
        do {
            System.out.print("Introduce el ancho de la zona: ");
            ancho = Entrada.entero();
            System.out.print("Introduce el alto de la zona: ");
            alto = Entrada.entero();
        } while (ancho < Zona.ANCHO_MINIMO || ancho > Zona.ANCHO_MAXIMO ||
                alto < Zona.ALTO_MINIMO || alto > Zona.ALTO_MAXIMO);
        return new Zona(ancho, alto);
    }

    public static void mostrarMenuOrientacion() {
        System.out.println("Menú de Orientaciones:");
        System.out.println(Arrays.toString(Orientacion.values()));
    }

    public static Orientacion elegirOrientacion() {
        int opcion = 0;
        do {
            mostrarMenuOrientacion();
            try {
                System.out.print("Elige una orientación del menú: ");
                opcion = Entrada.entero();
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Debe ser un número.");
            }
        } while (opcion < 1 || opcion > 8);
        return Orientacion.values()[opcion];
    }

    public static Coordenada elegirCoordenada() {
        System.out.print("Introduce la coordenada X: ");
        int x = Entrada.entero();
        System.out.print("Introduce la coordenada Y: ");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static char elegirComando() {
        System.out.print("Elige el comando a ejecutar (A/D/I): ");
        return Entrada.caracter();
    }

    public static void mostrarRobot(Robot robot) {
        if (robot != null) {
            System.out.println("Información del Robot:");
            System.out.println(robot);
        } else
            System.out.println("El robot es nulo.");

    }

    public static void despedirse() {
        System.out.println("¡Hasta luego! Gracias por usar nuestra aplicación.");
        System.exit(0);
    }
}
