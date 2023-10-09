package it.corso.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.dao.UserDao;
import it.corso.dto.UserDto;
import it.corso.dto.UserSearchDto;
import it.corso.helper.ResponseManager;
import it.corso.helper.SecurityManager;
import it.corso.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ResponseManager responseManager;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public ObjectNode userRegistration(User user) {
		if(userDao.findByNickname(user.getNickname()) != null)
			return responseManager.getResponse(406, "Existing Nickname");
		user.setProfileType("Standard");
		user.setEntryDate(LocalDate.now());
		
		user.setPassword(SecurityManager.encode(user.getPassword()));
		
		userDao.save(user);
		return responseManager.getResponse(201, "User Registrated");
	}

	@Override
    public ObjectNode userLogin(User user) 
    {
        User existing = userDao.findByNicknameAndPassword(user.getNickname(), SecurityManager.encode(user.getPassword()));
        if(existing == null)
            return responseManager.getResponse(401, "Not Authorized");
        existing.setAuthToken(SecurityManager.generateToken(existing.getNickname(), true));
        userDao.save(existing);
        return responseManager.getResponse(existing.getId(), existing.getAuthToken());
    }

	@Override
	public ObjectNode userLogout(String token) {
		User existing = userDao.findByAuthToken(token);
		if(existing == null)
			return responseManager.getResponse(401, "Not Authorized");
		existing.setAuthToken(null);
		userDao.save(existing);
		return responseManager.getResponse(202, "Logout Authorized");
	}

	@Override
    public ObjectNode userAccountUpdate(User user, String token)
    {
        if(userDao.findByAuthToken(token) == null)
            return responseManager.getResponse(401, "Not Authorized");
        Optional<User> userOptional = userDao.findById(user.getId());
        if(!userOptional.isPresent())
            return responseManager.getResponse(404, "User Not Found");
        User existing = userOptional.get();
        existing.setName(user.getName());
        existing.setLastname(user.getLastname());
        existing.setPassword(SecurityManager.encode(user.getPassword()));
        existing.setMail(user.getMail());
        existing.setProfileImage(user.getProfileImage());
        userDao.save(existing);
        return responseManager.getResponse(202, "User Data Updated");
    }
	
	@Override
    public ObjectNode userRemoval(int id, String token)
    {
        if(userDao.findByAuthToken(token) == null)
            return responseManager.getResponse(401, "Not Authorized");
        Optional<User> userOptional = userDao.findById(id);
        if(!userOptional.isPresent())
            return responseManager.getResponse(404, "User Not Found");
        userDao.delete(userOptional.get());
        return responseManager.getResponse(202, "User Removed");
    }

	@Override
	public ObjectNode userUpgrade(User user, String token) {
		 if(userDao.findByAuthToken(token) == null)
	            return responseManager.getResponse(401, "Not Authorized");
	        Optional<User> userOptional = userDao.findById(user.getId());
	        if(!userOptional.isPresent())
	            return responseManager.getResponse(404, "User Not Found"); 
	        User existing = userOptional.get();
	        existing.setProfileType("Business");	        
	        userDao.save(existing);
	        return responseManager.getResponse(202, "User Profile Upgraded");
	}

	@Override
	public UserDto getLoggedUserData(String token) {
		
		User user = userDao.findByAuthToken(token);
		
		if(user == null)
			return new UserDto();
		
		UserDto userDto = mapper.map(user, UserDto.class);
		
		// password in chiaro
		userDto.setPassword(SecurityManager.decode(userDto.getPassword()));
			
		return userDto;
	}

	/* ------ ricerca utenti tramite nickname */
	@Override
	public List<UserSearchDto> searchUsers(String search, String token) {

		List<UserSearchDto> found = new ArrayList<>();
		User searcher = userDao.findByAuthToken(token);
		
		if(searcher == null)
			return found;
		
		List<User> users = userDao.findByNicknameContaining(search);
		users.remove(searcher);
		users.forEach(u -> found.add(mapper.map(u, UserSearchDto.class)));
		
		return found;
	}
	
	

}
