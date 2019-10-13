package gloutons;
import java.util.ArrayList;

public class Echiquier {
    
    private Cellule[][] echiquier ; 
    private int taille ; 
    private int nbReines;
    private ArrayList<Integer> tabX;
    private ArrayList<Integer> tabY;
    
    public Echiquier (int taille) {
        this.taille = taille ;
        echiquier = new Cellule[taille][taille];
        intialiserEchequier();
        nbReines=0;
        tabX = new ArrayList<Integer>();
        tabY = new ArrayList<Integer>();
    }
    
    public void intialiserEchequier() {
        
        for (int x=0; x<taille ; x ++ ){
        	this.tabX.add(x);
        	this.tabY.add(x);
            for ( int y=0 ; y < taille ; y ++)
            {
                echiquier[x][y]= new Cellule (x,y);
            }
        }
    }
    
    public void modifierCellule(int x, int y, int valeur){
        echiquier[x][y].setTypeOccupation(valeur);
    }
    
    public int getCellule(int x, int y){
    	 return echiquier[x][y].getTypeOccupation();
       
    }
    
    public void placerReine (int x, int y){
        if (echiquier[x][y].getTypeOccupation()== 0) {
            //marquer la ligne
            for ( int i=0 ; i < taille ; i ++)
            {
            	if(echiquier[i][y].getTypeOccupation()== 0) {
            		echiquier[i][y].setTypeOccupation(2);
            	}
            }
            //marquer la colonne
            for ( int i=0 ; i < taille ; i ++)
            {
            	if(echiquier[x][i].getTypeOccupation()== 0) {
            		echiquier[x][i].setTypeOccupation(2);   //marquer la colonne
            	}
                
                //Marquer les diagonales bas droite
                if (x+i<taille && y+i<taille && echiquier[x+i][y+i].getTypeOccupation()== 0 ){
                    echiquier[x+i][y+i].setTypeOccupation(2);
                }

                //Marquer les diagonales bas gauche
                if (x-i>=0 && y+i<taille && echiquier[x-i][y+i].getTypeOccupation()== 0 ){
                    echiquier[x-i][y+i].setTypeOccupation(2);
                }

                //Marquer les diagonales haut gauche
                if (x-i>=0 && y-i>=0 && echiquier[x-i][y-i].getTypeOccupation()== 0 ){
                    echiquier[x-i][y-i].setTypeOccupation(2);
                }

                //Marquer les diagonales haut droite
                if (x+i<taille && y-i>=0 && echiquier[x+i][y-i].getTypeOccupation()== 0 ){
                    echiquier[x+i][y-i].setTypeOccupation(2);
                }

            }
            
            //Placement de la Reine
            echiquier[x][y].setTypeOccupation(1);
            nbReines++;
            
          } else{
            System.out.println("Vous ne pouvez pas y placer une Reine");
        }
    }
    
    
    public void bestPlace(){
        int compteurMarquage;
        int minimumMenaces=taille*taille;
        int reineX=taille+1, reineY=taille+1;
        for (int x=0; x<taille ; x ++ ){
            for ( int y=0 ; y < taille ; y ++)
            {
            	compteurMarquage=0;
            	if(echiquier[x][y].getTypeOccupation()== 0) {
		            //marquer la ligne
		            for ( int i=0 ; i < taille ; i ++)
		            {
		            	if(echiquier[i][y].getTypeOccupation()== 0) {
		            		compteurMarquage++;
		            	}
		            }
		            //marquer la colonne
		            for ( int i=0 ; i < taille ; i ++)
			            {
		            	//marquer la colonne
		            	if(echiquier[x][i].getTypeOccupation()== 0) {
		            		compteurMarquage++;
		            	}
		                
		                //Marquer les diagonales bas droite
		                if (x+i<taille && y+i<taille && echiquier[x+i][y+i].getTypeOccupation()== 0 ){
		                    compteurMarquage++;
		                }
		                
		
		                //Marquer les diagonales bas gauche
		                if (x-i>=0 && y+i<taille && echiquier[x-i][y+i].getTypeOccupation()== 0){
		                    compteurMarquage++;
		                }
		
		                //Marquer les diagonales haut gauche
		                if (x-i>=0 && y-i>=0 && echiquier[x-i][y-i].getTypeOccupation()== 0){
		                    compteurMarquage++;
		                }
		
		                //Marquer les diagonales haut droite
		                if (x+i<taille && y-i>=0 && echiquier[x+i][y-i].getTypeOccupation()== 0){
		                    compteurMarquage++;
		                }
		            }

                   // System.out.println(" min="+minimumMenaces);
                   // System.out.println(" Marquage="+compteurMarquage);
                    
                    if(compteurMarquage < minimumMenaces) {
                		minimumMenaces=compteurMarquage;
                    	reineX=x;
                    	reineY=y;
                    	
                    }
	            }
            	
            }
        }
        if(reineX != taille+1 && reineY !=taille+1) {
        	//System.out.println("Woupsi!! 	x="+reineX+"    y="+reineY+" et le marquage="+compteurMarquage);
        	this.placerReine(reineX, reineY);
        }
    }
    
    
    public String toString(){
        super.toString();
        String visuel="nombre de Reines = "+nbReines+"\n";
/*         for (int x=0; x<taille ; x ++ ){
            for ( int y=0 ; y < taille ; y ++)
            {
            	if(echiquier[x][y].getTypeOccupation() == 0) {
            		visuel=visuel+"|   |";
            	}else if(echiquier[x][y].getTypeOccupation() == 1){
            		visuel=visuel+"| R |";
            	}else {
            		visuel=visuel+"| X |";
            	}
            }
            visuel=visuel+"\n"; 
        }		*/
        return(visuel);			
    }
    
    
    

}
