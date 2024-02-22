package com.example.ecom.controller;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class HomeController extends  HttpServlet {
    public void init()throws ServletException{

    }
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher home=request.getRequestDispatcher("templates/home.jsp");
        home.forward(request,response);
    }
}
