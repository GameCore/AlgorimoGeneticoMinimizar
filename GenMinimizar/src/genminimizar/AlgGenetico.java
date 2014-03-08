/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genminimizar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Pablo
 */ 
public class AlgGenetico {
    boolean haTerminado;
    public ArrayList<Cromosoma> poblacion;
    int tamaño_poblacion;
    public AlgGenetico(int tamaño_poblacion){
        this.tamaño_poblacion = tamaño_poblacion;
        poblacion = new ArrayList<Cromosoma>();
    }

    void inicializar_poblacion() {
        for(int i =0;i<tamaño_poblacion;i++){
            poblacion.add(GenerarCromosoma());
        
        }
    }

    void evaluar_poblacion() {
        for(int i = 0;i<poblacion.size();i++){
            poblacion.get(i).evaluar();            
        }
    }

    void seleccionar_poblacion() {
        
Collections.sort(poblacion,new ComparadorAptitud());
//burbujaPoblacion();        
Collections.reverse(poblacion);
//Collections.reverse(poblacion);


        
        
        for(int i = 0 ;i<1000;i++){
            poblacion.get(i).reproducir = true;
        }
    }

    void reproducir_poblacion() {
        double numAleatorio;
        Random r = new Random();
       numAleatorio = r.nextDouble();
        ArrayList<Cromosoma> aptosReproduccion = new ArrayList<Cromosoma>();
        for(Cromosoma e: poblacion){
            qi();
            if(e.reproducir){
        if(  qi()-1 < numAleatorio){
            if(numAleatorio < qi()){
            aptosReproduccion.add(e);
        } 
            
                
            }
        }
        /*for(int i =0;i<aptosReproduccion.size()-1;i++){
            Cromosoma a = poblacion.get(i);
            Cromosoma b = poblacion.get(i+1);
            Cromosoma hijo = reproducir(a,b);
            poblacion.add(hijo);
        }*/
        for(int i =0;i<aptosReproduccion.size();i++){
            for(int j = i+1;j<aptosReproduccion.size();j++){
                Cromosoma a = poblacion.get(i);
                Cromosoma b = poblacion.get(j);                
                Cromosoma hijo = reproducir(a,b);
                hijo.evaluar();
                poblacion.add(hijo);
            }
        }
    }
  }

    void mutar_poblacion() {
       
        Random condicion=new Random();
        for(Cromosoma e: poblacion){
     double condicion2 = condicion.nextDouble();
     int condicion1 = condicion.nextInt(49);
     double condicionAleatoria =condicion1+condicion2;

      if(e.x<79.9999 && e.y<79.9999 ){
          if(e.x>-79.9999 && e.y>-79.9999){
                
              if(e.x > condicionAleatoria){
                e.x+=0.0001;
                }
               else{
                 e.x-=0.0001;
                   }
     
           if(e.y > condicionAleatoria){ 
               e.y+=0.0001;
           }
           else{
           e.y-=0.0001;
           }
           
           
      }
     }     
    }
   }
    


    private Cromosoma GenerarCromosoma() {
        return new Cromosoma(true);
    }

    

    private Cromosoma reproducir(Cromosoma ana, Cromosoma beto) {
        Cromosoma hijo = new Cromosoma(false);

           hijo.x = (ana.x+beto.y)/2;
           return hijo;
    }

    void reemplazar_poblacion() {
        Random eliminar = new Random();
        int a; 
        
        
        while(poblacion.size() > 1000 ){
            a = poblacion.size();
            a=eliminar.nextInt(a);
            
            poblacion.remove(a);
        }
    }
   
    void burbujaPoblacion(){
  ArrayList<Cromosoma>  poblacionAux = new ArrayList<Cromosoma>();
        for(int i = 0; i< poblacion.size();i++){
            
            for(int j = 1+1;j<poblacion.size();j++){
                Cromosoma a = poblacion.get(i);
                Cromosoma b = poblacion.get(j);
                if(a.aptitud> b.aptitud ){
                   poblacionAux.add( a);
                    poblacion.set(i,b);
                    poblacion.set(j-1,a);
                   
          }
        }
      }
    }
    

    
    
    
    
    double qi(){
        double sumaDePi=0,qi=0;
        double numAleatorio,pi=0;
    
        
       for(Cromosoma e: poblacion){
   pi = e.aptitud / promedio();
        sumaDePi += pi;
        qi = sumaDePi;
        }
        return qi;
        }
        
        
        
    
 

  
    
    double promedio() {
         int i;
        double b = 0,a;
        double elementosTotales,promedio = 0;
        ArrayList<Cromosoma> seleccionRuleta = new ArrayList<Cromosoma>();
        
    for(Cromosoma e: poblacion){
       
    
            
          for(i=0;i<seleccionRuleta.size();i++){
        a = e.aptitud;
        b += a;
                
           
                
            }
         elementosTotales = seleccionRuleta.size();
         promedio = elementosTotales/b;
         
         
    }
    return promedio;
    }
}
    
    
    
    



