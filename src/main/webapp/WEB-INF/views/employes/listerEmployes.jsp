<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ajout.css">>

<jsp:include page="../script.jsp"></jsp:include>

<title>SGP - Paie</title>
</head>
<body>
	<c:import url="../navBar.jsp"></c:import>

	<div class="container">
		<div class="row">
			<a class="col-2 offset-10 btn btn-primary"
				href="<c:url value='/mvc/employes/creer'/>">Ajouter un employé</a>
		</div>

		<div class="row">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
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