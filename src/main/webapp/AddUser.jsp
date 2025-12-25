<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/registerationstyle.css">

</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
<div class="container">
    <div class="header">
        <h1><i class="fas fa-user-plus"></i> Create Account</h1>
        <p>Join our community by filling out the form below</p>
    </div>

    <form class="registration-form" id="registrationForm" action="addList" method="post">
        <div class="form-group">
            <label for="name">Full Name</label>
            <div class="input-icon">
                <i class="fas fa-user"></i>
            </div>
            <input type="text" id="name" name="name" placeholder="Enter your full name">
            <div class="validation-message" id="nameValidation"></div>
        </div>

        <div class="form-group">
            <label for="email">Email Address</label>
            <div class="input-icon">
                <i class="fas fa-envelope"></i>
            </div>
            <input type="email" id="email" name="email" placeholder="Enter your email address">
            <div class="validation-message" id="emailValidation"></div>
        </div>

        <div class="form-group">
            <label for="contact">Contact Number</label>
            <div class="input-icon">
                <i class="fas fa-phone"></i>
            </div>
            <input type="tel" id="contact" name="contact" placeholder="Enter your phone number">
            <div class="validation-message" id="contactValidation"></div>
        </div>

        <button type="submit" class="submit-btn">Register Now</button>
    </form>


</div>


<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">
    var status = document.getElementById("status").value;
    if (status === "success") {
        swal("Congrats!", "Your Registration was Successful", "success");
    } else if (status === "failed") {
        swal("Error", "Something went wrong", "error");
    }
</script>
</body>
</html>