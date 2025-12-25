package com.crudoperation.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.crudoperation.model.RegisterDAO;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userList")
public class Display extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private static final String username = "YOUR_USERNAME_HERE";
    private static final String password = "YOUR_PASSWORD_HERE";

    // CHANGE: doPost ko doGet kar diya taaki redirect yahan kaam kare
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RegisterDAO> userList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "select * from user";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                RegisterDAO user = new RegisterDAO();
                user.setId(resultSet.getInt("id"));
                user.setFname(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setContact(resultSet.getString("contact"));
                userList.add(user);
            }

            resultSet.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Pass data to JSP
        request.setAttribute("users", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayData.jsp");
        dispatcher.forward(request, response);
    }

    // Optional: Agar aap POST se bhi data mangwana chahte ho toh doGet ko call kar lo
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}