package practical;

public class Inheritance {
	public static void main(String[] args) {
		Animal generic = new Animal("Generic");
		generic.speak();
		Dog d = new Dog("Buddy", "Alice");
		d.speak();
		d.play();
		d.info();
		d.wagTail();
		
		Animal petAsAnimal = new Dog("Rex", "BOb");
		petAsAnimal.speak();
		
		if(petAsAnimal instanceof Pet) {
			((Pet) petAsAnimal).play();
		}
	}

}
