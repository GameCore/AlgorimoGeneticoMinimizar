/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genminimizar;

import java.util.Comparator;

/**
 *
 * @author Pablo
 */
public class ComparadorAptitud implements Comparator<Cromosoma> {
    
    @Override
    public int compare(Cromosoma o1, Cromosoma o2) {
        if(o1.aptitud > o2.aptitud)
        return 1;
        
        else if(o1.aptitud < o2.aptitud)
            return -1;
        
        else
            return 0;
    }
}

 
