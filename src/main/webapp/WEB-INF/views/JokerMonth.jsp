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
	
	<form action="${pageContext.request.contextPath}/joker/JokerMonthInput">
		<label for="year">Please Select Year and Month </label><br>
  		<select name="year" id="year">
  			<option value="2022">2022</option>
  			<option value="2021">2021</option>
  			<option value="2020">2020</option>
  			<option value="2019">2019</option>
  			<option value="2018">2018</option>
  			<option value="2017">2017</option>
  			<option value="2016">2016</option>
  		</select>
  		
  		<select name="month" id="month">
  			<option value="01">January</option>
  			<option value="02">February</option>
  			<option value="03">March</option>
  			<option value="04">April</option>
  			<option value="05">May</option>
  			<option value="06">June</option>
			<option value="07">July</option>
			<option value="08">August</option>
			<option value="09">September</option>
			<option value="10">October</option>
			<option value="11">November</option>
			<option value="12">December</option>
  		</select>
  		<input type="submit" value="Submit">
	</form>

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