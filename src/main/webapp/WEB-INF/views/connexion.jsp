<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="script.jsp"></jsp:include>

<title>Paie - App</title>
</head>

<body class="container">
	<form method="post" class="top">
		<sec:csrfInput />
		<div>
			<div class="row">
				<div class="col-6 offset-3">
					<label class="control-label" for="username">Utilisateur</label> <input
						id="username" name="username" type="text"
						placeholder="Nom d'utilisateur" class="form-control input-md"
						required>
				</div>
			</div>

			<div class="row">
				<div class="col-6 offset-3">
					<label class="control-label" for="password">Mot de passe</label> <input
						id="password" name="password" type="password"
						placeholder="Mot de passe" class="form-control input-md" required>
				</div>
			</div>
			<div class="col-6 offset-3 top">
				<input type="submit" class="btn btn-success float-right" value="Se connecter">
			</div>
			
		</div>
	</form>
</body>
</html>