<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/theme.css">

<div class="container">
	<div class="form-inline">
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item"><a
				class="nav-link <c:if test="${tabActive == 'employesActive'}">active</c:if>"
				id="home-tab" href="/paie/mvc/employes/lister" role="tab"
				aria-controls="home" aria-selected="true">Employés </a></li>
			<li class="nav-item"><a
				class="nav-link <c:if test="${tabActive == 'bulletinsActive'}">active</c:if>"
				id="profile-tab" href="/paie/mvc/bulletins/lister" role="tab"
				aria-controls="profile" aria-selected="false">Bulletins</a></li>
		</ul>
	</div>

	<div class="row">
		<h1 class="col-10 offset-1" style="text-align: center;">${titre}</h1>
	</div>
</div>