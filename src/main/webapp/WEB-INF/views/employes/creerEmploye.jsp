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
	<sec:csrfInput />

	<div class="container top">
		<form class="form-horizontal" method="post">
			<div class="row form-group">
				<label class="col-2 control-label" for="matricule">Matricule</label>
				<div class="col-10">
					<input id="matricule" name="matricule" type="text"
						placeholder="Matricule" class="form-control input-md" required>
				</div>
			</div>

			<div class="row form-group">
				<label class="col-2 control-label" for="entreprise">Entreprise</label>
				<div class="col-10">
					<select id="entreprise" name="entreprise" class="form-control">
						<c:forEach var="entreprise" items="${entreprises}">
							<option value="${entreprise.id}">${entreprise.denomination}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row form-group">
				<label class="col-2 control-label" for="profil">Profil</label>
				<div class="col-10">
					<select id="profil" name="profil" class="form-control">
						<c:forEach var="profil" items="${profils}">
							<option value="${profil.id}">${profil.code}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row form-group">
				<label class="col-2 control-label" for="grade">Grade</label>
				<div class="col-10">
					<select id="grade" name="grade" class="form-control">
						<c:forEach var="grade" items="${grades}">
							<option value="${grade.id}">${grade.code} - ${grade.salaireAnnuel} € / an</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<input type="submit" class="btn btn-success float-right" value="Ajouter">
				</div>
			</div>
		</form>
	</div>
</body>
</html>