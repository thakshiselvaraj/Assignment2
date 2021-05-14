
<%@page import="com.Investor"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 
<link rel="stylesheet" href="Views/bootstrap.min.css">
<link rel="stylesheet" href="Views/bootstrap.min.js">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/jquery-3.2.1.js"></script>
<script src="Components/Investors.js"></script>
<meta charset="ISO-8859-1">
<title>Investor service</title>
</head>
<body>
	
<div class="container">
<div class="row">
	
	<div class="col-8">
	<form id="formItem" name="formItem">
			<h1>INVESTOR SERVICE </h1>
			 Investor Name: 
			<input id="investorName" name="investorName" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Mail: 
			<input id="Mail" name="Mail" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Project Code: 
			<input id="ProjectCode" name="ProjectCode" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Project Name: 
			<input id="ProjectName" name="ProjectName" type="text" 
			 class="form-control form-control-sm">
			<br>
			
			<br> Invest Amount: 
			<input id="InvestAmount" name="InvestAmount" type="text" 
			 class="form-control form-control-sm">
			<br>
			
			<input id="btnSave" name="btnSave" type="button" value="Save" 
			 class="btn btn-primary">
			<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
			
			<div id="alertSuccess" class="alert alert-success"></div>
			<div id="alertError" class="alert alert-danger"></div>
			</form>
			
			
			<br>
			<div id="divItemsGrid">
			<%
				Investor itemObj = new Investor();
				out.print(itemObj.readInvestor());
			%>	
			</div>
			
			
			
			
	
		</div>

	</div>

</div>
	
</body>
</html>