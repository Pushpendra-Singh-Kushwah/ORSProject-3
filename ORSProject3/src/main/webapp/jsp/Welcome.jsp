<%@page import="com.rays.project3.controller.ORSView"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/resources/demos/style.css">
<style>
.p4 {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/ac.jpg');
	background-size: 100%;
}

.cl {
	/* font-family: Lucida Calligraphy; */
	/* font-family: Monotype Corsiva;
 */
	font-family: Footlight MT Light;
}
</style>

</head>
<body class="p4">
	<div class="header">
		<%@include file="Header.jsp"%>
	</div>
	<div class="text-cs1">
		<center>
			<h1 style="padding-top: 15%; color: Red;">
				<b class="cl">Welcome to ORS</b>
			</h1>
		</center>
	</div>
	<div class="footer">
		<%@include file="Footer.jsp"%>
	</div>
</body>

</html>