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
	<c:import url="../navBar.jsp"></c:import>

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
							<option value="${grade.id}">${grade.code}-
								${grade.salaireAnnuel} € / an</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row col-2 offset-11">
				<div>
					<input type="submit" class="btn btn-success" value="Ajouter">
				</div>
			</div>
		</form>
	</div>
</body>
</html>