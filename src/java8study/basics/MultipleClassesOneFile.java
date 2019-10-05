package java8study.basics;

public class MultipleClassesOneFile {

	public static void main(String[] args) {
		new SecondClass();
	}

}

class SecondClass{
	public SecondClass() {
		System.out.println("Calling the second class");
	}
}