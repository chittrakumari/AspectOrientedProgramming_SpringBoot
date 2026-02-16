package com.telusko.springdatarestdemo.repo;



import com.telusko.springdatarestdemo.model.JobPost;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer>  {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword, String keyword1);
}