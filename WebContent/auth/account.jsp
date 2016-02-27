<jsp:include page="../menu.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="content-wrapper">
 <section class="content-header">
   <h1>
     Edit account
     <small></small>
   </h1>
   <ol class="breadcrumb">
     <li><a href="/"><i class="fa fa-dashboard"></i> SupCrowdFunder</a></li>
     <li class="active">Edit account</li>
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
		  		<legend class="text-left">Manage account</legend>
				  <div class="form-group row">
				    <label for="firstname" class="col-sm-2 control-label">FirstName</label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="firstname" placeholder="First name" name="firstname" value="${requestScope.user.getFirstName()}" required>
				    </div>
				  </div>
				 <div class="form-group row">
				    <label for="lastname" class="col-sm-2 control-label">LastName</label>
				    <div class="col-sm-8">
				      <input type="text" class="form-control" id="lastname" placeholder="Last name" name="lastname" value="${requestScope.user.getLastName()}" required>
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="email" class="col-sm-2 control-label">eMail</label>
				    <div class="col-sm-8">
				      <input type="email" class="form-control" id="email" placeholder="eMail" name="email" value="${requestScope.user.geteMail()}" required>
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="pw" class="col-sm-2 control-label">Password</label>
				    <div class="col-sm-8">
				      <input type="password" class="form-control" id="pw" placeholder="Password" name="pw" value="********" required>
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="pw2" class="col-sm-2 control-label">Password Repeat</label>
				    <div class="col-sm-8">
				      <input type="password" class="form-control" id="pw2" placeholder="Type password again" name="pw2" value="" required>
				    </div>
				  </div>
				</fieldset>
			  <div class="form-group row">
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-8">
		  			<a href="/SupCrowdFunder/showProjects" class="pull-left"><button class="btn btn-default">Cancel</button></a>
		      	<div class="pull-left submit-button"><button type="submit" class="btn btn-primary">Save</button></div>
		  		</div>
			  </div> 
			</form>
		
		  </div>
		</div>
 </section><!-- /.content -->
</div><!-- /.content-wrapper -->
<jsp:include page="../footer.jsp"/>