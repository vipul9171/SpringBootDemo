<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

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
<%@ include file="common/footer.jspf"%>