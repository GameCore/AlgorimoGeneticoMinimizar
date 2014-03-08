/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genminimizar;

/**
 *
 * @author Pablo
 */
public class ClasePrincipal {
    
    public static void main(String[] args) {
        AlgGenetico ag = new AlgGenetico(1000);
        ag.inicializar_poblacion();
        System.out.println("inicializar_poblacion()");
        int numero_generaciones = 1;
        while(numero_generaciones <= (ag.tamaño_poblacion*.70/100)){
            ag.evaluar_poblacion();
            System.out.println("evaluar_poblacion()");
            ag.seleccionar_poblacion();
            System.out.println("seleccionar_poblacion()");
            ag.reproducir_poblacion();
            System.out.println("reproducir_poblacion()");
            ag.mutar_poblacion();
            System.out.println("mutar_poblacion()");
            ag.evaluar_poblacion();
            System.out.println("evaluar_poblacion()");
            ag.reemplazar_poblacion();
            System.out.println("reemplazar_poblacion()");
            numero_generaciones++;
        }    
        for(Cromosoma e: ag.poblacion)
            imprimir(e);
    }

    private static void imprimir(Cromosoma cromosoma) {
        System.out.printf("aptitud: %f\n , x:%f, y:%f",cromosoma.aptitud, cromosoma.x,cromosoma.y);     
        
        System.out.println();
    }
}
