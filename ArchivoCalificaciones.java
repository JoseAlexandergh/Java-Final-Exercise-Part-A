/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emply.main;

/**
 *
 * @author breaa
 */
import java.io.*;
import java.util.ArrayList;

public class ArchivoCalificaciones {

    private final String ARCHIVO = "calificaciones.txt";

    public void guardarEstudiante(Estudiante e) {

        try {

            FileWriter fw = new FileWriter(ARCHIVO, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(
                    e.getNombre() + ","
                    + e.getApellido() + ","
                    + e.getCurso() + ","
                    + e.getGrupo() + ","
                    + e.getMes() + ","
                    + e.getMatematica() + ","
                    + e.getLengua() + ","
                    + e.getNaturales() + ","
                    + e.getSociales()
            );

            pw.close();

        } catch (IOException ex) {

            System.out.println("Error guardando archivo.");
        }
    }

    public ArrayList<Estudiante> leerEstudiantes() {

        ArrayList<Estudiante> lista
                = new ArrayList<>();

        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {

            return lista;
        }

        try {

            BufferedReader br
                    = new BufferedReader(
                            new FileReader(ARCHIVO));

            String linea;

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String datos[] = linea.split(",");

                if (datos.length < 9) {
                    continue;
                }

                Estudiante e
                        = new Estudiante(
                                datos[0], // nombre
                                datos[1], // apellido
                                datos[2], // curso
                                datos[3], // grupo
                                datos[4], // mes
                                Double.parseDouble(datos[5]),
                                Double.parseDouble(datos[6]),
                                Double.parseDouble(datos[7]),
                                Double.parseDouble(datos[8])
                        );

                lista.add(e);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("No hay registros para mostrar.");

        } catch (Exception e) {

            System.out.println("Error en los datos del archivo.");
        }

        return lista;
    }
}
