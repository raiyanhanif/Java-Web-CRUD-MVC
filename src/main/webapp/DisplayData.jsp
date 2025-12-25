<%
    // Prevent caching so user can't go back after logout
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    if(session.getAttribute("name") == null) {
        response.sendRedirect("login.jsp");
        return; // Stop further execution
    }


%>
<%@page import="java.util.*" %>
<%@page import="com.crudoperation.model.RegisterDAO" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>User Management Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/table.css">
</head>

<body>

<div class="container">
    <header>
        <h1>User Management Dashboard</h1>
        <p>View-Add-Edit Users</p>
    </header>

    <div class="user-controls">
        <h3>Total Users: <span id="totalUsers">2</span></h3>
        <button id="addUserBtn"><i class="fa fa-user-plus"></i><a href="AddUser.jsp"></a>Add New User </button>

    </div>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<RegisterDAO> users = (List<RegisterDAO>) request.getAttribute("users");

            for(RegisterDAO u:users)
            {

        %>
        <tr>
            <td><%=u.getId()%></td>
            <td><%=u.getFname()%></td>
            <td><%=u.getEmail()%></td>
            <td><%=u.getContact()%></td>
            <td class="actions">
                <button class="edit">
                    <a href="editUser?id=<%=u.getId()%>"><i class="fa fa-edit"></i></a>

                </button>
                <button class="delete">
                    <a href="deleteUser?id=<%=u.getId()%>"><i class="fa fa-trash"></i></a>

                </button>
            </td>
        </tr>

        <%
            }
        %>

        </tbody>
    </table>
</div>

<script>
    document.getElementById("addUserBtn").onclick = () => {
        window.location.href = "AddUser.jsp";
    };

    function editUser(id) {
        window.location.href = "EditUser.jsp";
    }
</script>

</body>

</html>