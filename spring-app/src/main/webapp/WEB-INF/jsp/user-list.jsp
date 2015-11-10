<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>USER MANAGEMENT</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>

	<div class="title">
		<h1><s:message code="project.title" arguments="list of users"/></h1>
	</div>
	
	<div>
	    <table class="bordered-table">
	    	<thead>
	    		<s:message code="user.list"/>
	    	</thead>
	    	<tr>
	    		<th>ID</th>
	    		<th>NAME</th>
	    		<th>LOGIN</th>
	    	</tr>
		    <c:forEach items="${users}" var="user">
			    <tr>
		    		<td><c:out value="${user.getId()}"/></td>
		    		<td><c:out value="${user.name}"/></td>
		    		<td><c:out value="${user.login}"/></td>		
		    	</tr>		    
		    </c:forEach>
	    </table>		
	</div>
	
	<div>			
		<a href="<s:url value="/create" />">
			<s:message code="user.create"/>
		</a>
	</div>
	
</body>
</html>