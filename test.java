import java.util.*;

enum Suit{
	CLUB(0), DIAMOND(1), SPADE(2), HEART(3);
	
	int value;
	Suit(int value){
		this.value = value;
	}	

}

enum Level{
	LOW(1),MEDIUM(2),HIGH(3);
	//Unlike a., you let the compiler know about LOW(1) by provide constructor
	int value;
	Level(int value){
		this.value = value;
	} 
}

class test{
	public static void main(String args[]){
		Animal a = new Dog("William");
		a.getName(); 
		System.out.println(Suit.CLUB.value);	
		Level l = Level.HIGH;
		if(l.value>Level.LOW.value) System.out.println("l is higher    ");
		for(Level level: Level.values()){
			System.out.println(level + " with value " + level.value);
		}
	}
}

class Animal{
	private String name;
	
	public Animal(String name){
		this.name = name;
	}

	public void getName(){
		System.out.println(this.name);
	}

}

class Dog extends Animal{
	private String bark = "Woof";

	public Dog(String name){
		super(name);
	}	
	public void getBark(){
		System.out.println(this.bark);
	}
}
