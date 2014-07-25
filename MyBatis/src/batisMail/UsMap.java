package batisMail;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import auxillaryClasses.ServerHashKey;

public interface UsMap {

	@Select("select sendersMail, recipentMail from AddressMail")
	List<ServerHashKey> loadUser();
	
	@Insert("insert into AddressMail values(#{1},#{2})")
	void storeNewUser(String recipent, String senders);
	
}
