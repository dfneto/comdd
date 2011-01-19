class Dog {
	String name;

	public static void main (String[] args) {
		Dog dog1 = new Dog();
		dog1.bark();
		dog1.name = "Bart";

		Dog[] myDogs = new Dog[3];
		myDogs[0] = new Dog();
		myDogs[1] = new Dog();
		myDogs[2] = dog1;

		myDogs[0].name = "Freud";
		myDogs[1].name = "Marge";
		System.out.print("O nome do ultimo dog eh: " + myDogs[2].name + "\n");

		int x = 0;
		while (x < myDogs.length) {
			myDogs[x].bark();
			x++;
		}
	}

	public void bark() {
		System.out.println(name + " diz ruff!");
	}
}
