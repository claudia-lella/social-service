package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Comment;
import it.corso.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("social/comment")
@CrossOrigin(origins = {"*"})
public class CommentController {

	
	@Autowired
	private CommentService commentService;
	
	//endpoint 1 registrazione localhost:8080/social/comment/reg
		@PostMapping("/reg/{tkn}")
		public ResponseEntity<ObjectNode> commentRegistration(@Valid
				@RequestBody Comment comment,
				@PathVariable("tkn") String token)
		{
			ObjectNode response = commentService.commentRegistration(comment,token);
			return new ResponseEntity<ObjectNode>(response, 
					HttpStatusCode.valueOf(response.get("code").asInt()));
		}
}
