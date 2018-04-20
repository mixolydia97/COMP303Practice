import java.lang.reflect.*;

/**
 * This is my attempt for question 7 of the practice questions.
 * I decided to have it take as input a canonical class name.
 * @author sarah
 *
 */
public class ClassReader {

	public static void main(String[] args) {
		Class<Count> countClass = Count.class;
		
		dumpClass(countClass);

	}

	/**
	 * Dumps the class name and modifiers.
	 * Calls the other methods that deal with dumping 
	 * specific class things.
	 * @param source
	 */
	private static void dumpClass(Class source) {
		Package pack = source.getPackage();
		Class<?> parent = source.getSuperclass();
		Class<?>[] interfaces = source.getInterfaces();
		int numInterfaces = interfaces.length;
		
		if(pack != null) {
			System.out.format("package %d;\n", source.getPackage());
		}
		
		System.out.format("%s ", Modifier.toString(source.getModifiers()));
		System.out.format("class %s ", source.getName());
		
		if(parent != null) {
			System.out.format("extends %s ", parent.getSimpleName());
		}
		
		if(numInterfaces != 0) {
			System.out.format("implements ");
			for(int i = 0; i < numInterfaces; i++) {
				System.out.format("%s", interfaces[i].getSimpleName());
				
				if(i + 1 != numInterfaces) {
					System.out.print(", ");
				}
			}
		}
		
		System.out.println("{}");
		
	}
	
}
