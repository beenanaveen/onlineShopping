<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping -${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- For glyphicons not supported in bootstrap4 so use Font awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- bootstrap readable theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- data table bootstrap css -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
<!--  
 
 <link href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css ">
 
 -->
</head>

<body>
	<div class="wrapper">

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${contextRoot}/home">Start
					Bootstrap</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li id="home" class="nav-item"><a class="nav-link"
							href="${contextRoot}/home">Home <span class="sr-only">(current)</span>
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr/>
							<blockquote style="word-wrap: break-word">
								${errorDescription}
							</blockquote>
						</div>
					</div>
				</div>
			</div>
			
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- Data table plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		<!-- Data table bootstrap js -->
		<script src="${js}/dataTables.bootstrap4.js"></script>

		<!--  <!--This is for online -->
		<script
			src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js "></script>
		<script
			src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js "></script>
	
		<!-- Custom javascript -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>