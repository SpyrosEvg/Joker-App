<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<style>
		.a{
			text-align:center;
		}
		
		table {
 		 	margin-left: auto; 
  			margin-right: auto;
  			width: 80%;
  			font-family: Calibri;
  			
		}
		th {
  				background-color: black;
  				color: green;
  			}
  			
  		td{
  			border-bottom: 1px solid ;
  		}
		
	</style>
</head>

<body>
	

 <div class="a">
	<c:forEach var="tempContent" items="${content}">
	
	
	

	id : ${tempContent.drawId} ||
	Date: ${tempContent.drawTime}
	
	<hr>
	
	<table class="table-dark" style="text-align: center;">
		<tr>
			<th>ID</th>
			<th>Divident</th>
			<th>Winners</th>
			<th>Distributed</th>
			<th>Jackpot</th>
		</tr>

		<c:forEach var="tempPrize" items="${tempContent.prizeCategories}">
			<tr>
				<td>${tempPrize.id}</td>
				<td>${tempPrize.divident}</td>
				<td>${tempPrize.winners}</td>
				<td>${tempPrize.distributed}</td>
				<td>${tempPrize.jackpot}</td>
			</tr>
		</c:forEach>
	</table> 
	<hr> 
	 <table class="table-dark">
		<tr>
			<th>1st </th>
			<th>2nd </th>
			<th>3rd </th>
			<th>4th </th>
			<th>5th </th>
			<th>Bonus</th>
		</tr>
		
		<c:forEach var = "i" begin = "0" end = "4">
				<td>${tempContent.winningNumbers.list[i]}</td>
		</c:forEach>
		<c:forEach var = "i" begin = "0" end = "1">
				<td>${tempContent.winningNumbers.bonus[i]}</td>
		</c:forEach>
	</table> 
	<br><br>
</c:forEach>
</body>
</html>