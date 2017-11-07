<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/theme.css">

<jsp:include page="../script.jsp"></jsp:include>

<title>SGP - Paie</title>

</head>
<body>

	<c:set value="bulletinsActive" var="tabActive" scope="request"></c:set>
	<c:import url="../navBar.jsp"></c:import>

	<div class="container">
		<div class="row">
			<a class="btn btn-primary col-3 offset-9"
				href="<c:url value='/mvc/bulletins/creer'/>">Créer un nouveau
				bulletin</a>
		</div>

		<div class="row top">
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="grey">
						<td>Date/heure création</td>
						<td>Période</td>
						<td>Matricule</td>
						<td>Salaire brut</td>
						<td>Net Imposable</td>
						<td>Net A payer</td>
						<td>Actions</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bulletin" items="${bulletins}">
						<tr>
							<td>${bulletin.key.dateHeureCreationFormat}</td>
							<td>${bulletin.key.periode.dateDebutFormat} - ${bulletin.key.periode.dateFinFormat}</td>
							<td>${bulletin.key.remunerationEmploye.matricule}</td>
							<td>${bulletin.value.salaireBrut}</td>
							<td>${bulletin.value.netImposable}</td>
							<td>${bulletin.value.netAPayer}</td>
							<td><a class="btn" href="<c:url value='/mvc/bulletins/visualiser/${bulletin.key.id}'/>">Visualiser</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>