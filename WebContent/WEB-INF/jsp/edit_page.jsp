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
<fmt:message bundle="${locBundle}" key="main.logout" var="logout" />
<fmt:message bundle="${locBundle}" key="editPage.button.backToOneNewsPage" var="backToOneNewsPage" />
<fmt:message bundle="${locBundle}" key="editPage.button.saveEdit" var="save" />
<fmt:message bundle="${locBundle}" key="editPage.field.title" var="title" />
<fmt:message bundle="${locBundle}" key="editPage.field.brief" var="brief" />
<fmt:message bundle="${locBundle}" key="editPage.field.content" var="content" />

</head>
<body>
  <header class="header">
		<div class="container">
			<div>
				<div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="change_local" />
						 <input	type="hidden" name="local" value="ru" />
						 <input type="hidden" name="redirectTo" value="command=go_to_edit_page&idnews=${param['idnews']}" />
						 <input	type="submit" value="${button_ru}" />
						  <br />
					</form>
				</div>

				<div>
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="change_local" />
						<input type="hidden" name="local" value="en" />
						<input type="hidden" name="redirectTo" value="command=go_to_edit_page&idnews=${param['idnews']}" />
						<input type="submit" value="${button_en}" />
						 <br />
					</form>
				</div>
				<nav>
					<a href="Controller?command=logout"><c:out value="${logout}"/></a>
				</nav>
			</div>
		</div>
	</header>
	<div class="fon">
			<div align="center">
				<form action="Controller" method="post">	
					<input type="hidden" name="command" value="save_edit_one_news" />
					<c:set var="SelectedNews" value='${requestScope["selectedNews"]}' />
			 		<input type="hidden" name="idnews" value="${param['idnews']}" />
								
					<p><c:out value="${title}" /></p>
					<textarea class="text-area"  name="title"><c:out value="${SelectedNews.title}"/></textarea>
					<br />
								
					<p><c:out value="${brief}" /></p>
					<textarea class="text-area" name="brief"><c:out value="${SelectedNews.brief}" /></textarea>
					<br />
								
					<p><c:out value="${content}" /></p>
					<textarea class="text-area" name="content"><c:out value="${SelectedNews.content}" /></textarea>
 					<br />
 					<input type="submit" value="${save}" />
 				</form>
 			</div>
 					
			<div class="table" align="center">	
				<table >
					<tr>
						<td> 
							<div class="btn-group button">
								<form action="Controller" method="get">
									<input type="hidden" name="command" value="go_to_one_news_page" />
									<input type="hidden" name="idnews" value="${param['idnews']}" />
									<input type="submit" value="${backToOneNewsPage}" />
								</form>
							</div>
						</td>
					</tr>
				</table>
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