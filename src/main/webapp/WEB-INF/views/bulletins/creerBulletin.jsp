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

	<c:set value="bulletinsActive" var="tabActive" scope="request"></c:set>
	<c:import url="../navBar.jsp"></c:import>
	<sec:csrfInput />

	<div class="container">
		<form class="form-horizontal" method="post">
			<div class="row form-group top">
				<label class="col-2 control-label" for="periode">Période</label>
				<div class="col-10">
					<select id="periode" name="periode" class="form-control">
						<c:forEach var="periode" items="${periodes}">
							<option value="${periode.id}">${periode.dateDebutFormat}
								- ${periode.dateFinFormat}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row form-group">
				<label class="col-2 control-label" for="employe">Matricule</label>
				<div class="col-10">
					<select id="employe" name="employe" class="form-control">
						<c:forEach var="employe" items="${employes}">
							<option value="${employe.id}">${employe.matricule}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row form-group">
				<label class="col-2 control-label" for="primeExceptionnelle">Prime
					exceptionnelle</label>
				<div class="col-10">
					<input id="primeExceptionnelle" name="primeExceptionnelle"
						type="number" step="0.01" min="0" value="0"
						placeholder="Prime exceptionnelle" class="form-control input-md"
						required>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<input type="submit" class="btn btn-success float-right"
						value="Créer">
				</div>
			</div>
		</form>

	</div>
</body>
</html>