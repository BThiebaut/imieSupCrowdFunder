<jsp:include page="../menu.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="content-wrapper">
 <section class="content-header">
   <h1>
     Add category
     <small></small>
   </h1>
   <ol class="breadcrumb">
     <li><a href="/"><i class="fa fa-dashboard"></i> SupCrowdFunder</a></li>
     <li class="active">Add category</li>
   </ol>
 </section>

 <!-- Main content -->
 <section class="content">
 	<div class="panel panel-default">
	  <div class="panel-body text-center">
	  	<c:if test="${!empty requestScope.error}" >
	  		<div class="alert alert-danger text-center"><c:out value="${requestScope.error}" /></div>
	  	</c:if>
	    <form class="form-horizontal" method="post">
		    <fieldset>
		  		<legend class="text-left">Add a category</legend>
				  <div class="form-group row">
				    <label for="name" class="col-sm-2 control-label">Category name</label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="name" placeholder="Category name" name="name" required>
				    </div>
				  </div>
				 <div class="form-group row">
				    <label for="description" class="col-sm-2 control-label">Category description</label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="description" placeholder="Description" name="description" required>
				    </div>
				  </div>
				</fieldset>
			  <div class="form-group row">
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-8">
		  			<a href="/SupCrowdFunder/showProjects" class="pull-left"><button class="btn btn-default">Cancel</button></a>
		      	<div class="pull-left submit-button"><button type="submit" class="btn btn-primary">Add category</button></div>
		  		</div>
			  </div> 
			</form>
		
		  </div>
		</div>
 </section><!-- /.content -->
</div><!-- /.content-wrapper -->
<jsp:include page="../footer.jsp"/>