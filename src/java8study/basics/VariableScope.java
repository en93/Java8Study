package java8study.basics;

public class VariableScope {
	
	public static void main(String[] args) {
		new CorrectUsage();
	}
	
	// Will demonstrate class, method, loop, bracket and variable shadowing in scope
	public static class CorrectUsage{
		String classScoped = "classScoped";
		String variableShadowing = "variableShadowing";
		public CorrectUsage() {
			System.out.println("------------------");
			System.out.println("CorrectUsage");
			System.out.println("------------------");
			String methodScoped = "methodScoped";
			for (int i = 0; i < 1; i++) {
				String loopScope = "loopScope";
				{
					String bracketScope = "bracketScope";
					String variableShadowing = "variableShadowing shadowed";

					//Show expected values are here
					System.out.println("classScoped is " + classScoped);
					System.out.println("variableShadowing is " + variableShadowing);
					System.out.println("methodScoped is " + methodScoped);
					System.out.println("loopScope is " + loopScope);
					System.out.println("bracketScope is " + bracketScope);
				}
			}
		}
	}
}
