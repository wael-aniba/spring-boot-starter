<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
	<title>USER MANAGEMENT</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
	
	<div class="title">
		<h1><s:message code="project.title" arguments="user creation"/></h1>
	</div>
	
	<div>
		<s:message code="user.create"/><br/>
		<f:form method="post" action="/create" modelAttribute="userCreationForm">
		    <table class="bordered-table">
		    	<tr>
		    		<td><f:label path="name"><s:message code="user.name"/></f:label></td>
		    		<td><f:input path="name"/></td>
		    		<td><f:errors path="name" cssClass="error"/></td>
		    	</tr>
		    	<tr>
		    		<td><f:label path="login"><s:message code="user.login"/></f:label></td>
		    		<td><f:input path="login"/></td>
		    		<td><f:errors path="login" cssClass="error"/></td>
		    	</tr>
		    	<tr>
		    		<td><f:label path="password1"><s:message code="user.password1"/></f:label></td>
		    		<td><f:password path="password1"/></td>
		    		<td><f:errors path="password1" cssClass="error"/></td>
		    	</tr>
		    	<tr>
		    		<td><f:label path="password1"><s:message code="user.password2"/></f:label></td>
		    		<td><f:password path="password2"/></td>
		    		<td><f:errors path="password2" cssClass="error"/></td>
		    	</tr>	  
		    	<tr>
		    		<td colspan="3">
		    			<input type="submit"/>
		    		</td>
		    	</tr>  		    	
		    </table>
		    <f:errors cssClass="error" >
				<%-- <s:message code="user.error.duplicate.login" arguments="${userCreationForm.login}" /> --%>
		    </f:errors>
		</f:form>
	</div>
	
	<div>
		<a href="<s:url value="/all" />">
			<s:message code="user.list"/>
		</a>
	</div>	

</body>
</html>
