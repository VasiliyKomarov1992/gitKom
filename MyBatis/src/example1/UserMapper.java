package example1;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select name, password, email from User")
	List<User> loadUser();
	
	@Select("select name, password, email from User where email=#{ppp}")
	User loadUserByEmail(String email);

	@Select("select name, password, email from User where name=#{0} and password=#{1}")
	User loadUserByNameAndPassword(String n, String p);

	@Insert("insert into User values(#{0},#{1},#{2})")
	void storeNewUser(String name, String password, String email);
	
}
