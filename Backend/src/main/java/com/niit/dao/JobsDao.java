package com.niit.dao;

import java.util.List;

import com.niit.model.Jobs;

public interface JobsDao {

	void addJobs(Jobs jobs);

	List<Jobs> viewJobs();

	void deleteJob(Jobs jobs);

	void updateJob(Jobs jobs);
}
