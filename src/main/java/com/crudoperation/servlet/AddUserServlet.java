package com.crudoperation.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.crudoperation.model.RegisterDAO;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/addList")

public class AddUserServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private static final String url="jdbc:mysql://localhost:3306/demo";
    private static final String username="YOUR_USERNAME_HERE";
    private static final String password="YOUR_PASSWORD_HERE";




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub


        String name = request.getParameter("name");
        String email= request.getParameter("email");
        String contact = request.getParameter("contact");


        HttpSession session=request.getSession();


        RegisterDAO user = new RegisterDAO();

        user.setFname(name);
        user.setEmail(email);
        user.setContact(contact);


        RequestDispatcher dispatcher = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successfully Established");

            String query="insert into user(name,email,contact) values(?,?,?) ";

            PreparedStatement ps= connection.prepareStatement(query);
            ps.setString(1,user.getFname());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getContact());

            int rows = ps.executeUpdate();
            if(rows > 0) {
                request.setAttribute("status", "success");
                dispatcher = request.getRequestDispatcher("userList");

            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("AddUser.jsp");
            }

            ps.close();
            connection.close();

            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }

        } catch(SQLException e) {
            request.setAttribute("status", "failed");
            e.printStackTrace();

        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}


