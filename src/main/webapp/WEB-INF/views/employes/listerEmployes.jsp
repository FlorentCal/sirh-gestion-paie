<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../script.jsp"></jsp:include>

<title>SGP - Paie</title>
</head>
<body>

	<c:set value="employesActive" var="tabActive" scope="request"></c:set>
	<c:import url="../navBar.jsp"></c:import>

	<div class="container">
		<sec:authorize access="hasRole('ROLE_ADMINISTRATEUR')">
			<div class="row">
				<div class="col">
					<a class="btn btn-primary float-right"
						href="<c:url value='/mvc/employes/creer'/>">Ajouter un employé</a>
				</div>	
			</div>
		</sec:authorize>

		<div class="row top">
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="grey">
						<td>Date/heure création</td>
						<td>Matricule</td>
						<td>Grade</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employe" items="${employes}">
						<tr>
							<td>${employe.dateHeureCreationFormat}</td>
							<td>${employe.matricule}</td>
							<td>${employe.grade.code}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>