<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<html>
<table>
		<tr>
			<th>Occurrences</th>
			<th>Number</th>
		</tr>
		
		
		
		<c:forEach var="tempNumbers" items="${numbers}" >
					
					
			<tr>
				<td>${tempNumbers.occurrences}</td>
				<td>${tempNumbers.number}</td>
			</tr>
			
		</c:forEach>
	</table> 
</html>