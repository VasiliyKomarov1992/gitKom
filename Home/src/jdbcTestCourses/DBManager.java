package jdbcTestCourses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	
	private static DBManager self = new DBManager(); 
	
	public static Connection connection() {
		return self.conn;
	}
	
	private Connection conn;
	
	{
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbctest?user=root");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private DBManager() {
		
	}
	
	public static void main(String[] args) {
		
//	select можно делать при помощи executeQuery();
//	preparedStatement() - можно добавлять данные 	
		
		System.out.println("start");
		
		try {
			Statement st = DBManager.connection().createStatement();
//			ResultSet resultSet = st.executeQuery("select * from EmailAddress where id = 1");
			ResultSet resultSet = st.executeQuery("select now()");
			System.out.println(resultSet.isBeforeFirst());
			resultSet.next();
			resultSet.close();
			
			resultSet = st.executeQuery("select * from User");
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("password"));
				System.out.println(resultSet.getString("email"));
			}
			
			resultSet.close();
			st.close();

			String name = "Bruce";
			String password = "5476";
			String email = "batman@gmail,com";
			String query = "insert into User value ('"+ name +"',' " + password + "',' " + email + "')";
			
			executeQuery(DBManager.connection(), query);
			PreparedStatement prepareStatement = DBManager.connection().prepareStatement("insert into User value (?,?,?)");

			addUser(prepareStatement, "Rafa", "2455346", "Rafa@mail.com");
			
//			st.execute("insert into Users value ('Mali', '3244', 'malina@gmail.com')");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addUser(PreparedStatement prepareStatement, String name, String password, String email) {
		try {
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, password);
			prepareStatement.setString(3, email);
			prepareStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void executeQuery(Connection connection, String query)
			throws SQLException {
		Statement st;
		st = connection.createStatement();
		System.out.println(query);
		st.execute(query);
		st.close();
	}
	
}
