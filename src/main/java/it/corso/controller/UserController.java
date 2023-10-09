package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dto.UserDto;
import it.corso.dto.UserSearchDto;
import it.corso.model.User;
import it.corso.service.UserService;


@RestController
@RequestMapping("social/user")
@CrossOrigin(origins = {"*"})
public class UserController 
{
	@Autowired
	private UserService userService;
	
	// endpoint #1: user registration | localhost:8080/social/user/reg
	@PostMapping("/reg")
	public ResponseEntity<ObjectNode> userRegistration(@RequestBody User user)
	{
		ObjectNode response = userService.userRegistration(user);
		return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
	}
	
	// endpoint #2: user login | localhost:8080/social/user/login
	@PutMapping("/login")
	public ResponseEntity<ObjectNode> userLogin(@RequestBody User user)
	{
		ObjectNode response = userService.userLogin(user);
		
		int httpCode = response.get("message").asText().equals("Not Authorized") ? 401 : 202;
		
		return new ResponseEntity<ObjectNode>(response,HttpStatusCode.valueOf(httpCode));
	}
	
	// endpoint #3: user logout | localhost:8080/realestate/admin/logout/{admin token}
		@GetMapping("/logout/{tkn}")
		public ResponseEntity<ObjectNode> adminLogout(@PathVariable("tkn") String token) 
		{
			ObjectNode response = userService.userLogout(token);
			return new ResponseEntity<ObjectNode>(response, HttpStatusCode.valueOf(response.get("code").asInt()));
		}
		
	// endpoint #4: user data update | localhost:8080/social/user/update/{admin token}
		@PutMapping("/update/{tkn}")
	    public ResponseEntity<ObjectNode> userAccountUpdate(
	            @RequestBody User user, 
	            @PathVariable("tkn") String token)
	    {
	        ObjectNode response = userService.userAccountUpdate(user, token);
	        return new ResponseEntity<ObjectNode>(response, 
	                HttpStatusCode.valueOf(response.get("code").asInt()));
	    }
		
	// endpoint #5: user removal | localhost:8080/social/user/delete/{user id}/{user token}
	    @DeleteMapping("/delete/{id}/{tkn}")
	    public ResponseEntity<ObjectNode> userRemoval(
	            @PathVariable("id") int id,
	            @PathVariable("tkn") String token)
	    {
	        ObjectNode response = userService.userRemoval(id, token);
	        return new ResponseEntity<ObjectNode>(response, 
	                HttpStatusCode.valueOf(response.get("code").asInt()));
	    }
	    
	 // endpoint #6: user account upgrade | localhost:8080/social/user/upgrade/{tkn}
		@PutMapping("/upgrade/{tkn}")
		public ResponseEntity<ObjectNode> userUpgrade(
	            @RequestBody User user, 
	            @PathVariable("tkn") String token)
	    {
	        ObjectNode response = userService.userUpgrade(user, token);
	        return new ResponseEntity<ObjectNode>(response, 
	                HttpStatusCode.valueOf(response.get("code").asInt()));
	    }
	    
	    
	    // endpoint 7: visualizza dati user localhost:8080/social/user/get/{token}
		@GetMapping("/get/{tkn}")
		public ResponseEntity<UserDto> getLoggedUserData(@PathVariable("tkn") String token){
			UserDto response = userService.getLoggedUserData(token);
			return new ResponseEntity<UserDto>(response, HttpStatus.OK);
		}
	    
		/* ------ ricerca utenti da nickname controller */
		// endpoint 8: localhost:8080/social/user/getsearch/{search}/{token}
		@GetMapping("/getsearch/{search}/{token}")
	    public ResponseEntity<List<UserSearchDto>> searchUsers(
	            @PathVariable("token") String token,
	            @PathVariable("search") String search
	    ) {
	        List<UserSearchDto> response = userService.searchUsers(search, token);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
}
