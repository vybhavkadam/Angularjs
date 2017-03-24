package com.niit.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.niit.model.AnswerForum;

@Repository
@ComponentScan("com.niit")
public interface AnswerForumDao {
	
	void answerForum(AnswerForum answerForum);
	List<AnswerForum> viewAnswers(String forumid);

}
