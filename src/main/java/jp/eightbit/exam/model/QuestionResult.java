package jp.eightbit.exam.model;

public class QuestionResult{
	private String sentence;
	private String answerValue;
	private String answerLable;
	private String userAnswerValue;
	private String userAnswerLable;
	private boolean trueOrFalse;
	
	
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public String getAnswerValue() {
		return answerValue;
	}
	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}
	public String getAnswerLable() {
		return answerLable;
	}
	public void setAnswerLable(String answerLable) {
		this.answerLable = answerLable;
	}
	public String getUserAnswerValue() {
		return userAnswerValue;
	}
	public void setUserAnswerValue(String userAnswerValue) {
		this.userAnswerValue = userAnswerValue;
	}
	public String getUserAnswerLable() {
		return userAnswerLable;
	}
	public void setUserAnswerLable(String userAnswerLable) {
		this.userAnswerLable = userAnswerLable;
	}
	public boolean isTrueOrFalse() {
		return trueOrFalse;
	}
	public void setTrueOrFalse(boolean trueOrFalse) {
		this.trueOrFalse = trueOrFalse;
	}
	
	@Override
	public String toString() {
		return "QuestionResult [sentence=" + sentence + ", answerValue=" + answerValue + ", answerLable=" + answerLable
				+ ", userAnswerValue=" + userAnswerValue + ", userAnswerLavel=" + userAnswerLable + ", trueOrFalse="
				+ trueOrFalse + "]";
	}
}