<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<%@ include file="resources/bootstrap.min.css"%> 
</style>
</head>
<body>
<form action="" method="post">
Hello <c:out value="${userSession.name}"></c:out>
<table class="table">
<thead>
<tr class="active">

<th>
Name
</th>

<th>
Password
</th>

<th>
Email
</th>

<th>
 Country
</th>

<th>
Place
</th>

<th>
Delete
</th>

<th>
Update
</th>

</tr >
</thead>
<tbody>
<tr class="active">

<td>
<c:out value="${userSession.name}"></c:out>
</td>

<td>
<c:out value="${userSession.password}"></c:out>
</td>

<td>
<c:out value="${userSession.email}"></c:out>
</td>

<td>
<c:out value="${userSession.country}"></c:out>
</td>

<td>
<c:out value="${userSession.stateProv}"></c:out>
</td>

<td>
<input type="submit" onclick="this.form.action ='deleteUserTese'" value="Delete" id="del" name="del" />
</td>

<td>
<input type="submit" value="Update"  onclick="this.form.action ='goToUpUser'" id="up" name="up" />
</td>

</tr>
</tbody>
</table>


</form>
</body>
</html>