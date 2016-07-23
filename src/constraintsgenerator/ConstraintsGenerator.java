/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraintsgenerator;

import java.util.Scanner;

/**
 *
 * @author nico
 */
public class ConstraintsGenerator
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Nombre de la Tabla 1: ");
        String nombreTabla1 = scaner.nextLine();
        
        System.out.print("Nombre de la Tabla 2: ");
        String nombreTabla2 = scaner.nextLine();
        
        String nombreFK = parsearFK(nombreTabla2);
        System.out.print("Nombre FK (" +nombreFK +"):");
        String entradaAuxNombreFK = scaner.nextLine();
        
        if(entradaAuxNombreFK.trim().length() > 0)
        {
            nombreFK = entradaAuxNombreFK;
        }
        
        
        
        System.out.println("ALTER TABLE `"+nombreTabla1+"` ADD CONSTRAINT `" + nombreTabla1 + "->" + nombreTabla2 + "` FOREIGN KEY (`" + nombreFK + "`) REFERENCES `" + nombreTabla1 + "`(`id`) ON DELETE RESTRICT ON UPDATE CASCADE");
    }

    private static String parsearFK(String nombreTabla2)
    {
        String nombreFK;
        String primerCaracter = "" +nombreTabla2.charAt(0);
        primerCaracter = primerCaracter.toUpperCase();
        nombreFK = "fk" + primerCaracter + nombreTabla2.substring(1,nombreTabla2.length());
        return nombreFK;
    }
    
}
