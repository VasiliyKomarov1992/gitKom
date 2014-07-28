package batisMail;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import auxillaryClasses.Message;
import auxillaryClasses.ServerHashKey;

public interface UsMap {

	@Select("select sendersMail, recipentMail, messages from AddressMail")
	List<ServerHashKey> loadUser();
	
	@Insert("insert into AddressMail values(#{1},#{2},#{3})")
	void storeNewUser(String _recipientsAdress, String _sendersAdress,
			Message newMessage);
}
