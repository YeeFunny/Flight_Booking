package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addflight")
public class AdminAddFlightCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String deptCity = request.getParameter("deptCity");
			String arrCity = request.getParameter("arrCity");
			Date deptDate = Date.valueOf(request.getParameter("deptDate"));
			Time deptTime = Time.valueOf(request.getParameter("deptTime"));
			Date arrDate = Date.valueOf(request.getParameter("arrDate"));
			Time arrTime = Time.valueOf(request.getParameter("arrTime"));
			
			System.out.println(deptDate);
			System.out.println(deptTime);
			System.out.println(arrDate);
			System.out.println(arrTime);
	}

}
