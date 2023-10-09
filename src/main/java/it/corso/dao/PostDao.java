package it.corso.dao;



import org.springframework.data.repository.CrudRepository;

import it.corso.model.Post;

public interface PostDao extends CrudRepository<Post, Integer> {


}
