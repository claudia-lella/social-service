package it.corso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.dao.LikeDao;
import it.corso.dao.UserDao;
import it.corso.helper.ResponseManager;
import it.corso.model.Like;
import it.corso.model.User;

@Service
public class LikeServiceImpl implements LikeService 
{
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LikeDao likeDao;
	
	@Autowired
	private ResponseManager responseManager;

	@Override
	public ObjectNode likeRegistration(Like like, String token) {
		User existingUser = userDao.findByAuthToken(token);
		if(existingUser == null ) 
			return responseManager.getResponse(401, "Not Authorized");
		
		like.setUser(existingUser);
		
		likeDao.save(like);
        return responseManager.getResponse(201, "Like Registrated");
	}

}
