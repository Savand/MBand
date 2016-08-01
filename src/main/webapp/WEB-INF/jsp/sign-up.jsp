<%@include file="includes/header.jsp"%>


<div class = "panel panel-default">

	<div class="panel-heading">
		<h3 class="panel-title">Please sign up</h3>
	</div>
	
	<div class="panel-body">
	
		<form:form modelAttribute="band" role="form" >
		
			<div class="form-group">
				<form:label path="bandBio.name">Band name</form:label> 
				<form:input	path="bandBio.name" class="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="bandBio.musicStyle">Band's music style</form:label> 
				<form:select path="bandBio.musicStyle" items="${musicStyles}" class="form-control" />
			</div>
	
			<div class="form-group">
				<form:label path="contactInfo.email">Email address</form:label> 
				<form:input	path="contactInfo.email" type="email" class="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="password">Password</form:label> 
				<form:password path="password" class="form-control"/>
			</div>
			
			
			<button type="submit" class="btn btn-default">Go</button>
			
		</form:form>
	</div>
	
</div>


<div class = "panel panel-default">

	<div class="panel-heading">
		<h3 class="panel-title">Some optional information</h3>
	</div>
	
	<div class="panel-body">
	
		<form:form modelAttribute="band" role="form" >
		
			<div class="form-group">
				<form:label path="">TODO Add other attributes</form:label> <!-- TODO --> 
			</div>
			
		</form:form>
	</div>
	
</div>

<%@include file="includes/footer.jsp"%>