package com.niit.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.niit.model.BlogComment;

@Repository
@ComponentScan("com.niit")
public interface BlogCommentDao {

	void addComment(BlogComment blogComment);

	List<BlogComment> viewComments(String blogid);

}
