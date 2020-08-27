<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function changeStateProv() {
	
	var states =["Idaho","Iowa","Alabama","Colorado","Minnesota"];
	var provs =["Calgary","Toronto","Ontario","Montreal","Quebec"];
	var resArr;
	var listCountry = document.getElementById("country");
	var listStateProv = document.getElementById("stateProv");
	if (listCountry.selectedIndex == 0) {
		resArr = states;
	} else {
		resArr = provs;
	}
	listStateProv.innerHTML = "";
	for (var i = 0; i < resArr.length; i++) {
		var ListElement = document.createElement("option");
		ListElement.value = resArr[i];
		ListElement.innerHTML = resArr[i];
		listStateProv.appendChild(ListElement);
	}
	
	
}
</script>
</head>
<body>
<f:form action="" method="post"  modelAttribute="regUser">
<br/><f:input path="name" placeholder="name" /><f:errors path="name" />
<br/><f:password path="password"  placeholder="password" /><f:errors path="password" />
<br/><f:input path="email"  placeholder="email"/><f:errors path="email" />
<br/>country: <f:select path="country" items="${countrys}" id = "country" onchange="changeStateProv()" >
</f:select><br>
<br/>place: <f:select path="stateProv" items="${states}"  id = "stateProv">
</f:select>

<br/><input type="submit" onclick="this.form.action = 'updateUser'" value="Update"  id="up"  name="up"/>
<br/><input type="submit" onclick="this.form.action = 'canselUpUse'"    value="Cansel"  id="cans"  name="cans" >
</f:form>
</body>
</html>