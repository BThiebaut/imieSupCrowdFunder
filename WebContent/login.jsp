<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SupCrowdFunder | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="hold-transition login-page">
  	<c:if test="${!empty requestScope.error}" >
  		<div class="alert alert-danger text-center"><c:out value="${requestScope.errorMsg}" /></div>
  	</c:if>
  
  	<c:if test="${!empty requestScope.sign}" >
	    <div class="login-box">
	      <div class="login-logo">
	        <a href="index2.html"><b>Sup</b>CrowdFunder</a>
	      </div><!-- /.login-logo -->
	      <div class="login-box-body">
	        <p class="login-box-msg">Sign in to start your session</p>
	        <form action="/SupCrowdFunder/login" method="post">
	          <div class="form-group has-feedback">
	            <input type="email" class="form-control" placeholder="Email" name="mail">
	            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	          </div>
	          <div class="form-group has-feedback">
	            <input type="password" class="form-control" placeholder="Password" name="password">
	            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	          </div>
	          <input type="hidden" name="action" value="sign"/>
	          <div class="row">
	            <div class="col-xs-8">
	              <div class="checkbox icheck">
	                <label>
	                  <input type="checkbox"> Remember Me
	                </label>
	              </div>
	            </div><!-- /.col -->
	            <div class="col-xs-4">
	              <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
	            </div><!-- /.col -->
	          </div>
	        </form>
	        <a href="/SupCrowdFunder/login?action=create" class="text-center">Create account</a>
	
	      </div><!-- /.login-box-body -->
	    </div><!-- /.login-box -->
	</c:if>
	
  	<c:if test="${!empty requestScope.create}" >
		<div class="login-box">
	      <div class="login-logo">
	        <a href="index2.html"><b>Sup</b>CrowdFunder</a>
	      </div><!-- /.login-logo -->
	      <div class="login-box-body">
	        <p class="login-box-msg">Create an account</p>
	        <form action="/SupCrowdFunder/login" method="post">
	          <div class="form-group has-feedback">
	            <input type="text" class="form-control" placeholder="FirstName" name="firstname" required>
	            <span class="glyphicon glyphicon-user form-control-feedback"></span>
	          </div>
	          <div class="form-group has-feedback">
	            <input type="text" class="form-control" placeholder="LastName" name="lastname" required>
	            <span class="glyphicon glyphicon-user form-control-feedback"></span>
	          </div>
	          <div class="form-group has-feedback">
	            <input type="email" class="form-control" placeholder="Email" name="mail" required>
	            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	          </div>
	          <div class="form-group has-feedback">
	            <input type="password" class="form-control" placeholder="Password" name="password" required>
	            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	          </div>
	          <div class="form-group has-feedback">
	            <input type="password" class="form-control" placeholder="Repeat Password" name="passwordrepeat" required>
	            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	          </div>
	          <input type="hidden" name="action" value="create"/>
	          <div class="row">
	          	<div class="col-xs-8">
	          		All fields are required
	          	</div>
	            <div class="col-xs-4">
	              <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
	            </div><!-- /.col -->
	          </div>
	        </form>
	        <a href="/SupCrowdFunder/login?action=create" class="text-center">Create account</a>
	
	      </div><!-- /.login-box-body -->
	    </div><!-- /.login-box -->
	</c:if>
	
	
    <!-- jQuery 2.1.4 -->
    <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="plugins/iCheck/icheck.min.js"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>
