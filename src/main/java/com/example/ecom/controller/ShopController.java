package com.example.ecom.controller;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


public class ShopController extends HttpServlet {
    private String message;

    public void init(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher shop= request.getRequestDispatcher("templates/shop.jsp");
        shop.forward(request,response);

    }

    public void destroy() {
    }
}