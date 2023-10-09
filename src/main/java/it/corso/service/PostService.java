package it.corso.service;


import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dto.PostDto;
import it.corso.model.Post;


public interface PostService {

	ObjectNode postRegistration(Post post, String token);
	List<PostDto> getPosts(String token);
	// get post 
	List<PostDto> getMyPosts(String token);
}
