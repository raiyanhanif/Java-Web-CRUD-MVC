<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - Create Account</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/registeration.css">
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">


<div class="container">
    <!-- Left Panel with Info -->


    <!-- Right Panel with Form -->
    <div class="right-panel">


        <div class="form-header">
            <h1>Create Account</h1>
            <p>Fill in your details to get started</p>
        </div>

        <form id="registrationForm" action="register" method="post">
            <div class="name-group">
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <div class="input-with-icon">
                        <i class="fas fa-user"></i>
                        <input type="text" id="firstName" name="fname" class="form-control" placeholder="Enter your first name">
                    </div>
                    <div class="error" id="firstNameError">Please enter a valid first name</div>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <div class="input-with-icon">
                        <i class="fas fa-user"></i>
                        <input type="text" id="lastName" name="lname" class="form-control" placeholder="Enter your last name">
                    </div>
                    <div class="error" id="lastNameError">Please enter a valid last name</div>
                </div>
            </div>

            <div class="form-group">
                <label for="email">Email Address</label>
                <div class="input-with-icon">
                    <i class="fas fa-envelope"></i>
                    <input type="email" id="email" name="email" class="form-control" placeholder="Enter your email address">
                </div>
                <div class="error" id="emailError">Please enter a valid email address</div>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <div class="input-with-icon">
                    <i class="fas fa-lock"></i>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Create a strong password">
                </div>
                <div class="error" id="passwordError">Password must be at least 8 characters with uppercase, lowercase, and a number</div>
                <div class="password-rules">
                    <i class="fas fa-info-circle"></i> Must be at least 8 characters with uppercase, lowercase, and a number
                </div>
            </div>

            <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <div class="input-with-icon">
                    <i class="fas fa-lock"></i>
                    <input type="password" id="confirmPassword" class="form-control" placeholder="Re-enter your password">
                </div>
                <div class="error" id="confirmPasswordError">Passwords do not match</div>
            </div>

            <div class="terms">
                <input type="checkbox" id="terms">
                <label for="terms">I agree to the <a href="#">Terms of Service</a> and <a href="#">Privacy Policy</a></label>
            </div>

            <button type="submit" class="btn">Create Account</button>


        </form>

        <div class="login-link">
            Already have an account? <a href="index.jsp">Sign In</a>
        </div>

        <div class="social-login">
            <div class="social-btn google">
                <i class="fab fa-google"></i>
            </div>
            <div class="social-btn facebook">
                <i class="fab fa-facebook-f"></i>
            </div>
            <div class="social-btn twitter">
                <i class="fab fa-twitter"></i>
            </div>
        </div>
    </div>
</div>



<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
    var status = document.getElementById("status").value;
    if (status === "success") {
        swal("Congrats!", "Your Registration was Successful", "success");
    } else if (status === "failed") {
        swal("Error", "Something went wrong with the registration", "error");
    }
</script>


</body>
</html>