<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SupCrowdFunder</title>
	
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<c:if test="${empty requestScope.authFolder}" >
			<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
		    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
		    <link rel="stylesheet" href="dist/css/skins/skin-black.min.css">
			<link rel="stylesheet" href="dist/css/custom.css">
		</c:if>
		<c:if test="${!empty requestScope.authFolder}" >
			<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
		    <link rel="stylesheet" href="../font-awesome/css/font-awesome.min.css">
		    <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
		    <link rel="stylesheet" href="../dist/css/skins/skin-black.min.css">
			<link rel="stylesheet" href="../dist/css/custom.css">
		</c:if>
		
	    
	
	</head>
	
	<body class="hold-transition skin-black sidebar-mini">
    <div class="wrapper"> <!-- Close in footer -->