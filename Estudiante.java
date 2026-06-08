/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emply.main;

/**
 *
 * @author breaa
 */
public class Estudiante {

    private String nombre;
    private String apellido;
    private double matematica;
    private double lengua;
    private double naturales;
    private double sociales;

    public Estudiante(String nombre, String apellido,
                      double matematica, double lengua,
                      double naturales, double sociales) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.matematica = matematica;
        this.lengua = lengua;
        this.naturales = naturales;
        this.sociales = sociales;
    }

    public double calcularPromedio() {

        try {
            return (matematica + lengua +
                    naturales + sociales) / 4;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    public String obtenerLiteral() {

        double promedio = calcularPromedio();

        if (promedio >= 90)
            return "A";
        else if (promedio >= 80)
            return "B";
        else if (promedio >= 70)
            return "C";
        else
            return "D";
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getMatematica() {
        return matematica;
    }

    public double getLengua() {
        return lengua;
    }

    public double getNaturales() {
        return naturales;
    }

    public double getSociales() {
        return sociales;
    }
}
