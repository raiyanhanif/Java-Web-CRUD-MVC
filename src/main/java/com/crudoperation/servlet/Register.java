package com.crudoperation.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.crudoperation.model.RegisterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")

public class Register extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private static final String url="jdbc:mysql://localhost:3306/demo";
    private static final String username="YOUR_USERNAME_HERE";
    private static final String password="YOUR_PASSWORD_HERE";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub

        String fname=request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pass= request.getParameter("password");


        RegisterDAO user = new RegisterDAO();
        user.setFname(fname);
        user.setLname(lname);
        user.setEmail(email);
        user.setPass(pass);

        RequestDispatcher dispatcher = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successfully Established");

            String query="insert into register(fname,lname,email,password) VALUES(?,?,?,?)";

            PreparedStatement ps= connection.prepareStatement(query);
            ps.setString(1,user.getFname());
            ps.setString(2,user.getLname());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getPass());

            int rows = ps.executeUpdate();

            dispatcher = request.getRequestDispatcher("Registeration.jsp");
            if(rows > 0) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
            }

            ps.close();
            connection.close();

            dispatcher.forward(request,response);

        } catch(SQLException e) {
            request.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("Registeration.jsp");
            e.printStackTrace();

        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

