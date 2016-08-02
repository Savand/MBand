<%@page import="com.andsav.gk.dto.MusicStyle"%>
<%@include file="includes/header.jsp"%>
<%@ page isELIgnored="false" %>


<% MusicStyle[] musicStyles = MusicStyle.values(); 
   request.setAttribute("styles", musicStyles); %>


<div class = "panel panel-default">

	<div class="panel-heading">
		<h3 class="panel-title">Please sign up</h3>
	</div>
	
	<div class="panel-body">
	
		<form:form modelAttribute="band" role="form" >
		
			<form:errors />
			
			<div class="form-group">
				<form:label path="bandBio.name">Band name</form:label> 
				<form:input	path="bandBio.name" class="form-control"/>
				<form:errors cssClass="error" path="bandBio.name" />
				<p class="help-block">Enter your band name</p>
				
			</div>
			
			<div class="form-group">
				<form:label path="bandBio.musicStyle">Music style</form:label> 
				<form:select path="bandBio.musicStyle" items="${styles}" class="form-control" />
				<p class="help-block">Choose the music style your band is preferably playing</p>
			</div>
	
			<div class="form-group">
				<form:label path="contactInfo.email">Email address</form:label> 
				<form:input	path="contactInfo.email" type="email" class="form-control"/>
				<form:errors cssClass="error" path="contactInfo.email" />
				<p class="help-block">Email address should be valid and unique</p>
			</div>
			
			<div class="form-group">
				<form:label path="password">Password</form:label> 
				<form:password path="password" class="form-control"/>
				<form:errors cssClass="error" path="password" />
				<p class="help-block">Password should be at least 6 signs long</p>
			</div>
			
			
			<button type="submit" class="btn btn-default">Go 'n fun</button>
			
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