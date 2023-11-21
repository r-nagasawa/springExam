package jp.eightbit.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import jp.eightbit.exam.controller.QuestionResult;
import jp.eightbit.exam.entity.Questions;
import jp.eightbit.exam.mapper.questionMapper;
import jp.eightbit.exam.model.QuestionModel;
import jp.eightbit.exam.model.QuestionResult;


@Service
public class QuestionService{
	
	@Autowired
	private questionMapper questMapper;
	
	public Questions getQuestion(Integer index) {
		Questions q = questMapper.findOne(index.longValue());
		//System.out.println(q.toString());
		return q;
	}
	
	//ユーザーが入力した値を保持するメソッド
	public List<QuestionResult> getResult(QuestionModel questionModel) {
		//Questionsの値のみが入るListを生成　//マッパークラスのfindAllで取得した値を格納
		List<Questions> questionList = questMapper.findAll();
		QuestionResult qr = null;
		List<QuestionResult> rList = new ArrayList<>();
		for(int i = 0; i < questionList.size(); i++) {
			Questions q = questionList.get(i);
			//QuestionResultをインスタンス生成
			qr = new QuestionResult();
			qr.setSentence(q.getSentence());
			String answer = q.getAnswer();
			qr.setAnswerValue(answer);
			qr.setAnswerLable(this.getAnswerLable(answer, q));
			qr.setUserAnswerValue(this.getUserAnswerValue(i, questionModel));
			qr.setTrueOrFalse(answer.equals(qr.getUserAnswerValue()));
			qr.setUserAnswerLable(this.getUserAnswerLable(q, qr.getUserAnswerValue()));
			rList.add(qr);
		}
		
		return rList;
	}
	
	
	private String getAnswerLable(String answer, Questions q) {
		String answerLable;
		
		if(answer.equals(q.getOption1_value())) {
			answerLable = q.getOption1_label();
		}else if(answer.equals(q.getOption2_value())) {
			answerLable = q.getOption2_label();
		}else if(answer.equals(q.getOption3_value())) {
			answerLable = q.getOption3_label();
		}else {
			answerLable = q.getOption4_label();
		}
		
		return answerLable;
	}
	
	//ユーザーの選択した選択肢記号の値を取得して返却する
	private String getUserAnswerValue(int i, QuestionModel questionModel) {
		String userAnsVal;
		switch(i) {
			case 0 :
				userAnsVal = questionModel.getAnswer1();
				break;
				
			case 1 :
				userAnsVal = questionModel.getAnswer2();
				break;
				
			default :
				userAnsVal = questionModel.getAnswer3();
		}
		return userAnsVal;
	}
	
	//ユーザーが選択肢記号から選択した文字列を取得する
	private String getUserAnswerLable(Questions q, String userAnswerValue) {
		
		String userAnswerLab;
		if(q.getOption1_value().equals(userAnswerValue)) {
			userAnswerLab = q.getOption1_label();
		}else if(q.getOption2_value().equals(userAnswerValue)) {
			userAnswerLab = q.getOption2_label();
		}else if(q.getOption3_value().equals(userAnswerValue)) {
			userAnswerLab = q.getOption3_label();
		}else {
			userAnswerLab = q.getOption4_label();
			
		}
		
		return userAnswerLab;
	}
	/*
	public int getCorrectCount(int i, List<QuestionResult> qrList) {
		
	}*/

}