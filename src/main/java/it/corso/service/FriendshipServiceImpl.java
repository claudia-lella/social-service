package it.corso.service;


import java.time.LocalDateTime;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.FriendshipDao;
import it.corso.dao.UserDao;


import it.corso.helper.ResponseManager;
import it.corso.model.Friendship;
import it.corso.model.User;

@Service
public class FriendshipServiceImpl implements FriendshipService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ResponseManager responseManager;
	
	@Autowired
	private FriendshipDao friendshipDao;
	
	
	@Override
	public ObjectNode addFriendship(Friendship friendship, String token) {
	    User applicant = userDao.findByAuthToken(token);
	    
	    // Controllo se il richiedente è lo stesso dell'utente destinatario
	    if (applicant == null || applicant.getId() == friendship.getRequested().getId()) {
	        return responseManager.getResponse(401, "Not Authorized");
	    }

	    Optional<User> optional = userDao.findById(friendship.getRequested().getId());
	    if (!optional.isPresent()) {
	        return responseManager.getResponse(404, "Not Found");
	    }
	    
	    // Verifica se esiste già una richiesta di amicizia pendente tra gli stessi utenti
	    Friendship existingFriendship = friendshipDao.findByApplicantAndRequested(applicant, optional.get());
	    if (existingFriendship != null) {
	        return responseManager.getResponse(400, "Friendship request already sent");
	    }

	    friendship.setApplicant(applicant);
	    friendship.setTiming(LocalDateTime.now());
	    friendship.setStatus("Friendship sent");
	    friendship.setRequested(optional.get());
	    friendshipDao.save(friendship);
	    return responseManager.getResponse(201, "Friendship sent");
	}
	

	@Override
	public ObjectNode acceptFriendship(Friendship friendship, String token) {
		User user = userDao.findByAuthToken(token);
		if(user == null)
			return responseManager.getResponse(401, "Not Authorized");
		Optional<Friendship> optional = friendshipDao.findById(friendship.getId());
		if(!optional.isPresent())
			return responseManager.getResponse(404, "Not Found");
		Friendship toAccept = optional.get();
		toAccept.setStatus("Friendship accepted");
		friendshipDao.save(toAccept);
		return responseManager.getResponse(202, "Friendship Accepted");
	}


	@Override
	public ObjectNode friendshipRemoval(int id, String token) {
		User user = userDao.findByAuthToken(token);
		if(user == null)
			return responseManager.getResponse(401, "Not Authorized");
		Optional<Friendship> optional = friendshipDao.findById(id);
		if(!optional.isPresent())
			return responseManager.getResponse(404, "Friendship Not Found");
		
		Friendship friendship = optional.get();
		
		if(friendship.getStatus().equals("Friendship sent")) {
			friendship.getApplicant().getRequestedFriendships().remove(friendship);
			friendship.getRequested().getReceivedFriendships().remove(friendship);
			friendshipDao.save(friendship);
			return responseManager.getResponse(202, "Friendship Removed");
		}
		
		return responseManager.getResponse(401, "Not Authorized");
	}

}
