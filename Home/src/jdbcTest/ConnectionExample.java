package jdbcTest;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class ConnectionExample {
//
//	public static void main(String[] args) {
//		
//		System.out.println("start");
//		
//		try {
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/VasiliyKomarov?user=root"); 
//			
//			Statement st = connection.createStatement();
////			ResultSet resultSet = st.executeQuery("select * from EmailAddress where id = 1");
//			ResultSet resultSet = st.executeQuery("select now()");
//			System.out.println(resultSet.isBeforeFirst());
//			resultSet.next();
//			resultSet.close();
//			
//			resultSet = st.executeQuery("select * from EmailAddress");
//			
//			while (resultSet.next()) {
//				System.out.println(resultSet.getString("id"));
//				System.out.println(resultSet.getString("emailAddress "));
//			}
//			
//			resultSet.close();
//			st.close();
//			
//			st = connection.createStatement();
//			
//			String email = "batman@gmail,com";
//			
////			st.execute("insert into EmailAddress (email) value ('malina@gmail.com')");
//			
//			connection.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//}
