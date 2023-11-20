package jp.eightbit.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import jp.eightbit.exam.controller.QuestionResult;
import jp.eightbit.exam.entity.Questions;
import jp.eightbit.exam.mapper.questionMapper;
import jp.eightbit.exam.model.QuestionModel;


@Service
public class QuestionService{
	
	@Autowired
	private questionMapper questMapper;
	
	public Questions getQuestion(Integer index) {
		Questions q = questMapper.findOne(index.longValue());
		//System.out.println(q.toString());
		return q;
	}
	/*
	public List<QuestionResult> getResult(QuestionModel questionModel) {
		
	}
	
	private String getAnswerLabel(String Questions) {
		
	}

	private String getUserAnswerValue(int QuestionModel) {
		
	}
	
	private String getUserAnswerLabel(Question String) {
		
	}
	
	public int get getCorrectCount( List<QuestionResult> ) {
		
	}*/
}