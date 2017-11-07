<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
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

	<div class="container top">
		<div class="row">
			<div class="col-3">
				<strong>Entreprise</strong> <br>
				${bulletin.remunerationEmploye.entreprise.denomination} <br>
				SIRET : ${bulletin.remunerationEmploye.entreprise.siret}
			</div>
			<div class="col-3 offset-6">
				<strong>Période</strong><br> Du
				${bulletin.periode.dateDebutFormat} au
				${bulletin.periode.dateDebutFormat} <br> <br> <strong>Matricule
					: ${bulletin.remunerationEmploye.matricule}</strong>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<h3>Salaire</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr style="background: #cccccc;">
							<td>Rubriques</td>
							<td>Base</td>
							<td>Taux Salarial</td>
							<td>Montant Salarial</td>
							<td>Taux patronal</td>
							<td>Cot. patronales</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Salaire de base</td>
							<td>${bulletin.remunerationEmploye.grade.nbHeuresBase}</td>
							<td>${bulletin.remunerationEmploye.grade.tauxBase}</td>
							<td>${resultatCalculRemuneration.salaireDeBase}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Prime Except.</td>
							<td></td>
							<td></td>
							<td>${bulletin.primeExceptionnelle}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Salaire Brut</td>
							<td></td>
							<td></td>
							<td>${resultatCalculRemuneration.salaireBrut}</td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>

				<h3>Cotisations</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr style="background: #cccccc;">
							<td>Rubriques</td>
							<td>Base</td>
							<td>Taux Salarial</td>
							<td>Montant Salarial</td>
							<td>Taux patronal</td>
							<td>Cot. patronales</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cotisationsNonImposables}" var="cotisation">
							<tr>
								<td>${cotisation.code}-${cotisation.libelle}</td>
								<td>${resultatCalculRemuneration.salaireBrut}</td>
								<td>${cotisation.tauxSalarial}</td>
								<td><c:if test="${cotisation.tauxSalarial != null}">
										${resultatCalculRemuneration.salaireBrut * cotisation.tauxSalarial}
									</c:if></td>
								<td>${cotisation.tauxPatronal}</td>
								<td><c:if test="${cotisation.tauxPatronal != null}">
										${resultatCalculRemuneration.salaireBrut * cotisation.tauxPatronal}
									</c:if></td>
							</tr>
						</c:forEach>
						<tr>
							<td>Total Retenue</td>
							<td></td>
							<td></td>
							<td>${resultatCalculRemuneration.totalRetenueSalarial}</td>
							<td></td>
							<td>${resultatCalculRemuneration.totalCotisationsPatronales}</td>
						</tr>

					</tbody>
				</table>
				<h3>NET Imposable : ${resultatCalculRemuneration.netImposable}
					€</h3>
				<table class="table table-bordered table-hover">
					<thead>
						<tr style="background: #cccccc;">
							<td>Rubriques</td>
							<td>Base</td>
							<td>Taux Salarial</td>
							<td>Montant Salarial</td>
							<td>Taux patronal</td>
							<td>Cot. patronales</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cotisationsImposables}" var="cotisation">
							<tr>
								<td>${cotisation.code}-${cotisation.libelle}</td>
								<td>${resultatCalculRemuneration.salaireBrut}</td>
								<td>${cotisation.tauxSalarial}</td>
								<td><c:if test="${cotisation.tauxSalarial != null}">
										${resultatCalculRemuneration.salaireBrut * cotisation.tauxSalarial}
									</c:if></td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="col-3 offset-9" style="text-align: right;">
					<strong>NET A PAYER :
						${resultatCalculRemuneration.netAPayer} €</strong>
				</div>
			</div>
		</div>
	</div>
</body>
</html>