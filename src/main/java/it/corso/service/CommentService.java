package it.corso.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Comment;

public interface CommentService {

	ObjectNode commentRegistration(Comment comment, String token);
}
