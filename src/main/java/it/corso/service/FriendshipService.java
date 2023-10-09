package it.corso.service;



import com.fasterxml.jackson.databind.node.ObjectNode;


import it.corso.model.Friendship;

public interface FriendshipService {

	ObjectNode addFriendship(Friendship friendship, String token);
	ObjectNode acceptFriendship(Friendship friendship, String token);
	ObjectNode friendshipRemoval(int id, String token);
	
}
