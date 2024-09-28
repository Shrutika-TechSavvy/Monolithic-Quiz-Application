package com.shrutika.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String category;
    private String questionTitle;
    private String option1, option2,option3,option4;
    private String rightAnswer;
    private String difficultylevel;

}
