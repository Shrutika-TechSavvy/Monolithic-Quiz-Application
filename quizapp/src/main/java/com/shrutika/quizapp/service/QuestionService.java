package com.shrutika.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shrutika.quizapp.dao.QuestionDao;
import com.shrutika.quizapp.model.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questiondao;
    
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        try{
        return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category)
    {
        try{
            return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.OK);//This is magic here
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return new ResponseEntity<>(new ArrayList<>(), BAD_REQUEST);
        
    }

    public ResponseEntity<String> addQuestion(Question question)
    {
        questiondao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
        //Try to add status code
    }
}
