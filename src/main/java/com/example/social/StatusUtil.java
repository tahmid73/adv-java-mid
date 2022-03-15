package com.example.social;

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
    private HttpServletRequest request;

    public boolean add(Status status, DataSource dataSource) throws SQLException {
        this.connection=dataSource.getConnection();
        String sql="INSERT INTO social.status(id,status,likes,created_on) VALUES (?,?,?,?)";
        //HttpSession session = request.getSession();
        this.preparedStatement = connection.prepareStatement(sql);
//        int userId = ;
        this.preparedStatement.setInt(1, 1);
        this.preparedStatement.setString(2, "status.getStatus()");
        out.println(status.getStatus());
        this.preparedStatement.setInt(3, 0);
        this.preparedStatement.setString(4, "Timestamp.from(Instant.now())");
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

