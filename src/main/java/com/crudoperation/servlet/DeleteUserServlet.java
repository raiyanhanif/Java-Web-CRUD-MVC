package com.crudoperation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String url = "jdbc:mysql://localhost:3306/demo";
    private final String dbUser = "root";
    private final String dbPass = "Raiyan@9712";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. URL se ID pakdo
        String id = request.getParameter("id");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUser, dbPass);

            // 2. Delete Query
            String query = "DELETE FROM user WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);

            int rows = ps.executeUpdate();

            con.close();

            // 3. Wapas list par bhej do
            response.sendRedirect("userList?status=deleted");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("userList?status=error");
        }
    }
}