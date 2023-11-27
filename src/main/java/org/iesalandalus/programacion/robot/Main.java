package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;

import javax.naming.OperationNotSupportedException;

public class Main {

    private ControladorRobot controladorRobot;

    public static void main(String[] args) {
        Main programa = new Main();
        int opcion;
        do {
            Consola.mostrarMenuPrincipal();
            opcion = Consola.elegirOpcion();
            programa.ejecutarOpcion(opcion);
        } while (true);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> {
                if (controladorRobot == null) {
                    System.out.println("Primero debes crear un robot");
                } else {
                    ejecutarComando();
                    Consola.mostrarRobot(controladorRobot.getRobot());
                }
            }
            case 6 -> Consola.despedirse();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
    }

    private void controlarRobotZona() {
        Zona zona = Consola.elegirZona();
        controladorRobot = new ControladorRobot(new Robot(zona));
    }

    private void controlarRobotZonaOrientacion() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        controladorRobot = new ControladorRobot(new Robot(zona, orientacion));
    }

    private void controlarRobotZonaOrientacionCoordenada() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        controladorRobot = new ControladorRobot(new Robot(zona, orientacion, coordenada));
    }

    private void ejecutarComando() {
        char comando = Consola.elegirComando();
        try {
            controladorRobot.ejecutar(comando);
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
