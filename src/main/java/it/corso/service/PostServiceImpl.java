package it.corso.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.dao.FriendshipDao;
import it.corso.dao.PostDao;
import it.corso.dao.UserDao;
import it.corso.dto.PostCommentDto;
import it.corso.dto.PostDto;
import it.corso.helper.ResponseManager;
import it.corso.model.Friendship;
import it.corso.model.Post;
import it.corso.model.User;


@Service
public class PostServiceImpl implements PostService {

	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private FriendshipDao friendshipDao;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private ResponseManager responseManager;
	
	@Override
	public ObjectNode postRegistration(Post post, String token) {
		if(userDao.findByAuthToken(token) == null)
			return responseManager.getResponse(401, "Not Authorized");
		post.setTiming(LocalDateTime.now());
        postDao.save(post);
        return responseManager.getResponse(201, "Post Registrated");
	}

	@Override
	public List<PostDto> getPosts(String token)
    {
        List<PostDto> postsDto = new ArrayList<>();
        
        User user = userDao.findByAuthToken(token);
        if(user == null)
            return postsDto;
        // lista relazioni amicizia confermate utente loggato
        List<Friendship> userFriendShips = friendshipDao.getLoggedUserFriendships(user.getId());
        // set (no duplicati) con tutti gli id degli utenti di cui mostrare post ad utente loggato (compreso il suo)
        Set<Integer> relatedUserIds = new HashSet<>();
        userFriendShips.forEach(f -> {
            if(f.getApplicant().getId() != user.getId())
                relatedUserIds.add(f.getApplicant().getId());
            if(f.getRequested().getId() != user.getId())
            relatedUserIds.add(f.getRequested().getId());
        });
	// acquisizione di tutti i post dal database
        List<Post> allPosts = (List<Post>) postDao.findAll();
        // lista con post da mostrare ad utente loggato
        List<Post> posts = new ArrayList<>();
        allPosts.forEach(p -> {
            if(p.getUser().getId() == user.getId())
                posts.add(p);
            relatedUserIds.forEach(r -> {
                if(p.getUser().getId() == r)
                    posts.add(p);
            });
        });
        
        posts.forEach(p -> postsDto.add(mapper.map(p, PostDto.class)));	
        
        Comparator<PostDto> comparator = Comparator.comparing(PostDto::getTiming).reversed();
       
        postsDto.sort(comparator);
        
        Comparator<PostCommentDto> commentComparator = Comparator.comparing(PostCommentDto::getTiming).reversed();
        
        postsDto.forEach(p -> {
        	p.getComments().sort(commentComparator);
        });
        
        return postsDto;
        
    }

	@Override
	public List<PostDto> getMyPosts(String token) {
		
		List<PostDto> postsDto = new ArrayList<>();
        User user = userDao.findByAuthToken(token);
        if(user == null)
            return postsDto;
		List<Post> allPosts = (List<Post>) postDao.findAll();
		List<Post> posts = new ArrayList<>();
        allPosts.forEach(p -> {
            if(p.getUser().getId() == user.getId())
                posts.add(p);
            
            });

        posts.forEach(p -> postsDto.add(mapper.map(p, PostDto.class)));
        Comparator<PostDto> comparator = Comparator.comparing(PostDto::getTiming).reversed();
        postsDto.sort(comparator);
        return postsDto;
	}
	
}
