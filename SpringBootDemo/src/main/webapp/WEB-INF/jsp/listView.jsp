
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Welcome ${username}</title>
</head>
<body>

	<h1>${username}YourTodo'sarehere:</h1>
	<table>
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
		<a href="/show-todo">Click Here</a> to add todo
	</h1>

</body>
</html>