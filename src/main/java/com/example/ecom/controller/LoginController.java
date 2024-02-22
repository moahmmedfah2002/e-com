package com.example.ecom.controller;
import java.io.*;

import com.example.ecom.modele.UserModele;
import com.example.ecom.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class LoginController extends  HttpServlet {
    UserModele user=new UserModele();
    UserService action=new UserService();
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher login=request.getRequestDispatcher("templates/login.jsp");
        login.forward(request,response);

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        if (request.getParameter("type").equals("login")){
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("pass"));
            if(action.Login(user)){
                response.sendRedirect("home");
            }else{
                response.sendRedirect("");
            }
        }
        if(request.getParameter("type").equals("logup")){
            if(!request.getParameter("pass").equals(request.getParameter("pass-confirm"))){
                response.sendRedirect("");
            }else{
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("pass"));
            user.setNom(request.getParameter("nom"));
            user.setPrenom(request.getParameter("prenom"));
            if(action.Logup(user)){
                response.sendRedirect("home");
            }else {
                response.sendRedirect("");
            }
            }

        }
    }
}
