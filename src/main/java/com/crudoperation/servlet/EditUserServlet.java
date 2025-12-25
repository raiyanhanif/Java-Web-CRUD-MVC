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

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String url = "jdbc:mysql://localhost:3306/demo";
    private final String dbUser = "root";
    private final String dbPass = "Raiyan@9712";

    // 1. FETCH DATA: This runs when you click "Edit" from your table/list
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUser, dbPass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // BE CAREFUL: These "keys" (the first string) must match the JSP exactly
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("name", rs.getString("name"));
                request.setAttribute("email", rs.getString("email")); // check if column is 'email'
                request.setAttribute("contact", rs.getString("contact")); // check if column is 'contact'
            }
            con.close();
            RequestDispatcher rd = request.getRequestDispatcher("EditUser.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 2. UPDATE DATA: This runs when you click the "Update Details" button
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, dbUser, dbPass);

            // FIX: The order here must match your SQL ? placeholders
            String query = "UPDATE user SET name=?, email=?, contact=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, contact);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                // Redirect back to your display list page after success
                response.sendRedirect("userList");


            } else {
                response.sendRedirect("EditUser.jsp?status=failed");
            }
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}