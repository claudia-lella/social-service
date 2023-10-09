package it.corso.service;
import java.util.List;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.dto.UserDto;
import it.corso.dto.UserSearchDto;
import it.corso.model.User;

public interface UserService {

	ObjectNode userRegistration(User user);
	ObjectNode userLogin(User user);
	ObjectNode userLogout(String token);
	ObjectNode userAccountUpdate(User user, String token);
	ObjectNode userRemoval(int id, String token);
	ObjectNode userUpgrade(User user, String token);
	UserDto getLoggedUserData(String token);
	/* ------ ricerca utenti da nickname */
	List<UserSearchDto> searchUsers(String search, String token); 
}
