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

import it.corso.model.Like;

import it.corso.service.LikeService;



@RestController
@RequestMapping("social/like")
@CrossOrigin(origins = {"*"})
public class LikeController {

	
	@Autowired
	private LikeService likeService;
	
	//endpoint 1 registrazione like | localhost:8080/social/like/reg
	@PostMapping("/reg/{tkn}")
	public ResponseEntity<ObjectNode> likeRegistration(

			@RequestBody Like like,
			@PathVariable("tkn") String token)
		{
			ObjectNode response = likeService.likeRegistration(like, token);
			return new ResponseEntity<ObjectNode>(response, 
					HttpStatusCode.valueOf(response.get("code").asInt()));
		}
}