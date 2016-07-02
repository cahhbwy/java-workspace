package chap6;

public class DynamicMethodDemo2 {

	public static void main(String[] args) {
		Animal4[] animal=new Animal4[3];
		animal[0]=new Animal4();
		animal[1]=new Tiger4();
		animal[2]=new Fish4();
		DynamicMethodDemo2 dm=new DynamicMethodDemo2();
		dm.move(animal[0]);
		dm.move(animal[1]);
		dm.move(animal[2]);
	}
	void move(Animal4 animal){
		if(animal instanceof Tiger4)
			((Tiger4)animal).tigerRun();
		else if(animal instanceof Fish4)
			((Fish4)animal).swim();
		else
			animal.sleep();
	}
}
