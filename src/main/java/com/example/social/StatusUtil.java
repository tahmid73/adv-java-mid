package com.example.social;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.time.Instant;

import static java.lang.System.out;

public class StatusUtil {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    //private HttpServletRequest request;

    public boolean add(Status status, DataSource dataSource, HttpServletRequest request) throws SQLException {
        this.connection=dataSource.getConnection();
        String sql="INSERT INTO social.status(status,likes,email) VALUES (?,?,?)";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, status.getStatus());
        out.println(status.getStatus());
        this.preparedStatement.setInt(2, 0);
        this.preparedStatement.setString(3, request.getSession().getAttribute("email").toString());
        boolean result = this.preparedStatement.execute();
        this.close();
        return result;

    }

    private void close() throws SQLException {
        if (this.connection != null)
            this.connection.close();
        if (this.preparedStatement != null)
            this.preparedStatement.close();
        if (this.statement != null)
            this.statement.close();
    }

}

