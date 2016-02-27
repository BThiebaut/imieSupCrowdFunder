<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${empty requestScope.authFolder}" >
	<jsp:include page="header.jsp"/>
</c:if>
<c:if test="${!empty requestScope.authFolder}" >
	<jsp:include page="../header.jsp"/>
</c:if>


 <header class="main-header">

  <!-- Logo -->
  <a href="/SupCrowdFunder/" class="logo hidden-xs">
    <!-- mini logo for sidebar mini 50x50 pixels -->
  <span class="logo-mini"><b>SCF</b></span>
  <!-- logo for regular state and mobile devices -->
  <span class="logo-lg"><b>Sup</b>CrowdFunder</span>
  </a>

  <!-- Header Navbar -->
  <nav class="navbar navbar-static-top" role="navigation">
    <!-- <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
      <span class="sr-only">Toggle navigation</span>
    </a> -->
    <!-- Navbar Menu -->
    <div class="navbar-custom-menu">
      <ul class="nav navbar-nav">
        <!-- Project / Category menu -->
         <li class="button-header pull-left ${fn:contains(pageContext.request.contextPath, 'showProjects') ? 'active' : ''}">
          <a href="/SupCrowdFunder/showProjects" class="navleft">
           <i class="fa fa-list"></i> Show all projects
          </a>
        </li>
         <li class="button-header pull-left ${fn:contains(pageContext.request.contextPath, 'addProject') ? 'active' : ''}">
          <a href="/SupCrowdFunder/auth/addProject" class="navleft">
           <i class="fa fa-plus"></i> Add project
          </a>
        </li>
        <li class="button-header pull-left ${fn:contains(pageContext.request.contextPath, 'addCategory') ? 'active' : ''}">
          <a href="/SupCrowdFunder/auth/addCategory" class="navleft">
           <i class="fa fa-plus"></i> Add category
          </a>
        </li>
        <!-- User account menu -->
        <c:if test="${empty sessionScope.user}" >
			<li class="button-header pull-right">
	          <a href="/SupCrowdFunder/login?action=sign" class="navright">
	           	<i class="fa fa-sign-in"></i> Sign in
	          </a>
	        </li>
	        <li class="button-header pull-right">
	          <a href="/SupCrowdFunder/login?action=create" class="navright">
	           	<i class="fa fa-user-plus"></i> Create account
	          </a>
	        </li>
		</c:if>
		<c:if test="${!empty sessionScope.user}" >
			<li class=" disconnect-button pull-right">
	          <a href="/SupCrowdFunder/login?action=signout" class="navright">
	           <i class="fa fa-sign-out"></i>
	          </a>
	        </li>
	        <li class="dropdown user user-menu pull-right">
	        <a aria-expanded="false" href="#" class="dropdown-toggle" data-toggle="dropdown">
	          	<img src="/SupCrowdFunder/dist/img/image.jpg" class="user-image" alt="User Image">
	          <span class="hidden-xs">${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}</span>
	        </a>
	        <ul class="dropdown-menu">
	          <!-- User image -->
	          <li class="user-header">
	          	<img src="/SupCrowdFunder/dist/img/image.jpg" class="user-image" alt="User Image">
	            <p>
	              ${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}
	              <small>${sessionScope.user.geteMail()}</small>
	            </p>
	          </li>
	          <!-- Menu Body -->
	          <li class="user-body">
	            <div class="row">
	              <div class="col-xs-12 text-center">
	                <a href="/SupCrowdFunder/debug.jsp">My account</a>
	              </div>
	            </div>
	          </li>
	        </ul>
	      </li>
		</c:if>
      </ul>
    </div>
  </nav>
</header>