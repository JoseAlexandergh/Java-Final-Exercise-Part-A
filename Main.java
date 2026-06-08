/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.emply.main;

/**
 *
 * @author breaa
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        ArchivoCalificaciones archivo =
                new ArchivoCalificaciones();

        int opcion;

        do {

            System.out.println("\n====================================");
            System.out.println("COLEGIO DIOS ES BUENO");
            System.out.println("SISTEMA DE CALIFICACIONES");
            System.out.println("====================================");
            System.out.println("1- Registro de calificaciones");
            System.out.println("2- Reporte calificaciones");
            System.out.println("3- Salir");
            System.out.println("====================================");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = leer.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = leer.nextLine();

                    System.out.print("Matematica: ");
                    double mat = leer.nextDouble();

                    System.out.print("Lengua: ");
                    double len = leer.nextDouble();

                    System.out.print("Naturales: ");
                    double nat = leer.nextDouble();

                    System.out.print("Sociales: ");
                    double soc = leer.nextDouble();

                    leer.nextLine();

                    Estudiante est =
                            new Estudiante(
                                    nombre,
                                    apellido,
                                    mat,
                                    len,
                                    nat,
                                    soc
                            );

                    archivo.guardarEstudiante(est);

                    System.out.println("Registro guardado.");

                    break;

                case 2:

    ArrayList<Estudiante> lista =
            archivo.leerEstudiantes();

    System.out.println("\nREPORTE");

    for (Estudiante e : lista) {

        System.out.println(
                e.getNombre() + " " +
                e.getApellido() +
                " Promedio: " +
                e.calcularPromedio() +
                " Literal: " +
                e.obtenerLiteral()
        );
    }

    System.out.println(
            "Total estudiantes: " + lista.size());

    break;

                case 3:

                    System.out.println("Programa finalizado.");
                    break;

                default:

                    System.out.println(
                            "Opcion invalida.");
            }

        } while (opcion != 3);
    }
}
