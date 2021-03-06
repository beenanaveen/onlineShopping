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
	window.contextRoot='${contextRoot}';
</script>

<!-- For glyphicons not supported in bootstrap4 so use Font awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
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
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>


		<!-- Page Content -->
		<!-- Loading home content -->
		<div class="content">
			<c:if test="${userClicksHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- About.jsp -->
			<c:if test="${userClicksAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- contact.jsp -->
			<c:if test="${userClicksContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- listAllProducts.jsp -->
			<c:if test="${userClicksAllProducts==true or userClicksCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- Display single product -->
			<c:if test="${userClicksShowProduct==true}">
				<%@include file="singleProduct.jsp" %>
			</c:if>
			
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
 		<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js "></script>
 		<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js "></script> -->
		<!-- Custom javascript -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>