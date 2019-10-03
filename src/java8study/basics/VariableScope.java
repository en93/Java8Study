package java8study.basics;

public class VariableScope {

	public static void main(String[] args) {
		new CorrectUsage();
		new ClassScope();
		new MethodScope();
		new LoopScope();
		new BracketScope();
	}
	
	
	public static class CorrectUsage{
		// Will demonstrate class, method, loop, bracket and variable shadowing in scope
		String classScoped = "classScoped";
		String variableShadowing = "variableShadowing";
		public CorrectUsage() {
			System.out.println("------------------");
			System.out.println("CorrectUsage");
			System.out.println("------------------");
			String methodScoped = "methodScoped";
			while(true){
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
				break;
			}
		}
	}
	
	public static class ClassScope{
		String inScope = "inScope";
		public ClassScope() {
			System.out.println("------------------");
			System.out.println("ClassScope");
			System.out.println("------------------");
			
//			This will fail compilation as it can't find it in CorrectUsage as its out of scope
//			System.out.println(classScoped); 
			
//			This inScope is within the scope of the class and therefore can be used 
			System.out.println(inScope);
			
		}
	}
	
	public static class MethodScope{
		public MethodScope() {
			System.out.println("------------------");
			System.out.println("Method Scoped");
			System.out.println("------------------");
			createVariable();

//			This will fail during compilation
//			System.out.println(methodScoped);
			
			String inScope = "inScope";
			System.out.println(inScope);
		}
		
		@SuppressWarnings("unused")
		void createVariable() {
			String methodScoped = "methodScoped";
		}
	}
	
	public static class LoopScope{
		public LoopScope() {
			System.out.println("------------------");
			System.out.println("Loop Scoped");
			System.out.println("------------------");

			while(true) {
				String loopScope = "loopScope"; 
				System.out.println(loopScope);
				break;
			}

//			This will fail during compilation
//			System.out.println(loopScope);
		}
		

	}

	public static class BracketScope{
		public BracketScope() {
			System.out.println("------------------");
			System.out.println("Bracket Scoped");
			System.out.println("------------------");			
			{
				String bracketScope = "bracketScope";
				System.out.println(bracketScope);
			}
//			This will fail at compilation
//			System.out.println(bracketScope);
			
		}
	}
}

//TODO Cover advanced cases of scope with static inner classes, enclosing classes etc