import java.util.*;

//You need to build an animal shelter, where there are dogs and cats. People can only adopt the oldest animal there. However, they are allowed to choose cat or dog. 


//Abstract class animal. 
abstract class Animal{
	protected String name;
	private int order; //this is the number assigned when animals are enqueued. Smaller order -> older animal. 
		
	public Animal(String name){
		this.name = name;
	}

	public int getOrder(){
		return this.order;
	}
		
	public void setOrder(int v){
		this.order = v;
	}
	
	public boolean isOlder(Animal a){
		return this.order<a.getOrder();
	} 
}

class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}

class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}

public class shelter{
	private LinkedList<Dog> dogList;
	private LinkedList<Cat> catList;
	private int timeStamp;

	public shelter(){
		this.dogList = new LinkedList<Dog>();
		this.catList = new LinkedList<Cat>();
		this.timeStamp = 0;
	}

	//use one enqueue function for two different animals. 
	public void enqueue(Animal a){
		a.setOrder(this.timeStamp);
		this.timeStamp++;
		if(a instanceof Dog){
			this.dogList.add((Dog) a);
		}else{
			this.catList.add((Cat) a);
		}
	}

	public Cat dequeueCat(){
		try{
			return this.catList.removeFirst();
		}catch(Exception e){
			System.out.println("Hey we don't have any cat left in this shelter.");
			return null;
		}
	}

	public Dog dequeueDog(){
		try{
			return this.dogList.removeFirst();
		}catch(Exception e){
			System.out.println("Hey we don't have any dog left in this shelter");
			return null;
		}
	}
		
	public Animal dequeueAny(){
		Dog d = new Dog("");
		Cat c = new Cat("");
		boolean hasDog = true, hasCat = true;
		try{
			d = this.dogList.getFirst();
		}catch(NoSuchElementException e){
			hasDog = false;
		}
	
		try{
			c = this.catList.getFirst();
		}catch(NoSuchElementException e){
			hasCat = false;
		}
		
		if(!hasDog&&!hasCat){
			System.out.println("Hey, we no longer has any animal left!");
			return d;
		}

		if(!hasDog){
			return this.dequeueCat();
		}

		if(!hasCat){
			return this.dequeueDog();
		}

		if(d.isOlder(c)){
			return this.dequeueDog();
		}else{
			return this.dequeueCat();
		}
	}
	
	public static void main(String args[]){
		Dog a = new Dog("D1");
		Dog b = new Dog("D2");
		Dog c = new Dog("D3");
		
		Cat x = new Cat("C1");
		Cat y = new Cat("C2");

		shelter s = new shelter();
	
		s.enqueue(a);
		s.enqueue(b);
		s.enqueue(c);
		s.enqueue(x);
		s.enqueue(y);
		System.out.println(s.dequeueDog().name);
		System.out.println(s.dequeueCat().name);
		System.out.println(s.dequeueAny().name);
		System.out.println(s.dequeueDog().name);
		System.out.println(s.dequeueAny().name);
		System.out.println(s.dequeueAny().name);
		System.out.println(s.dequeueAny().name);
		
	}			


}
