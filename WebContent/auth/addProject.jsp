<jsp:include page="../menu.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="content-wrapper">
 <section class="content-header">
   <h1>
     Add a project
     <small></small>
   </h1>
   <ol class="breadcrumb">
     <li><a href="/"><i class="fa fa-dashboard"></i> SupCrowdFunder</a></li>
     <li class="active">Add project</li>
   </ol>
 </section>

 <!-- Main content -->
 <section class="content">
 	<div class="panel panel-default">
	  <div class="panel-body text-center">
	  	<c:if test="${!empty requestScope.error}" >
	  		<div class="alert alert-danger text-center"><c:out value="${requestScope.error}" /></div>
	  	</c:if>
	    <form class="form-horizontal" method="post" action="/SupCrowdFunder/auth/addProject">
	    	<c:if test="${empty requestScope.project}" >
			    <fieldset>
			  		<legend class="text-left">Add a project</legend>
					  <div class="form-group row">
					  	<!-- Html astuce : for="" Permet de sélectionner le champ avec le même ID en cliquant sur le label (comme la question se posais en cours) -->
					    <label for="name" class="col-sm-2 control-label">Project name</label>
					    <div class="col-sm-8">
					      <input type="text" class="form-control" id="name" placeholder="Project name" name="name" required>
					    </div>
					  </div>
					 <div class="form-group row">
					    <label for="description" class="col-sm-2 control-label">Project description</label>
					    <div class="col-sm-8">
					      <input type="text" class="form-control" id="description" placeholder="Description" name="description" required>
					    </div>
					  </div>
					  <div class="form-group row">
					    <label for="date" class="col-sm-2 control-label">Objective</label>
					    <div class="col-sm-8">
					      <input type="number" class="form-control" id="date" placeholder="" name="objective" required>
					    </div>
					  </div>
					  <input type="hidden" name="idcreator" value="${requestScope.user.getId()}"/>
					  <div class="form-group row">
					    <label for="category" class="col-sm-2 control-label">Category</label>
					    <div class="col-sm-8">
					    	<select name="category" id="category" required>
					    		<c:forEach items="${requestScope.categories}" var="data">
					    			<option value="${data.getId()}">${data.getName()}</option>
					    		</c:forEach>
					    	</select>
					    </div>
					  </div>
					</fieldset>
				</c:if>
				<c:if test="${!empty requestScope.project}" >
				</c:if>
			  <div class="form-group row">
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-8">
		  			<a href="/SupCrowdFunder/showProjects" class="pull-left"><button class="btn btn-default">Cancel</button></a>
		      	<div class="pull-left submit-button"><button type="submit" class="btn btn-primary">Add project</button></div>
		  		</div>
			  </div> 
			</form>
		
		  </div>
		</div>
 </section><!-- /.content -->
</div><!-- /.content-wrapper -->
<jsp:include page="../footer.jsp"/>