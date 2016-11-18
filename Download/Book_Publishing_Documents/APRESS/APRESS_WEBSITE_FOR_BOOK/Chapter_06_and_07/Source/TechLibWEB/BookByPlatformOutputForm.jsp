<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>BookByPlatformOutputForm.jsp</TITLE>
</HEAD>
<BODY>
<P><IMG src="logo2_.gif" width="368" height="88" border="0" alt="Books by Platform
(Search Results)"></P>
<P><BR>
<jsp:useBean id="Helper1" class="apress.wsad.techlib.BookByPlatformHelper1" scope="session"></jsp:useBean>
</P>

<% String selectedProperty = request.getParameter("PlatformOption");
   Helper1.setSelectedPlatform(selectedProperty);
   Helper1.populateIndexedAttribute();
%>

<%--METADATA type="DynamicData" startspan
<TABLE border="1" innerloopproperty="Helper1.transObjList[]" innerloopdirection="vertical" innerloopstartindex="1" innerloopendindex="1" dynamicelement>
	<CAPTION></CAPTION>
	<TBODY>
		<TR>
			<TD><B>Catalog number</B></TD>
			<TD><B>Book title</B></TD>
			<TD><B>Author</B></TD>
			<TD><B>Location</B></TD>
			<TD><B>Platform</B></TD>
		</TR>
		<TR>
			<TD><WSPX:PROPERTY property="Helper1.transObjList[].catalogNumber" authortimetext="12345"></TD>
			<TD><WSPX:PROPERTY property="Helper1.transObjList[].bookTitle" authortimetext="wwwwwwwwwwwwwwwwwww"></TD>
			<TD><WSPX:PROPERTY property="Helper1.transObjList[].author" authortimetext="AAAAAAAAAAAAAAAA"></TD>
			<TD><WSPX:PROPERTY property="Helper1.transObjList[].location" authortimetext="Library"></TD>
			<TD><WSPX:PROPERTY property="Helper1.transObjList[].platform" authortimetext="00"></TD>
		</TR>
	</TBODY>
</TABLE>
--%><%
try {
  apress.wsad.techlib.TransportBean[] _a0 = Helper1.getTransObjList();
  apress.wsad.techlib.TransportBean _p0 = _a0[0]; // throws an exception if empty. %>
  <TABLE border="1">
    <CAPTION></CAPTION>
    <TBODY>
      <TR>
        <TD><B>Catalog number</B></TD>
        <TD><B>Book title</B></TD>
        <TD><B>Author</B></TD>
        <TD><B>Location</B></TD>
        <TD><B>Platform</B></TD>
      </TR><%
      for (int _i0 = 0; ; ) { %>
        <TR>
          <TD><%= _p0.getCatalogNumber() %></TD>
          <TD><%= _p0.getBookTitle() %></TD>
          <TD><%= _p0.getAuthor() %></TD>
          <TD><%= _p0.getLocation() %></TD>
          <TD><%= _p0.getPlatform() %></TD>
        </TR><%
        _i0++;
        try {
          _p0 = _a0[_i0];
        }
        catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
          break;
        }
      } %>
    </TBODY>
  </TABLE><%
}
catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
} %><%--METADATA type="DynamicData" endspan--%>
</BODY>
</HTML>
