package com.shrutika.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrutika.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
