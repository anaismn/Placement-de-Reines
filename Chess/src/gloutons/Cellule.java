package gloutons;

public class Cellule {
    private int x ; 
    private int y ; 
    
    private int typeOccupation ; // libre , reine , menac�e par une reine
    
    final static int LIBRE = 0 ;
    final static int REINE = 1; 
    final static int MENACEE = 2 ;
    
    public Cellule (int x, int y) {
        
        this.x= x ;
        this.y = y ; 
        this.typeOccupation = LIBRE;
    }
    
     public int getx() {
    return x;
  }
      public int gety() {
    return y;
  }
       public int getTypeOccupation() {
    return typeOccupation;
  }
       
       public void setx(int newX) {
    this.x = newX;
  }
        public void sety(int newY) {
    this.y = newY;
  }
         public void setTypeOccupation(int newTypeOccupation) {
    this.typeOccupation = newTypeOccupation;
  }
}
