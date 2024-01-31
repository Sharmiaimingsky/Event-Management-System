package com.sunbeam.ems.dtos;

public class Credentials {
	
    private String mobileNumber;
	private String question;
	private String answer;
	public Credentials() {
	}
	public Credentials(String mobileNumber, String question, String answer) {
		this.mobileNumber = mobileNumber;
		this.question = question;
		this.answer = answer;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getmobileNumber() {
		return mobileNumber;
	}
	public void setmobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Credentials [mobileNumber=" + mobileNumber + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
}
