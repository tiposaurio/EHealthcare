<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>E-Healthcare</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
<link rel="stylesheet" type="text/css" href="css/default.css" media="screen"/>
</head>
<body>
<div class="container">
  <div class="header">
    <div class="title">
      <h1>E-Healthcare Web Application</h1>
    </div>
    <jsp:include page="navigation.jsp" />
  </div>
  <div class="main">
    <div class="content">
      <s:if test="%{#session.userlogindata != null}">
      <h1>Edit your profile:</h1>
        <s:form action="changeprof" method="post">
	       <s:actionerror/>
		   <s:password  name="password"  label="Password" size="20" />
		   <s:password  name="password2" label="Reenter Password" size="20" />
		   <s:textfield name="firstname" label="First Name" size="20" />
		   <s:textfield name="surname"   label="Surname" size="20" />
		   <s:textfield name="mail"      label="Your E-Mail Address" size="20" />
		   <s:submit value="Change profile data" align="left" />
	    </s:form>
	  </s:if>	    
      <div class="clearer"><span></span></div>
    </div>
	<jsp:include page="sidenavigator.jsp" />
	<div class="clearer"><span></span></div>
  </div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>