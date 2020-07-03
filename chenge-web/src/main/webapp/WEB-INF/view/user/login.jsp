<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="en"><head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>陈哥商城登录</title>

    <link rel="canonical" href="https://v4.bootcss.com/docs/examples/floating-labels/">

    <!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >

	<meta name="theme-color" content="#563d7c">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resource/css/floating-labels.css" rel="stylesheet">
  </head>
  <body>
    <form class="form-signin" action="./login" method="post">
  <div class="text-center mb-4">
    <img class="mb-4" src="/resource/img/logo1.jpg" alt="" width="108" height="72">
    <h1 class="h3 mb-3 font-weight-normal">欢迎登录陈哥商城</h1>
  </div>

  <div class="form-label-group">
    <input type="text" id="inputEmail" class="form-control" name="username" placeholder="用户名"  required="" autofocus="">
    <label for="inputEmail">用户名</label>
  </div>
	
  <div class="form-label-group">
    <input type="password" id="inputPassword" class="form-control" name="password" placeholder="密码" required="">
    <label for="inputPassword">密码</label>
  </div>
  
 
  <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
  <p class="mt-5 mb-3 text-muted text-center">© 2017-2020</p>
</form>


</body></html>