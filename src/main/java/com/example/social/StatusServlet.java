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
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/statusPost")
public class StatusServlet extends HttpServlet {
    @Resource(name="jdbc/social")
    private DataSource dataSource;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Status status=new Status(request.getParameter("statusUpdates"),0);
        StatusUtil statusUtil = new StatusUtil();
//        PrintWriter out= response.getWriter();
//        out.println(request.getParameter("statusUpdates"));
        try{
            statusUtil.add(status,dataSource,request);
        }catch(SQLException e){
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("success", "status published");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
