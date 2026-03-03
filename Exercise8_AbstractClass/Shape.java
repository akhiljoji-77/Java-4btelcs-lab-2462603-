package practical;

public abstract class Shape {
	protected int a,b;
	public Shape(int a, int b) {
		this.a=a;
		this.b=b;
	}
	public abstract void printArea();
}
