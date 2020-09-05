package com.khan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khan.entity.Answer;
import com.khan.entity.Question;


public class MyApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Question");
		String question = sc.nextLine();

		System.out.println("Enter Answer1");
		String ans1 = sc.nextLine();

		System.out.println("Enter Answer2");
		String ans2 = sc.nextLine();
		
		System.out.println("Enter Answer3");
		String ans3 = sc.nextLine();

		
		Question questio=new Question();
		questio.setQuestion(question);
		
		Answer answer1=new Answer(ans1,questio);
		
		Answer answer2=new Answer(ans2,questio);
		Answer answer3=new Answer(ans3,questio);

		List<Answer> listAnswer=new ArrayList<Answer>();
		listAnswer.add(answer1);
		listAnswer.add(answer2);
		listAnswer.add(answer3);
		questio.setAnswer(listAnswer);
		
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction txn = session.beginTransaction();
		session.save(questio);
		txn.commit();
		session.close();
		factory.close();
		
		System.out.println("Data save successfully");
	}

}
