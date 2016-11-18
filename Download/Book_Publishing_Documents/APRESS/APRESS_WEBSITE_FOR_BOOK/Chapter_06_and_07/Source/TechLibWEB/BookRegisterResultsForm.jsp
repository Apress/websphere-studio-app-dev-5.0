<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page 
import="apress.wsad.techlib.BookRegisterViewBean" 
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
%>
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>Registration Status</TITLE>

<!--Styles-->
<STYLE type="text/css">
<!--
H1 {
	text-align: center !IMPORTANT;
}

TH {
	text-align: left !IMPORTANT;
	vertical-align: top !IMPORTANT;
}

TD {
	text-align: left !IMPORTANT;
	vertical-align: top !IMPORTANT;
}

TH.result {
	background-color: #999999 !IMPORTANT;
}

TD.result {
	background-color: #cccccc;
	vertical-align: top !IMPORTANT;
}
-->
</STYLE>


</HEAD>
<BODY>

<jsp:useBean id="bookRegisterBean" scope="session"
	class="apress.wsad.techlib.BookRegisterViewBean"
	type="apress.wsad.techlib.BookRegisterViewBean" />
<%
%>
<jsp:setProperty name="bookRegisterBean" property="catalogNumber"
	value='<%=new java.lang.String(request.getParameter("catalogNumber"))%>' />
<jsp:setProperty name="bookRegisterBean" property="bookTitle"
	value='<%=new java.lang.String(request.getParameter("bookTitle"))%>' />
<jsp:setProperty name="bookRegisterBean" property="author"
	value='<%=new java.lang.String(request.getParameter("author"))%>' />
<jsp:setProperty name="bookRegisterBean" property="location"
	value='<%=new java.lang.String(request.getParameter("location"))%>' />
<jsp:setProperty name="bookRegisterBean" property="platform"
	value='<%=new java.lang.String(request.getParameter("platform"))%>' />
<jsp:setProperty name="bookRegisterBean" property="language"
	value='<%=new java.lang.String(request.getParameter("language"))%>' />
<%
//Execute Bean Methods whose return type is void

//Execute Other Bean Methods


%>

<!--Banner-->
<H1>Registration Status</H1>

<BR>
<BR>

<!-- Result Table -->
<TABLE border="0">
	<TBODY>
		<TR>
			<TH>Catalog number</TH>
			<TD><%=bookRegisterBean.getCatalogNumber()%></TD>
		</TR>
		<TR>
			<TH>Successful Registration</TH>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</HTML>
