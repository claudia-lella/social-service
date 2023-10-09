package it.corso.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.CommentDao;
import it.corso.dao.UserDao;
import it.corso.helper.ResponseManager;
import it.corso.model.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private ResponseManager responseManager;
	
	@Override
	public ObjectNode commentRegistration(Comment comment, String token) {
		if(userDao.findByAuthToken(token) == null)
			return responseManager.getResponse(401, "Not Authorized");
		comment.setTiming(LocalDateTime.now());
        commentDao.save(comment);
        return responseManager.getResponse(201, "Comment Registrated");
	}

}
