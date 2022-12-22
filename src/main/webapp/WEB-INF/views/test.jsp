<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>

</head>

<body>
	id : ${id}
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
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>6</th>
			<th>7</th>
			<th>8</th>
			
			
		</tr>
		
		<c:forEach var="tempPrize" items="${prize}">
			<tr>
				<td>${tempPrize.id}</td>
				<td>${tempPrize.divident}</td>
			</tr>
		</c:forEach>
	</table> 
	
	 <table>
		<tr>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>Bonus</th>
		</tr>
		
		<c:forEach var = "i" begin = "0" end = "4">
				<td>${numberList[i]}</td>
		</c:forEach>
	</table> 
	
	
</body>
</html>