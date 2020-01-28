<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
	<h2>${username}YourTodolist is here:</h2>
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
					<td><fmt:formatDate value="${todo.targetDate}"
							pattern="dd/MM/yyyy" /></td>
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
<%@ include file="common/footer.jspf"%>