<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <!--Made with love by Mutiullah Samim -->

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<form action="user" method="post">

    <div class="container">
        <div class="d-flex justify-content-center h-100">
            <div class="card">
                <div class="card-header">
                    <h3>Sign In</h3>
                    <div class="d-flex justify-content-end social_icon">
                        <span><i class="fab fa-facebook-square"></i></span>
                        <span><i class="fab fa-google-plus-square"></i></span>
                        <span><i class="fab fa-twitter-square"></i></span>
                    </div>
                </div>
                <div class="card-body">
                    <form>
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-user"></i></span>
                            </div>
                            <input type="text" class="form-control" name="userName" required="" placeholder="username">

                        </div>
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <input type="password" class="form-control" name="password" required="" placeholder="password">
                        </div>
                        <div class="form-group">
                            <input type="submit" value="login">
                        </div>
                        <input type="hidden" name="page" value="login">
                    </form>
                </div>
                <div class="card-footer">
                    <div class="d-flex justify-content-center links">
                        Don't have an account?<a href="user?page=newUsers">Sign Up</a>
                    </div>
                </div>
            </div>
        </div>
    </div>


<%--&lt;%&ndash;    hidden le hide garxa user bata&ndash;%&gt;--%>
<%--    <input type = "hidden" name="page" value="login">--%>
<%--&lt;%&ndash;    //required le chai etikai login huna dinna i.e. khali pani gayera database ma basirako thyo without required.&ndash;%&gt;--%>
<%--UserName    <input type="text" name="userName" required="" placeholder="Type in your username"></br>--%>
<%--Password    <input type="password" name="password" required="" placeholder="Type in your password"></br>--%>
<%--    <input type="submit" value="Login"></br>--%>
<%--    <a href="user?page=newUsers"> Not a member yet? <b> Register </b></a>--%>
</form>
</body>
</html>