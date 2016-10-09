<jsp:include page="../includes/logged/header.jsp">
    <jsp:param name="pageTitle" value="Foodbook - Perfil"/>
</jsp:include>

	<div class="row">

    	<div class="col-md-8 col-md-offset-2">
   			<div class="text-center">
				<img class="img-circle center-block" src="http://placehold.it/200x200"  width="200px" alt="">
				<br />
				<h2>${ user.name }</h2>
			</div>
				
			<hr />
    	
			<jsp:include page="../includes/logged/recipe-preview.jsp" />
			<jsp:include page="../includes/logged/recipe-preview.jsp" />
		</div>	              
			
	</div>
      
<jsp:include page="../includes/logged/footer.jsp" />
