package com.scottmarden.randomwordgen.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomCtrl
 */
//@WebServlet("/random")
public class RandomCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String randomWord(){
    		String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    		StringBuilder sb = new StringBuilder();
    		Random rand = new Random();
    		while(sb.length() < 15) {
    			sb.append(candidateChars.charAt(rand.nextInt(candidateChars.length())));
    		}
    		return sb.toString();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RandomCtrl loaded!");
		HttpSession session = request.getSession();
		if(session.getAttribute("count") == null) {
			int count = 0;
			session.setAttribute("count", count);
		}
		else {
			int count = (int) session.getAttribute("count");
			System.out.println("Count pre increment:" +  count);
			count++;
			System.out.println("Count post increment: " + count);
			
			session.setAttribute("count", count);
		}
		String word = randomWord();
		request.setAttribute("word", word);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Home.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
