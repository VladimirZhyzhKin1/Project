<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="sourse/css/Style.css" />

<fmt:setLocale value="${sessionScope.localLanguage}" />
<fmt:setBundle basename="localization.loc_bundle" var="locBundle" />

<fmt:message bundle="${locBundle}" key="loc.locbutton.ru" var="button_ru" />
<fmt:message bundle="${locBundle}" key="loc.locbutton.en" var="button_en" />
<fmt:message bundle="${locBundle}" key="main.ReadMore" var="ReadMore" />
<fmt:message bundle="${locBundle}" key="main.Registration" var="registration" />
<fmt:message bundle="${locBundle}" key="main.NewsManagment" var="newsManagment" />
<fmt:message bundle="${locBundle}" key="main.logout" var="logout" />
<fmt:message bundle="${locBundle}" key="main.welcome" var="welcome" />
<fmt:message bundle="${locBundle}" key="main.login" var="enterLogin" />
<fmt:message bundle="${locBundle}" key="main.password" var="enterPass" />
<fmt:message bundle="${locBundle}" key="main.button.Enter" var="enter" />

</head>
<body>
	<header class="header">
		<div class="container">
			<div>
				<div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="change_local" /> 
						<input type="hidden" name="local" value="ru" /> 
						<input type="hidden" name="redirectTo" value="command=gotoindexpage" /> 
						<input type="submit" value="${button_ru}" /> <br />
					</form>
				</div>

				<div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="change_local" /> 
						<input type="hidden" name="local" value="en" /> 
						<input type="hidden" name="redirectTo" value="command=gotoindexpage" /> 
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
			<h1><c:out value="${newsManagment}" /></h1>
		</div>

		<div class="message-style">
			<%
			String message = (String) request.getParameter("message");

			if (message != null) {
				out.write(message);
			}
			%>
		</div>

		<br />

			<div class="login-block">
				<c:if test="${sessionScope.auth == true}">
          			<div>
						<h1><c:out value="${welcome}" />, 
						<c:out value="${name}" />!
						</h1>
						<br/>
					<a href="Controller?command=logout"><c:out value="${logout}" /></a>
					</div>
				</c:if>
				
				<c:if test="${sessionScope.auth == null}">
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="logination" />

						<div>
							<p><c:out value="${enterLogin}" /></p>
							<input type="text" name="login" value="" />
						</div>

						<div>
							<p><c:out value="${enterPass}" /></p>
							<input type="password" name="password" value="" />
						</div>

						<div>
							<input class="bot_ent" type="submit" value="${enter}" /> 
						</div>

						<div>
							<a class="link_reg" href="Controller?command=gotoregistrationpage"><c:out value="${registration}" /></a>
						</div>
					</form>
				</c:if>
			</div>

		<!--News-->
		<div class="list_news">
			<c:forEach var="AllNewsFromBD" items="${requestScope.news}">
				<div class="list_news_block">
					<div class="">
						<h5 class="title_news">
							<c:out value="${AllNewsFromBD.title}" />
						</h5>
						<p class="">
							<c:out value="${AllNewsFromBD.brief}" />
						</p>
						<c:if test="${sessionScope.auth == true}">
							<div class="">
								<a href="Controller?command=go_to_one_news_page&idnews=<c:out value="${AllNewsFromBD.idnews}"/>">
								<c:out value="${ReadMore}" /></a>
							</div>
						</c:if>
						<br/>
					</div>
				</div>
			</c:forEach>
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