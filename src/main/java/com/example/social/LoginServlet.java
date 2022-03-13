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
import java.sql.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Resource(name="jdbc/social")


    private DataSource dataSource;
    private int id;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserUtil userUtil = new UserUtil();
        boolean result = false;
        try {
            result = userUtil.isValidUser(email, password, dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        if (result) {
            session.setAttribute("email",email);
//            try {
//                id=getUserData(email,password,dataSource);
//
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            log(String.valueOf(id));
            session.setAttribute("id",id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);
            //session

        }
        else {
            session.setAttribute("error", "Login Failed!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    public int getUserData(String email,String password, DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "SELECT id FROM social.users where email = ? and password = ?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, email);
        this.preparedStatement.setString(2, password);
        ResultSet resultDB = this.preparedStatement.executeQuery();
        log(String.valueOf(resultDB.getInt(1)));
        return resultDB.getInt(1);
    }
}
