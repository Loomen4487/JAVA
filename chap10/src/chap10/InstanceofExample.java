package chap10;

public class InstanceofExample {
	// 부모 클래스를 자식 클래스 강제형변환을 안전하게 리턴하는 메소드
	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
	}
	
	public static void changeDog(Animal animal) {
		
		Dog dog = (Dog) animal;
		
	}
}

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}