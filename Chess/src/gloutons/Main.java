package gloutons;


public class Main {

    
    public static void main (String[] args){
    	
    /*Fist Test
    	Echiquier test= new Echiquier(5);
    	test.placerReine(2,1);
    	System.out.println(test.toString());
    	test.placerReine(3,1);
    	test.placerReine(4, 2);
    	System.out.println(test.toString());
    */
    	
    	//Algorithme Glouton
    	int taille=500;
    	Echiquier test= new Echiquier(taille);
    	test.placerReine(0,0);
    	System.out.println(test.toString());
    	 for (int x=0; x<taille ; x ++ ){
             for ( int y=0 ; y < taille ; y ++)
             {
            	 if(test.getCellule(x,y) == 0) {
            		test.placerReine(x,y);
            		
	             }
             } 
         }
    	 System.out.println(test.toString());
    	 
    	 
    	 
    	 //Algo optimis�
     	Echiquier test2= new Echiquier(taille);
     	int firstX, firstY;
     	firstX=(int)(Math.random()*((taille-1)+1))+0;
     	firstY=(int)(Math.random()*((taille-1)+1))+0;
     	System.out.println("X = "+ firstX +"   Y = "+ firstY);
     	test2.placerReine(firstX,firstY);
     //	test2.placerReine(58,32);
     	System.out.println(test2.toString());
     	 for (int x=0; x<taille ; x ++ ){
              for ( int y=0 ; y < taille ; y ++)
              {
             	 test2.bestPlace();
              } 
          }
     	System.out.println(test2.toString());
     	
    	 
    }

}
