package jdbcTestCourses;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Persister {

	public static List<String> tables;

	public static boolean persist(Object object) {
		boolean result = false;
		
		if(object == null) { 
			return false;
		}
		
		if(tables == null) {
			fetchTableList();
		}
		
		Class clazz = object.getClass();
		System.out.println(clazz.getSimpleName());
		
		int indexOf = tables.indexOf(clazz.getSimpleName());
		
		if (indexOf == -1) {
			System.out.println("Table with name '" + clazz.getName() + "'not found");
			return false;
		}
		
		String tableName = clazz.getSimpleName();
		
		List<String> properties = new LinkedList<>();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if(method.getName().startsWith("get")) {
				String property = method.getName().substring(3).toLowerCase();
				properties.add(property);
				System.out.println("--> " + property);
			}
		}
		
		
		
		return result;
	}

	private static void fetchTableList() {
		tables = new LinkedList<>();
		try {
			Statement st = DBManager.connection().createStatement();
			ResultSet tableNames = st.executeQuery("show tables");
			
			while(tableNames.next()) {
				tables.add(tableNames.getString(1));
			}
			System.out.println(tables);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
