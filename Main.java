package com.emply.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        ArchivoCalificaciones archivo
                = new ArchivoCalificaciones();

        int opcion;

        do {

            System.out.println("COLEGIO DIOS ES BUENO");
            System.out.println("SISTEMA PARA LAS CALIFICACIONES");
            System.out.println("====================================");
            System.out.println("1- Registro de calificaciones");
            System.out.println("2- Reporte de calificaciones");
            System.out.println("3- Salir del programa");
            System.out.println("====================================");

            try {

                opcion = leer.nextInt();
                leer.nextLine();

            } catch (Exception e) {

                System.out.println("Debe ingresar una opcion valida.");
                leer.nextLine();
                opcion = 0;
                continue;
            }

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = leer.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = leer.nextLine();

                    System.out.print("Curso: ");
                    String curso = leer.nextLine();

                    System.out.print("Grupo: ");
                    String grupo = leer.nextLine();

                    System.out.print("Mes: ");
                    String mes = leer.nextLine();

                    double mat = leerNota(leer, "Matematica");
                    double len = leerNota(leer, "Lengua");
                    double nat = leerNota(leer, "Naturales");
                    double soc = leerNota(leer, "Sociales");

                    leer.nextLine();

                    Estudiante est
                            = new Estudiante(
                                    nombre,
                                    apellido,
                                    curso,
                                    grupo,
                                    mes,
                                    mat,
                                    len,
                                    nat,
                                    soc
                            );

                    archivo.guardarEstudiante(est);

                    System.out.println("Registro guardado.");

                    break;

                case 2:

                    ArrayList<Estudiante> lista
                            = archivo.leerEstudiantes();

                    if (lista.isEmpty()) {

                        System.out.println("No hay estudiantes registrados.");
                        break;
                    }

                    System.out.print("Ingrese el grupo: ");
                    String grupoBuscado = leer.nextLine();

                    boolean encontrado = false;
                    int totalGrupo = 0;
                    for (Estudiante e : lista) {

                        if (e.getGrupo().equalsIgnoreCase(grupoBuscado)) {
                            totalGrupo++;

                            encontrado = true;

                            System.out.println("========================================================");

                            System.out.println(
                                    "Nombre | Apellido | Curso | Grupo | Mes");

                            System.out.println(
                                    e.getNombre() + " | "
                                    + e.getApellido() + " | "
                                    + e.getCurso() + " | "
                                    + e.getGrupo() + " | "
                                    + e.getMes());

                            System.out.println();

                            System.out.println(
                                    "Matematica | Lengua | Naturales | Sociales");

                            System.out.println(
                                    e.getMatematica() + " | "
                                    + e.getLengua() + " | "
                                    + e.getNaturales() + " | "
                                    + e.getSociales());

                            System.out.println();

                            System.out.println(
                                    "Promedio | Literal");

                            System.out.println(
                                    String.format("%.2f",
                                            e.calcularPromedio())
                                    + " | "
                                    + e.obtenerLiteral());

                            System.out.println("========================================================");
                        }
                    }

                    if (!encontrado) {

                        System.out.println(
                                "No se encontraron estudiantes en el grupo "
                                + grupoBuscado);
                    }

                    if (encontrado) {

                        System.out.println(
                                "\nTotal estudiantes del grupo "
                                + grupoBuscado + ": "
                                + totalGrupo);
                    }

                    break;

                case 3:

                    System.out.println("El programa ha finalizado.");
                    break;

                default:

                    System.out.println(
                            "Opcion invalida.");
            }

        } while (opcion != 3);
    }

    public static double leerNota(Scanner leer, String materia) {

        while (true) {

            try {

                System.out.print(materia + ": ");
                double nota = leer.nextDouble();

                if (nota < 0 || nota > 100) {

                    System.out.println(
                            "La nota debe estar entre el numero 0 y 100.");
                    continue;
                }

                return nota;

            } catch (Exception e) {

                System.out.println(
                        "Error. Debe de ingresar un numero.");

                leer.nextLine();
            }
        }
    }
}
