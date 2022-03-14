package Class;
import java.util.Scanner;
public class Point {
	private double x, y ;

 
	public Point(double x, double y) {
		
		this.x = x;
		this.y = y;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}

	public String toString(){
		return "(" + x + ", " + y + ")"; 
	}

	public void move(double x, double y){
		this.x += x;
		this.y += y;
	}

	public void read(Scanner s){

		Scanner scan = s;
		
		double nx = scan.nextDouble();
		this.setX(nx);
		
		double ny = scan.nextDouble();
		this.setY(ny);
	}
 
 // TODO Print 
 // TODO TOSTRING 
// TODO SHIFT AND MOVE
// TODO OPERATOR 
// TODO READ
}
