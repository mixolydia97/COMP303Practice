import java.lang.reflect.*;

/**
 * This is my attempt for question 7 of the practice questions.
 * 
 * If anyone knows more about why specifically using the type 
 * "Class" gives a warning and why it's bad, I'd be happy to 
 * hear about it.
 * 
 * @author sarah
 *
 */
public class ClassReader 
{

	/**
	 * This was designed for demonstrative purposes only. It's not 
	 * very convenient to use, but you can just change the object, 
	 * class, and argument to dumpClass()
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Class<?> source = Count.class;
		
		dumpClass(source);
	}

	/**
	 * Prints package, class modifiers, class name, extended 
	 * classes, and implemented interfaces.
	 * Calls the other methods that deal with dumping 
	 * specific class things.
	 * @param source
	 */
	private static void dumpClass(Class<?> source) 
	{
		Package pack = source.getPackage();
		Class<?> parent = source.getSuperclass();
		Class<?>[] interfaces = source.getInterfaces();
		int numInterfaces = interfaces.length;
		
		if(pack != null) 
		{
			System.out.format("package %d;\n", source.getPackage());
		}
		
		/**
		 * getModifiers() returns an int that has to be "decoded" with
		 * Modifier.toString() in order to see the modifiers. It's the 
		 * most "irregular" method out of all the ones I used here.
		 */
		
		System.out.format("%s ", Modifier.toString(source.getModifiers()));
		
		System.out.format("class %s ", source.getName());
		
		if(parent != null) 
		{
			System.out.format("extends %s ", parent.getSimpleName());
		}
		
		if(numInterfaces != 0) 
		{
			System.out.format("implements ");
			for(int i = 0; i < numInterfaces; i++) 
			{
				System.out.format("%s", interfaces[i].getSimpleName());
				
				if(i + 1 != numInterfaces) 
				{
					System.out.print(", ");
				}
			}
		}
		
		System.out.println("{\n");
		
		dumpFields(source);
		System.out.println();
		dumpConstructors(source);
		System.out.println();
		dumpMethods(source);
		
		System.out.println("}\n");
	}
	
	
	/**
	 * I do ((Class<?>) field.getGenericType()).getSimpleName() instead 
	 * of field.getGenericType() because it makes it look more like 
	 * the actual source code. When "field" equals the ReentrantLock 
	 * in the Count class you get:
	 * 
	 * ReentrantLock.getGenericType() ==> java.util.concurrent.locks.ReentrantLock
	 * ((Class<?>) field.getGenericType()).getSimpleName() ==> ReentrantLock
	 * 
	 * @param source
	 */
	private static void dumpFields(Class<?> source) 
	{
		Field[] fields = source.getDeclaredFields();
		
		for(Field field : fields) 
		{
			System.out.format("    %s %s %s;\n", 
							Modifier.toString(field.getModifiers()),
							((Class<?>) field.getGenericType()).getSimpleName(),
							field.getName());
		}
	}

	private static void dumpConstructors(Class<?> source) 
	{
		Constructor<?>[] constructors = source.getDeclaredConstructors();
		
		for(Constructor<?> cons : constructors) 
		{
			System.out.format("    %s ", Modifier.toString(cons.getModifiers()));
			System.out.format("%s(", source.getSimpleName());
			
			/**
			 * I couldn't find a way to get the declared field names 
			 * so this is the best I could do
			 */
			
			Class<?>[] parameters = cons.getParameterTypes();
			for(int i = 0; i < parameters.length; i++) 
			{
				System.out.format("%s arg%d", parameters[i].getSimpleName(), i);
				
				if(i + 1 != parameters.length) 
				{
					System.out.print(", ");
				}
			}
			
			System.out.println(");");
		}
	}
	
	private static void dumpMethods(Class<?> source) 
	{
		Method[] methods = source.getDeclaredMethods();
		
		for(Method method : methods) 
		{
			System.out.format("    %s ", Modifier.toString(method.getModifiers()));
			System.out.format("%s(", method.getName());
			
			/**
			 * I couldn't find a way to get the declared field names 
			 * so this is the best I could do
			 */
			
			Class<?>[] parameters = method.getParameterTypes();
			for(int i = 0; i < parameters.length; i++) 
			{
				System.out.format("%s arg%d", parameters[i].getSimpleName(), i);
				
				if(i + 1 != parameters.length) 
				{
					System.out.print(", ");
				}
			}
			
			System.out.print(")");
			
			Class<?>[] exceptions = method.getExceptionTypes();
			if(exceptions.length != 0) 
			{
				System.out.print(" throws ");
				for(int i = 0; i < exceptions.length; i++) 
				{
					System.out.format("%s", exceptions[i].getSimpleName());
					
					if(i + 1 != exceptions.length) 
					{
						System.out.print(", ");
					}
				}
			}
			
			System.out.println(";");
		}
	}
}
