package batisMail;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import auxillaryClasses.ServerHashKey;


public class AddedToDB {

	public static void main(String[] args) {

		try {
			InputStream resourceAsStream = Resources
					.getResourceAsStream("configuration.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(resourceAsStream);
			factory.getConfiguration().addMapper(UsMap.class);

			SqlSession session = factory.openSession();
			try {
				UsMap mapper = session.getMapper(UsMap.class);

				List<ServerHashKey> userList = mapper.loadUser();
				for (ServerHashKey user : userList) {
					System.out.println(user);
				}

				 mapper.storeNewUser("zaal", "qwerty");
				
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
	
	
