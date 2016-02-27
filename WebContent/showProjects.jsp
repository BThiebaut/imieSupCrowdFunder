<jsp:include page="menu.jsp"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="content-wrapper">
 <section class="content-header">
   <h1>
     Projects list
     <small>show all project</small>
   </h1>
   <ol class="breadcrumb">
     <li><a href="/"><i class="fa fa-dashboard"></i> SupCrowdFunder</a></li>
     <li class="active">Projects list</li>
   </ol>
 </section>

 <!-- Main content -->
 <section class="content">
 	<c:if test="${empty requestScope.projects}" >
		<h2 class="alert alert-danger text-center">There is no projects. <a href="/SupCrowdFunder/auth/addProject">Create one !</a></h2>
	</c:if>
	<c:if test="${!empty requestScope.validation}" >
  		<div class="alert alert-success text-center"><c:out value="${requestScope.validation}" /></div>
  	</c:if>
	<c:if test="${!empty requestScope.projects}" >
		<c:forEach items="${requestScope.projects}" var="data">
			<div class="box box-primary">
			  <div class="box-header with-border">
			    <h3 class="box-title">${data.getName()}</h3>
			  </div><!-- /.box-header -->
			  <div class="box-body">
			    <div class="project-description">
			    	${fn:replace(data.getDescription(), fn:substring(data.getDescription(), 128, fn:length(data.getDescription())), '...')}<br/>
			    	<a href="/readProject?id=${data.getId()}">Details</a> 
			    </div>
			  </div><!-- /.box-body -->
			  <div class="box-footer">
			   <div class="progress-group">
                  <span class="progress-text">Completion</span>
                  <span class="progress-number"><b>${data.getFound / data.getObjective() * 100}</b>/100</span>
                  <div class="progress sm">
                    <div class="progress-bar progress-bar-green" style="width: ${data.getFound / data.getObjective() * 100}%"></div>
                  </div>
                </div>
			  </div><!-- box-footer -->
			</div><!-- /.box -->
		</c:forEach>
	</c:if>

 </section><!-- /.content -->
</div><!-- /.content-wrapper -->
<jsp:include page="footer.jsp"/>