package com.sist.board;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/BoardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 서버에 의해서 자동으로 호출되는 메소드 
	// 사용자  요청을 했을때 마다 호출 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}