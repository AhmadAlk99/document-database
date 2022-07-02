<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>The Books</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<form:form action="/add-book" method="post" commandName="book">
			<fieldset class="form-group">
				<form:label path="bookName">book name</form:label>
				<form:input path="bookName" type="text" class="form-control"/>
				<form:errors path="bookName" cssClass="text-warning" />

			</fieldset>
			<fieldset class="form-group">
				<form:label path="description">Description</form:label>
				<form:input path="description" type="text" class="form-control"
							required="required"/>
				<form:errors path="description" cssClass="text-warning" />

			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>