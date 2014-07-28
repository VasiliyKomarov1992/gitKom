package example1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Example {

	public static void main(String[] args) {

		try {
			InputStream resourceAsStream = Resources
					.getResourceAsStream("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(resourceAsStream);
			factory.getConfiguration().addMapper(UserMapper.class);

			SqlSession session = factory.openSession();
			try {
				UserMapper mapper = session.getMapper(UserMapper.class);

				List<User> userList = mapper.loadUser();
				for (User user : userList) {
					System.out.println(user);
				}

				// User join = mapper.loadUserByEmail("a@ma.ru");
				// System.out.println(join);
				//
				// join = mapper.loadUserByNameAndPassword("John", "123");
				// System.out.println(join);

				 mapper.storeNewUser("zaal", "qwerty", "zaal@itcwin.com");
				
				/* добавление записи(с engine MyISAM), если добавляем в бд с
				 * engine InnoDB, то не сохраняются изменения. Надо добавлять по-другому. 	
				 */ 

			} finally {
				session.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
