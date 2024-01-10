package com.maiyon.demo_mvc_model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String fulName = "Nguyễn Hồng Quân";
        req.setAttribute("fullName", fulName);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
