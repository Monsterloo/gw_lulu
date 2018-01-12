<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	//response.sendRedirect("login_loginPage.action"); 
	request.getRequestDispatcher("/login/loginUI").forward(request,response);
	//关闭输出流
	out.flush();
	out.close();
%>
