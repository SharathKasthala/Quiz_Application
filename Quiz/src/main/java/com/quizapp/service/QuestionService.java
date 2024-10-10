package com.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Service;

import com.quizapp.entity.Question;
import com.quizapp.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;

	public ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(questionRepository.findQuestionsByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	
	

	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		questionRepository.save(question);
		return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
	}

}
