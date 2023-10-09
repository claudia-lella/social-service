package it.corso.dao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import it.corso.model.Friendship;
import it.corso.model.User;

public interface FriendshipDao extends CrudRepository<Friendship, Integer> {

	
	@Query
	( value = "SELECT * FROM friendships WHERE status = 'Friendship accepted' AND (applicant_id=:id OR requested_id=:id)",
	nativeQuery=true)
	List<Friendship> getLoggedUserFriendships(@Param("id") int userId);
	List<Friendship> findByStatus(String status);
	Friendship findByApplicantAndRequested(User applicant, User requested);
	
}
