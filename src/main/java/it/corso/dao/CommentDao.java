package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Comment;

public interface CommentDao extends CrudRepository<Comment, Integer> {

}
