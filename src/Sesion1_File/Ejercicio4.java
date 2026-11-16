package Sesion1_File;

import java.io.File;

public class Ejercicio4 {
    public static void main(String[] args) {
        File simple = new File("copias");
        if (simple.mkdir())
            System.out.println("mkdir(): carpeta " + simple.getPath() + " creada");
        else
            System.out.println("mkdir(): carpeta " + simple.getPath() + " no creada (ya existe)");

        File multinivelMkdir = new File("copias/2026/noviembre");
        if (multinivelMkdir.mkdir())
            System.out.println("mkdir(): carpeta " + multinivelMkdir.getPath() + " creada");
        else
            System.out.println("mkdir(): carpeta " + multinivelMkdir.getPath() + " no creada");

        File multinivel = new File("copias/2026/noviembre/semana3");
        if (multinivel.mkdirs())
            System.out.println("mkdirs(): carpeta " + multinivel.getPath() + " creada");
        else
            System.out.println("mkdirs(): carpeta " + multinivel.getPath() + " no creada (ya existe)");
    }
}
