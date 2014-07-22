package jdbcTestCourses;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
		
		Map<String, Object> properties = new HashMap<>();
//		List<String> properties = new LinkedList<>();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if(method.getName().startsWith("get")) {
				String property = method.getName().substring(3).toLowerCase();
				Object value = extractValue(object, method);
				properties.put(property, value);
			}
		}
		save2db(tableName, properties);
		
		return result;
	}

	private static void save2db(String tableName, Map<String, Object> properties) {
		try {
			Statement st = DBManager.connection().createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into ").append(tableName).append(" set ");
			
			for (String property : properties.keySet()) {
				String value = properties.get(property).toString();
				sb.append(property).append(" = '").append(value).append("'");
				sb.append(',');
			}
			sb.deleteCharAt(sb.length() - 1);
			
			String query = sb.toString();
			
			st.execute(query);
			
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Object extractValue(Object object, Method method) {
		try {
			Object value = method.invoke(object, null);
			return value;
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return null;
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
