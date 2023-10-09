package it.corso.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.model.Like;

public interface LikeService 
{
	ObjectNode likeRegistration(Like like, String token);
}
