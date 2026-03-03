package practical;

public class ShapeDemo {
	public static void main(String args[]) {
		System.out.println("Register number: 2462603");
		Shape r=new Rectangle(5,3);
		Shape t=new Triangle(4,5);
		Shape c=new Circle(3,0);
		r.printArea();
		t.printArea();
		c.printArea();
	}

}
