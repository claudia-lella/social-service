package it.corso.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dto.PostDto;
import it.corso.model.Post;
import it.corso.service.PostService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("social/post")
@CrossOrigin(origins = {"*"})
public class PostController {

	
	@Autowired
	private PostService postService;
	
	//endpoint 1 registrazione localhost:8080/social/post/reg
		@PostMapping("/reg/{tkn}")
		public ResponseEntity<ObjectNode> postRegistration(@Valid
				@RequestBody Post post,
				@PathVariable("tkn") String token)
		{
			ObjectNode response = postService.postRegistration(post,token);
			return new ResponseEntity<ObjectNode>(response, 
					HttpStatusCode.valueOf(response.get("code").asInt())); 
		}
		
	// endpoint 2 localhost:8080/social/post/get
		@GetMapping("/get/{tkn}")
		public ResponseEntity<List<PostDto>> getPosts(@PathVariable("tkn") String token){
			List<PostDto> response = postService.getPosts(token);
			return new ResponseEntity<List<PostDto>>(response, HttpStatus.OK);
		}
		

		// endpoint 3 localhost:8080/social/post/getmy/{tkn}
		@GetMapping("/getmy/{tkn}")
		public ResponseEntity<List<PostDto>> getMyPosts(@PathVariable("tkn") String token){
			List<PostDto> response = postService.getMyPosts(token);
			return new ResponseEntity<List<PostDto>>(response, HttpStatus.OK);
		}
}
