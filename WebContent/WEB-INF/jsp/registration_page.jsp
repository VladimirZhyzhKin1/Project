<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="sourse/css/Style.css"/>

<fmt:setLocale value="${sessionScope.localLanguage}" />
<fmt:setBundle basename="localization.loc_bundle" var="locBundle" />

<fmt:message bundle="${locBundle}" key="loc.locbutton.ru" var="button_ru" />
<fmt:message bundle="${locBundle}" key="loc.locbutton.en" var="button_en" />
<fmt:message bundle="${locBundle}" key="registration.name" var="name" />
<fmt:message bundle="${locBundle}" key="registration.surname" var="surname" />
<fmt:message bundle="${locBundle}" key="registration.email" var="email" />
<fmt:message bundle="${locBundle}" key="registration.login" var="regLogin" />
<fmt:message bundle="${locBundle}" key="registration.password" var="regPassword" />
<fmt:message bundle="${locBundle}" key="registration.button.save" var="regSave" />
<fmt:message bundle="${locBundle}" key="SelectedNews.button.backToMainIndexPage" var="backToMainIndexPage" />
<fmt:message bundle="${locBundle}" key="registration.message" var="message" />

</head>
<body>
	<header class="header">
		<div class="container">
			<div>
				<div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="change_local" /> 
						<input type="hidden" name="local" value="ru" /> 
						<input type="hidden" name="redirectTo" value="command=registration" /> 
						<input type="submit" value="${button_ru}" /> <br />
					</form>
				</div>

				<div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="change_local" /> 
						<input type="hidden" name="local" value="en" /> 
						<input type="hidden" name="redirectTo" value="command=registration" /> 
						<input type="submit" value="${button_en}" /> <br />
					</form>
				</div>
				<nav>
					<a href="#"></a>
				</nav>
			</div>
		</div>
	
	</header>

	<div class="fon">
		<div class="main-title">
			<h1><c:out value="${message}" /></h1>
		</div>
		
		<form style="text-align: center" action="Controller" method="post">
			<input type="hidden" name="command" value="savenewuser" />
			<p><c:out value="${name}" />:</p>
			<input type="text" name="name" value="" />
			<p><c:out value="${surname}" />:</p>
			<input type="text" name="surname" value="" />
			<p><c:out value="${email}" />:</p>
			<input type="text" name="email" value="">
			<p title="<c:out value="${regLoginInfo}" />"><c:out value="${regLogin}" />:</p>
			<input type="text" name="login" value="">
			<p title="<c:out value="${regPasswordInfo}" />"><c:out value="${regPassword}" />:</p>
			<input type="password" name="password" value=""> <br /> 
			<input type="submit" value="${regSave}" /> <br />
		</form>

		<div align="center">
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="gotoindexpage" /> 
				<input type="submit" value="${backToMainIndexPage}" />
			</form>
		</div>
	</div>
	
		<!--Footer-->
	<footer class="footer-block">
		<div id="footer-text">
			<h5>2021 &copy; Vladimir Zhyzhkin</h5>
		</div>
	</footer>
	
</body>
</html>