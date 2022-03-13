package com.example.social;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signup")
public class RegistrationServlet extends HttpServlet {

    @Resource(name = "jdbc/social")
    private DataSource dataSource;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/signup.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User(request.getParameter("username"),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("dob"),request.getParameter("email"),request.getParameter("password"));
        UserUtil userUtil = new UserUtil();
        try{
            userUtil.create(user,dataSource);
        }catch(SQLException e){
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("success", "Registration Successful");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/signup.jsp");
        requestDispatcher.forward(request, response);
    }
}

