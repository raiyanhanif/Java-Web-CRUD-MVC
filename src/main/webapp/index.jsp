<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Secure Access</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">

<div class="login-container">
    <!-- Left Section with info -->
    <div class="left-section">
        <h1>Welcome Back</h1>
        <p>Sign in to your account to access your personalized dashboard, settings, and more.</p>

        <div class="features">
            <div class="feature">
                <i class="fas fa-shield-alt"></i>
                <div class="feature-text">
                    <h3>Secure Access</h3>
                    <p>Your data is protected with industry-standard encryption.</p>
                </div>
            </div>
            <div class="feature">
                <i class="fas fa-bolt"></i>
                <div class="feature-text">
                    <h3>Fast & Reliable</h3>
                    <p>Experience lightning-fast performance across all devices.</p>
                </div>
            </div>
            <div class="feature">
                <i class="fas fa-headset"></i>
                <div class="feature-text">
                    <h3>24/7 Support</h3>
                    <p>Get help anytime from our dedicated support team.</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Right Section with login form -->
    <div class="right-section">
        <div class="login-header">
            <h2>Sign In</h2>
            <p>Enter your credentials to access your account</p>
        </div>

        <form class="login-form" action="login" method="post">
            <div class="input-group">
                <i class="fas fa-user"></i>
                <input type="email" id="email" name="email" placeholder="Enter your email" required>
            </div>

            <div class="input-group">
                <i class="fas fa-lock"></i>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
                <span class="password-toggle" id="togglePassword">
                        <i class="fas fa-eye"></i>
                    </span>
            </div>



            <button type="submit" class="submit-btn">Sign In</button>
        </form>

        <div class="divider">Or sign in with</div>

        <div class="social-login">
            <a href="#" class="social-btn google">
                <i class="fab fa-google"></i>
            </a>
            <a href="#" class="social-btn facebook">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a href="#" class="social-btn twitter">
                <i class="fab fa-twitter"></i>
            </a>
        </div>

        <div class="signup-link">
            Don't have an account? <a href="Registeration.jsp">Sign up now</a>
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