package practical;

public class Animal {
	protected String name;
	public Animal(String name) {
		this.name = name;
	}
	public void speak() {
		System.out.println(name + " makes a sound. ");
	}
	public void info() {
		System.out.println("This is an animal named " + name );
	}
}
