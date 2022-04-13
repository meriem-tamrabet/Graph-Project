package Class;
import java.util.Scanner;
public class Point {
	private int x, y ;


//----------  constructors-----------------------
	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

//---------- End of constructors-----------------------
//-------------------------Getter ----------------------------
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	//------------------- End of Getter-----------------------
//-----------------------Setter--------------------------------
	public void setY(int y) {
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
//------------------- End of Setter-----------------------
//-------------------- Methods  -----------------------
	public String toString(){
		return "(" + x + ", " + y + ")"; 
	}

	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	
	
	public void schift(int x, int y){
		this.x += x;
		this.y += y;
	}
	
//TODO check si on ecrit (2,3) marche bien 
	public void read(Scanner s){

		Scanner scan = s;
		
		int nx = scan.nextInt();
		this.setX(nx);
		
		int ny = scan.nextInt();
		this.setY(ny);
	}
	
//TODO imprimer dans fichier 
	public void print(){

		System.out.println(toString());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point p = (Point) obj ; 
		return p.x ==this.x && p.y ==this.y;
	}
 

}

