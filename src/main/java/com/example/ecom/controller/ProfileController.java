package com.example.ecom.controller;
import  java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class ProfileController extends  HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher profile=request.getRequestDispatcher("WEB-INF/profile.jsp");
        profile.forward(request,response);
    }
}
