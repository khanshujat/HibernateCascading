package com.khan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="Answer")
@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="aid")
	private int id;
	
	@Column(name="answer")
	private String ans;
	
	@ManyToOne
	private Question question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
	public Answer(String ans, Question question) {
		super();
		this.ans = ans;
		this.question = question;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
