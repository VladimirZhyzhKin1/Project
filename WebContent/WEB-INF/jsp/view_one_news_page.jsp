<%@ page language="java" contentType="text/html;
	charset=UTF-8"
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

<fmt:message bundle="${locBundle}" key="loc.message" var="message" />
<fmt:message bundle="${locBundle}" key="loc.locbutton.ru" var="button_ru" />
<fmt:message bundle="${locBundle}" key="loc.locbutton.en" var="button_en" />
<fmt:message bundle="${locBundle}" key="SelectedNews.button.backToMainIndexPage" var="backToMainIndexPage" />
<fmt:message bundle="${locBundle}" key="SelectedNews.button.edit"	var="edit" />
<fmt:message bundle="${locBundle}" key="SelectedNews.button.delete" var="delete" />
<fmt:message bundle="${locBundle}" key="main.logout" var="logout" />
<fmt:message bundle="${locBundle}" key="main.welcome" var="welcome" />

</head>
<body>
	<header class="header">
		<div class="container">
			<div>
				<div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="change_local" />
						<input type="hidden" name="local" value="ru" />
						<input type="hidden" name="redirectTo" value="command=go_to_one_news_page&idnews=${param['idnews']}" />
						<input type="submit" value="${button_ru}" />
						<br />
					</form>
				</div>

				<div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="change_local" />
						 <input type="hidden" name="local" value="en" />
						 <input type="hidden" name="redirectTo" value="command=go_to_one_news_page&idnews=${param['idnews']}" />
						 <input type="submit" value="${button_en}" />
						 <br />
					</form>
				</div>
				<nav>
					<a href="#"></a>
				</nav>
			</div>
		</div>
	</header>
	<div class="fon">
	
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
			<h1>
				<c:out value="${message}" />
			</h1>
			<h1>
				<c:out value="${name}" />
				!
			</h1>
			<br />
			<a href="Controller?command=logout"><c:out value="${logout}" /></a>
			<br />
		</div>

		<div align="center" class="list_one_news">
			<c:set var="SelectedNews" value="${requestScope['selectedNews']}" />
				<div class="scrollable"> 
					<h5 class="title_news"><c:out value="${SelectedNews.title}" /></h5>
					<br />
					<div>
						<p><c:out value="${SelectedNews.data}" /></p>
						<br />
						<div>
							<p><c:out value="${SelectedNews.content}" /></p>
						</div>
					</div>
				</div>
		</div>

		<div class="table" align="center">
			<table>
				<tr>
					<td>
						<form action="Controller" method="get">
							<input type="hidden" name="command" value="gotomainpage" />
							<button class="btn-group button">
								<c:out value="${backToMainIndexPage}" />
							</button>
						</form>
					</td>

					<c:if test="${sessionScope.role eq \"admin\"}">
					<td>
						<form action="Controller" method="get">
							<input type="hidden" name="command" value="go_to_edit_page" />
							<input type="hidden" name="idnews" value="${param['idnews']}">
							<button class="btn-group">
								<c:out value="${edit}" />
							</button>
						</form>
					</td>
					<td>
						<form action="Controller" method="get">
							<input type="hidden" name="command" value="delete_one_news" />
							<input	type="hidden" name="idnews" value="${param['idnews']}">
							<button class="btn-group">
								<c:out value="${delete}" />
							</button>
						</form>
					</td>
					</c:if>
				</tr>
			</table>
			<br />
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