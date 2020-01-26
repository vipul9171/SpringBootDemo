<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Add Todo</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<h1>Add Todo's here</h1>
	<div class="container">


		<form:form method="POST" modelAttribute="todoModel">
			<form:hidden path="id" />
			<fieldset class="form-group">
				<form:label path="desc">Description: </form:label>
				<form:input path="desc" type="text" class="form-control"
					required="required"></form:input>
				<form:errors path="desc"></form:errors>
			</fieldset>


			<fieldset class="form-group">
				<form:label path="targetDate">Target Date: </form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required"></form:input>
			</fieldset>
			<button type="submit" class="btn btn-success">add</button>
		</form:form>
	</div>
	<script src="webjars/bootstrap/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>