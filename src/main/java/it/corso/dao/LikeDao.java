package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import it.corso.model.Like;

public interface LikeDao extends CrudRepository<Like, Integer>
{
	
}
