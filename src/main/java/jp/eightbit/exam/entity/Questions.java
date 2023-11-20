package jp.eightbit.exam.entity;


public class Questions{

	private long id;
	private String sentence;

	private String option1_value;
	private String option1_label;

	private String option2_value;
	private String option2_label;
	
	private String option3_value;
	private String option3_label;
	
	private String option4_value;
	private String option4_label;
	
	private String answer;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getSentence() {
		return sentence;
	}
	
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public String getOption1_value() {
		return option1_value;
	}
	
	public void setOption1_value(String option1_value) {
		this.option1_value = option1_value;
	}
	
	public String getOption1_label() {
		return option1_label;
	}
	
	public void setOption1_label(String option1_label) {
		this.option1_label = option1_label;
	}
	
	public String getOption2_value() {
		return option2_value;
	}
	
	public void setOption2_value(String option2_value) {
		this.option2_value = option2_value;
	}
	
	public String getOption2_label() {
		return option2_label;
	}
	
	public void setOption2_label(String option2_label) {
		this.option2_label = option2_label;
	}
	
	public String getOption3_value() {
		return option3_value;
	}
	
	public void setOption3_value(String option3_value) {
		this.option3_value = option3_value;
	}
	
	public String getOption3_label() {
		return option3_label;
	}
	
	public void setOption3_label(String option3_label) {
		this.option3_label = option3_label;
	}
	
	public String getOption4_value() {
		return option4_value;
	}
	
	public void setOption4_value(String option4_value) {
		this.option4_value = option4_value;
	}
	
	public String getOption4_label() {
		return option4_label;
	}
	
	public void setOption4_label(String option4_label) {
		this.option4_label = option4_label;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	@Override
	public String toString() {
		return "Questions [id=" + id + ", sentence=" + sentence + ", option1_value=" + option1_value
				+ ", option1_label=" + option1_label + ", option2_value=" + option2_value + ", option2_label="
				+ option2_label + ", option3_value=" + option3_value + ", option3_label=" + option3_label
				+ ", option4_value=" + option4_value + ", option4_label=" + option4_label + ", answer=" + answer + "]";
	}
}