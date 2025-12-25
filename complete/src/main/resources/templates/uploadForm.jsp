<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html xmlns:th="https://www.thymeleaf.org">
<body>

	<div th:if="${message}">
		<h2 th:text="${message}"> </h2>
	</div>

	 
	<div>
		<form method="POST" enctype="multipart/form-data" action="/">
			<table>
				<tr> <td>Enter grade:</td> <td><input type="text" name="grade"></td> </tr>
				<tr> <td>Enter subject:</td> <td><input type="text" name="subject"></td> </tr>
				<tr> <td>Enter chapter:</td> <td><input type="text" name="chapter"></td> </tr>
				<tr> <td>File to upload:</td> <td><input type="file" name="file" /></td> </tr>
				<tr> <td></td> <td><input type="submit" value="Upload" /></td> </tr>
				
			</table>
		</form>
	</div>
	
	
	<!--
	<div>
		<form method="GET" action="/upload">
			<input type="submit" value="Upload">
		</form>
	</div>
	-->
	
	<div>
		<textarea rows="1" cols="50"></textarea>
	</div>

	<div>
		<ul>
			<li th:each="file : ${files}">
				<a th:href="${file}" th:text="${file}" ></a>
			</li>
		</ul>
	</div>

</body>
</html>
