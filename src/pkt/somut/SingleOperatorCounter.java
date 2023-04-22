/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* Tekli operatör sınıfı
* </p> */

package pkt.somut;

import pkt.soyut.OperatorCounter;

public class SingleOperatorCounter  extends OperatorCounter{
    private static final String[] SINGLE_OPERATORS = {
    		 "\\+\\+",
    		 "(?<!\\p{L})!(?!=)",//! işaretini alır ama != ifadesini almaz
    		    "--",
    		   
    	
    	    
        };

	@Override
	public String[] getOperators() {
		// TODO Auto-generated method stub
		return SINGLE_OPERATORS;
	}

	
       
}
    