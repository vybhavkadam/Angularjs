package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Blog;
import com.niit.model.Users;

@Transactional
@Repository("blogDao")
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDaoImpl(SessionFactory sessionFactory) {
		System.out.println("inside");
		this.sessionFactory = sessionFactory;
	}

	public void addBlog(Blog blog) {
		sessionFactory.getCurrentSession().save(blog);		
	}

	public List<Blog> viewBlogs() {
		
		
		Session session=sessionFactory.getCurrentSession();
		Criteria ct=session.createCriteria(Blog.class);
		ct.add(Restrictions.eq("status",true));//blogs to be fetched only if status is true
		
		/*Query result = session.createQuery("from Blog b where b.status='1'");
		List<Blog> blogs = result.list();
		for (int i = 0; i < blogs.size(); i++) {
			System.out.println("inside for loop");
			
			int id = blogs.get(i).getBlog_id();
			String title = blogs.get(i).getTitle();
			String description = blogs.get(i).getDescription();
			String category = blogs.get(i).getCategory();
			int likes = blogs.get(i).getLikes();
			System.out.println("the result is:" +id + " " +title + " " +description +" " + category + " " + +likes);
		}
		

*/		List<Blog> list = sessionFactory.getCurrentSession().createCriteria(Blog.class).list();
		return list;
	}

	public List<Blog> viewAllBlogs() {
		Session session=sessionFactory.getCurrentSession();
/*		Query result = session.createQuery("from Blog b where b.status='1'");
		List<Blog> blogs = result.list();
		for (int i = 0; i < blogs.size(); i++) {
			System.out.println("inside for loop");
			
			int id = blogs.get(i).getBlog_id();
			String title = blogs.get(i).getTitle();
			String description = blogs.get(i).getDescription();
			String category = blogs.get(i).getCategory();
			int likes = blogs.get(i).getLikes();
			System.out.println("the result is:" +id + " " +title + " " +description +" " + category + " " + +likes);
		}
*/
		Criteria ct=session.createCriteria(Blog.class);
		ct.add(Restrictions.eq("status",true));//blogs to be fetched only if status is true
		List list=ct.list();
		
		return list;	
	}

	public void deleteBlog(Blog blog) {
		sessionFactory.getCurrentSession().delete(blog);
	}

	public void updateBlog(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);		
	}

	public List<Blog> viewMyBlogs(String postedby) {
		System.out.println("in view my blogs");
		Session session=sessionFactory.getCurrentSession();
		Criteria ct=session.createCriteria(Blog.class);
		ct.add(Restrictions.eq("postedby",postedby));
		ct.add(Restrictions.eq("status",true));
		List list=ct.list();	
		return list;
	}
}