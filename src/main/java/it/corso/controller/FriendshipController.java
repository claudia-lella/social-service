package it.corso.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Friendship;
import it.corso.service.FriendshipService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("social/friendship")
@CrossOrigin(origins = {"*"})
public class FriendshipController {

	
	@Autowired
	private FriendshipService friendshipService;
	
	//endpoint 1 aggiunta amicizia localhost:8080/social/friendship/reg
	@PostMapping("/reg/{tkn}")
	public ResponseEntity<ObjectNode> addFriendship(@Valid
			@RequestBody Friendship friendship,
			@PathVariable("tkn") String token)
	{
		ObjectNode response = friendshipService.addFriendship(friendship,token);
		return new ResponseEntity<ObjectNode>(response, 
				HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	// endpoint #2: cambio stato richiesta amicizia | localhost:8080/social/friendship/update/
	@PutMapping("/update/{tkn}")
	public ResponseEntity<ObjectNode> acceptedFriendship(
			@RequestBody Friendship friendship, 
		    @PathVariable("tkn") String token)
	{
		ObjectNode response = friendshipService.acceptFriendship(friendship, token);
		return new ResponseEntity<ObjectNode>(response, 
				HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	// endpoint #3: rimozione amicizia  localhost:8080/social/friendship/delete/{friendship id}/{user token}
	@DeleteMapping("/delete/{id}/{tkn}")
	public ResponseEntity<ObjectNode> friendshipRemoval(
			@PathVariable("id") int id,
			@PathVariable("tkn") String token)
	{
		ObjectNode response = friendshipService.friendshipRemoval(id, token);
		return new ResponseEntity<ObjectNode>(response, 
				HttpStatusCode.valueOf(response.get("code").asInt()));
	}
}
