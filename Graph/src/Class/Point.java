package Class;
import java.util.Scanner;
public class Point {
	private double x, y ;


//----------  constructors-----------------------
	public Point(double x, double y) {
		
		this.x = x;
		this.y = y;
	}

//---------- End of constructors-----------------------
//-------------------------Getter ----------------------------
	public double getX() {
		return x;
	}


	public double getY() {
		return y;
	}
	//------------------- End of Getter-----------------------
//-----------------------Setter--------------------------------
	public void setY(double y) {
		this.y = y;
	}
	public void setX(double x) {
		this.x = x;
	}
//------------------- End of Setter-----------------------
//-------------------- Methods  -----------------------
	public String toString(){
		return "(" + x + ", " + y + ")"; 
	}

	
	public void move(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	
	
	
	public void schift(double x, double y){
		this.x += x;
		this.y += y;
	}
	
//TODO check si on ecrit (2,3) marche bien 
	public void read(Scanner s){

		Scanner scan = s;
		
		double nx = scan.nextDouble();
		this.setX(nx);
		
		double ny = scan.nextDouble();
		this.setY(ny);
	}
	
//TODO imprimer dans fichier 
	public void print(){

		System.out.println(toString());
	}
 

}
