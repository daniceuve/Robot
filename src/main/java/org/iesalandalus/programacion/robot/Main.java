package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;

import javax.naming.OperationNotSupportedException;

public class Main {

    private static  ControladorRobot controladorRobot;

    public static void main(String[] args) {
        int opcion;
        do {
            Consola.mostrarMenuPrincipal();
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
            Consola.mostrarRobot(controladorRobot);
        } while (opcion != 6);
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            case 6 -> Consola.despedirse();
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
    }

    private static void controlarRobotZona() {
        Zona zona = Consola.elegirZona();
        controladorRobot = new ControladorRobot(new Robot(zona));
    }
    private static void controlarRobotZonaOrientacion() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        controladorRobot = new ControladorRobot(new Robot(zona, orientacion));
    }
    private static void controlarRobotZonaOrientacionCoordenada() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        controladorRobot = new ControladorRobot(new Robot(zona, orientacion, coordenada));
    }
    private static void ejecutarComando() {
        char comando = Consola.elegirComando();
        try {
            controladorRobot.ejecutar(comando);
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
