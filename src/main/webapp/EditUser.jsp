<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    // Fetching attributes manually to ensure they exist
    Object id = request.getAttribute("id");
    Object name = request.getAttribute("name");
    Object email = request.getAttribute("email");
    Object contact = request.getAttribute("contact");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/registerationstyle.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h1><i class="fas fa-user-edit"></i> Update Account</h1>
        <p>Updating ID: <%= (id != null) ? id : "Not Found" %></p>
    </div>


    <form class="registration-form" id="registrationForm" method="post" action="editUser">

        <input type="hidden" name="id" value="<%= id %>">

        <div class="form-group">
            <label for="name">Full Name</label>
            <div class="input-icon"><i class="fas fa-user"></i></div>
            <input type="text" id="name" name="name" value="<%= (name != null) ? name : "" %>" required>
        </div>

        <div class="form-group">
            <label for="email">Email Address</label>
            <div class="input-icon"><i class="fas fa-envelope"></i></div>
            <input type="email" id="email" name="email" value="<%= (email != null) ? email : "" %>" required>
        </div>

        <div class="form-group">
            <label for="contact">Contact Number</label>
            <div class="input-icon"><i class="fas fa-phone"></i></div>
            <input type="tel" id="contact" name="contact" value="<%= (contact != null) ? contact : "" %>" required>
        </div>

        <button type="submit" class="submit-btn">Update Details</button>
    </form>
</div>

<script>
    // Simplified validation: only block if invalid
    document.getElementById('registrationForm').addEventListener('submit', function(event) {
        const name = document.getElementById('name').value;
        if (name.length < 2) {
            alert("Please enter a valid name");
            event.preventDefault(); // Stop only if there is an error
        }
        // If valid, the form will naturally submit to 'editList'
    });
</script>
</body>
</html>