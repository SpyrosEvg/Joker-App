<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>

</head>

<body>


	

	id : ${id} ||
	Date: ${drawTime}
	<%--  <table>
		<tr>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>Bonus</th>
			
			
		</tr>
		
		
		<tr>
			<td>${FirstNum}</td>
			<td>${SecondNum}</td>
			<td>${ThirdNum}</td>
			<td>${ForthNum}</td>
			<td>${FifthNum}</td>
			<td>${bonus}</td>
		</tr>
	</table>  --%>
	
	<hr>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Divident</th>
			<th>Winners</th>
			<th>Distributed</th>
			<th>Jackpot</th>
		</tr>

		<c:forEach var="tempPrize" items="${prize}">
			<tr>
				<td>${tempPrize.id}</td>
				<td>${tempPrize.divident}</td>
				<td>${tempPrize.winners}</td>
				<td>${tempPrize.distributed}</td>
				<td>${tempPrize.jackpot}</td>
			</tr>
		</c:forEach>
	</table> 
	
	 <table>
		<tr>
			<th>1st </th>
			<th>2nd </th>
			<th>3rd </th>
			<th>4th </th>
			<th>5th </th>
			<th>Bonus</th>
		</tr>
		
		<c:forEach var = "i" begin = "0" end = "4">
				<td>${numberList[i]}</td>
		</c:forEach>
		<c:forEach var = "i" begin = "0" end = "1">
				<td>${bonus[i]}</td>
		</c:forEach>
	</table> 
	
	
</body>
</html>