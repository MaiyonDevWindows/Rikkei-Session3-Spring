package com.maiyon.demo_mvc_model;

import com.maiyon.demo_mvc_model.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private List<Student> students = new ArrayList<>();

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", students);
        for (Student student : students) {
            System.out.println(student.getStudentName());
        }
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        int age = Integer.parseInt(req.getParameter("age"));
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        doGet(req, resp);
    }
}
