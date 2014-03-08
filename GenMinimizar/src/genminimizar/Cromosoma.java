/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genminimizar;

import java.util.Random;

/**
 *
 * @author Pablo
 */
public class Cromosoma {
    double aptitud;
    int[] genes;
    boolean reproducir;
    public static int tamaño_genes = 30;
    double x,y;
    public Cromosoma(boolean aleatorio) {
        
         
        
        x=numaleatorio();
        y=numaleatorio();
        
 

    }

    void evaluar() {
         double numerador =(Math.pow(y,3)) + Math.pow(x,2) - (x*y);
         double denominador = Math.pow(x,2)-y;
         double f = numerador/denominador;
            aptitud = f;
 
                   
    }
    
    double numaleatorio(){
        double num;
    Random r = new Random();
        num =r.nextInt(80)*-1;
        num+=r.nextInt(80);
        num+=r.nextDouble();
        
        return num;
       
    }

}
