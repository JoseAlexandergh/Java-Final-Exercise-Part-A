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
                    e.getNombre() + "," +
                    e.getApellido() + "," +
                    e.getMatematica() + "," +
                    e.getLengua() + "," +
                    e.getNaturales() + "," +
                    e.getSociales()
            );

            pw.close();

        } catch (IOException ex) {

            System.out.println("Error guardando archivo");

        }
    }

    public ArrayList<Estudiante> leerEstudiantes() {

        ArrayList<Estudiante> lista =
                new ArrayList<>();

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(ARCHIVO));

            String linea;

            while ((linea = br.readLine()) != null) {

                String datos[] = linea.split(",");

                Estudiante e =
                        new Estudiante(
                                datos[0],
                                datos[1],
                                Double.parseDouble(datos[2]),
                                Double.parseDouble(datos[3]),
                                Double.parseDouble(datos[4]),
                                Double.parseDouble(datos[5])
                        );

                lista.add(e);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("Error leyendo archivo");

        }

        return lista;
    }
}
