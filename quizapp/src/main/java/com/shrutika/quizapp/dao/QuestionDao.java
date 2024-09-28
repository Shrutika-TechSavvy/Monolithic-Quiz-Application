package com.shrutika.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shrutika.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    //Do we have to write any sql query?Any sql,hql,jpl
    //No, the thing is that category is actuall ythe part of the table.So, data jpa is smart enough to find that user is trying to find data based on category 
    //If few more modifications are required then you may use hql,jpl,etc

    //public List<Question> getAll();

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,int numQ);

}
