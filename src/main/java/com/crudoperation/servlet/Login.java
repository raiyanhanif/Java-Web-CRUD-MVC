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


@WebServlet("/login")

public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private static final String url="jdbc:mysql://localhost:3306/demo";
    private static final String username="root";
    private static final String password="Raiyan@9712";




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub


        String email = request.getParameter("email");
        String pass= request.getParameter("password");

        HttpSession session=request.getSession();


        RegisterDAO user = new RegisterDAO();
        user.setEmail(email);
        user.setPass(pass);

        RequestDispatcher dispatcher = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successfully Established");

            String query="select * from register where email =? AND password =?";

            PreparedStatement ps= connection.prepareStatement(query);
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getPass());


            ResultSet resultSet= ps.executeQuery();




            if(resultSet.next()) {
                request.setAttribute("status", "success");
                session.setAttribute("name", resultSet.getString("fname"));
                dispatcher = request.getRequestDispatcher("userList");

            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("index.jsp");
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


