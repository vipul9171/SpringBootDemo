<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<title>Welcome ${username}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<h2>${username} Your Todo list is here:</h2>
		<table class="table">
			<thead>
				<tr>
					<td>User</td>
					<td>Desc</td>
					<td>Target Date</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="todo">
					<tr>
						<td>${todo.user}</td>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${todo.id}">update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<h1>
			<a class="button" href="/add-todo">Click Here</a> to add todo
		</h1>
		<script src="webjars/bootstrap/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>

</body>
</html>