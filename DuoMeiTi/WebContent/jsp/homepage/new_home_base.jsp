<%@ include file="/jsp/base/taglib.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>Supermarket management system</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta name="description" content="">
    
    <meta name="keywords" content="">
    <meta name="author" content="">
    <!-- CSS Config. -->

    
 <!-- Le styles -->
 
         <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />		
		<link href="/datepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
        <script type='text/javascript' src="/js/base/jquery-2.1.4.min.js"></script>
        <script type='text/javascript' src="/datepicker/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="/datepicker/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

<link rel="stylesheet" type="text/css" media="screen" href="/new_homepage/style/common/base.css">
<link rel="stylesheet" type="text/css" media="screen" href="/new_homepage/style/common/content.css">
<link rel="stylesheet" type="text/css" media="screen" href="/new_homepage/style/home/content.css">


<style type="text/css">object,embed{-webkit-animation-duration:.001s;-webkit-animation-name:playerInserted;                -ms-animation-duration:.001s;-ms-animation-name:playerInserted;                -o-animation-duration:.001s;-o-animation-name:playerInserted;                animation-duration:.001s;animation-name:playerInserted;}                @-webkit-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @-ms-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @-o-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}</style></head>



<body>
<!--   <a href="/"> -->
<!--   	<div style="height:80px"></div> -->
<!--   </a> -->
    
    <div class="container" id="nav-container">
	       
	       
       <!--head content-->
       <div class="masthead">

			        
			   <div class="container">
			     <nav class="navbar navbar-default" role="navigation">
			       <div class="collapse navbar-collapse">
			         <ul class="nav navbar-nav">
			           <li class=""><a href="/">Homepage</a></li>


			           <li class="">
			           		<a href="/login">Login</a>
					   </li>
   			           <li class="">
			           		<a href="/login">Register</a>
					   </li>
			           
			           
			           
			           
			         </ul>
			       </div>
			     </nav>
			   </div><!--end navbar-->
   
       </div><!--end mashhead-->
    </div><!--end whole container-->
    
    


<div class="container home-content-container">
     
				
				<layout:block name="main_content">
				</layout:block>
   </div>
   
 
    
<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- <script type="text/javascript" src="/new_homepage/bootstrap/assets/js/bootstrap.min.js"></script> -->
<script type='text/javascript' src="/bootstrap/js/bootstrap.min.js"></script>
<script type='text/javascript' src="/js/base/tiny_mce.js"></script>
<!-- JQuery Masonry-->
<script type='text/javascript' src="/js/base/jquery.masonry.min.js"></script>
    
<script type="text/javascript" src="/new_homepage/js/features.js"></script>
   
    
</body></html>