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
			qr.setAnswerLabel(this.getAnswerLabel(answer, q));
			qr.setUserAnswerValue(this.getUserAnswerValue(i, questionModel));
			qr.setTrueOrFalse(answer.equals(qr.getUserAnswerValue()));
			qr.setUserAnswerLabel(this.getUserAnswerLabel(q, qr.getUserAnswerValue()));
			rList.add(qr);
		}
		System.out.println(questionModel);
		return rList;
	}
	
	
	private String getAnswerLabel(String answer, Questions q) {
		String answerLabel;
		
		if(answer.equals(q.getOption1_value())) {
			answerLabel = q.getOption1_label();
		}else if(answer.equals(q.getOption2_value())) {
			answerLabel = q.getOption2_label();
		}else if(answer.equals(q.getOption3_value())) {
			answerLabel = q.getOption3_label();
		}else {
			answerLabel = q.getOption4_label();
		}
		
		return answerLabel;
	}
	
	//ユーザーの選択した選択肢記号の値を取得して返却する
	private String getUserAnswerValue(int i, QuestionModel questionModel) {
		String userAnsVal;
		switch(i) {
			case 0 :
				userAnsVal = questionModel.getAnswer1();
				//System.out.println(userAnsVal);
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
	private String getUserAnswerLabel(Questions q, String userAnswerValue) {
		
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
	
	//正解の数を数えるメソッド
	public int getCorrectCount(List<QuestionResult> qrList) {
		int count = 0;
		//リスト内のデータの数だけ繰り返す
		for(QuestionResult qr: qrList) {
			if(qr.isTrueOrFalse()) count++;
		}
		return count;
	}

}