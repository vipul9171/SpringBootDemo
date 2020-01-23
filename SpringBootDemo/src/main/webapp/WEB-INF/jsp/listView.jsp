
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Welcome ${username}</title>
</head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
		rel="stylesheet">
<body>
	<div class="container">
	${username}YourTodo'sarehere:
	<table class="table">
		<thead>
			<tr>
				<td>User</td>
				<td>Desc</td>
				<td>Target Date</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="todo">
				<tr>
					<td>${todo.user}</td>
					<td>${todo.desc}</td>
					<td>${todo.targetDate}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<h1>
		<a class="button"  href="/add-todo">Click Here</a> to add todo
	</h1>
	<script src="webjars/bootstrap/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>

</body>
</html>