package jp.eightbit.exam.model;

public class QuestionResult{
	private String sentence;
	private String answerValue;
	private String answerLabel;
	private String userAnswerValue;
	private String userAnswerLabel;
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
	public String getAnswerLabel() {
		return answerLabel;
	}
	public void setAnswerLabel(String answerLabel) {
		this.answerLabel = answerLabel;
	}
	public String getUserAnswerValue() {
		return userAnswerValue;
	}
	public void setUserAnswerValue(String userAnswerValue) {
		this.userAnswerValue = userAnswerValue;
	}
	public String getUserAnswerLabel() {
		return userAnswerLabel;
	}
	public void setUserAnswerLabel(String userAnswerLabel) {
		this.userAnswerLabel = userAnswerLabel;
	}
	public boolean isTrueOrFalse() {
		return trueOrFalse;
	}
	public void setTrueOrFalse(boolean trueOrFalse) {
		this.trueOrFalse = trueOrFalse;
	}
	
	@Override
	public String toString() {
		return "QuestionResult [sentence=" + sentence + ", answerValue=" + answerValue + ", answerLabel=" + answerLabel
				+ ", userAnswerValue=" + userAnswerValue + ", userAnswerLabel=" + userAnswerLabel + ", trueOrFalse="
				+ trueOrFalse + "]";
	}
}