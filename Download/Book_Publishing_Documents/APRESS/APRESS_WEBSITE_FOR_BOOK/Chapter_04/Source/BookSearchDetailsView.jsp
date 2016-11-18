<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><HTML>
<head>

<%@ page import="java.util.*" 
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
%>
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>Details View</TITLE>


<STYLE TYPE="text/css">
<!--H1
{text-align: center;
}
TH
{
text-align:left;}
-->
</STYLE>
</head>

<body>

<%--Get the Data Access Bean--%>
<%@ page import="apress.wsad.db.BookSearchDetailsViewBean" %>
<jsp:useBean id="detailsViewDBBean" class="apress.wsad.db.BookSearchDetailsViewBean" scope="request" />
<jsp:setProperty name="detailsViewDBBean" property="username" value='<%=config.getInitParameter("username")%>'/>
<jsp:setProperty name="detailsViewDBBean" property="password" value='<%=config.getInitParameter("password")%>'/>
<jsp:setProperty name="detailsViewDBBean" property="dataSourceName" value='<%=config.getInitParameter("dataSourceName")%>'/>

<%--Get host variables--%>
<%
detailsViewDBBean.setLOCATION((String)session.getAttribute("LOCATION"));  
detailsViewDBBean.setLIB_BOOK_CATALOG_CATALOG_NUMBER(request.getParameter("LIB_BOOK_CATALOG_CATALOG_NUMBER"));  
detailsViewDBBean.setLIB_BOOK_ACTIVITY_TXN_DATE(request.getParameter("LIB_BOOK_ACTIVITY_TXN_DATE"));  
%>

<%--Execute the query--%>
<%
detailsViewDBBean.execute();
%>



<SCRIPT LANGUAGE="JavaScript" TYPE="text/javascript">
<!--
function submitForm(nav){
   document.myForm.elements["command"].value = nav
   document.myForm.submit()
}
//-->
</SCRIPT>

<!--Banner-->
<H1>Details View</H1>
      

<!--Navigation-->
<FORM name="myForm" action="BookSearchController" method="POST">
<A href="javascript:submitForm('BookSearchMasterView')">Back</A>

<BR><BR>	 

<!--Hidden Variables-->
<INPUT TYPE="hidden" NAME="command" VALUE="BookSearchMasterView"/>

<%
if(detailsViewDBBean.first()){
   do{
%>
<hr>
<!--Table-->
<TABLE border="0">
<TBODY> 
   <TR>
      <TD>
         CATALOG_NUMBER: 
      </TD>
      <TD>
         <%=detailsViewDBBean.getLIB_BOOK_CATALOG_CATALOG_NUMBER()%> 
     </TD>
   </TR> 
   <TR>
      <TD>
         TXN_DATE: 
      </TD>
      <TD>
         <%=detailsViewDBBean.getLIB_BOOK_ACTIVITY_TXN_DATE()%> 
     </TD>
   </TR> 
   <TR>
      <TD>
         AUTHOR: 
      </TD>
      <TD>
         <%=detailsViewDBBean.getLIB_BOOK_CATALOG_AUTHOR()%> 
     </TD>
   </TR> 
   <TR>
      <TD>
         BOOK_TITLE: 
      </TD>
      <TD>
         <%=detailsViewDBBean.getLIB_BOOK_CATALOG_BOOK_TITLE()%> 
     </TD>
   </TR> 
   <TR>
      <TD>
         TXN_TYPE: 
      </TD>
      <TD>
         <%=detailsViewDBBean.getLIB_BOOK_ACTIVITY_TXN_TYPE()%> 
     </TD>
   </TR> 
   <TR>
      <TD>
         COMPANY_NAME: 
      </TD>
      <TD>
         <%=detailsViewDBBean.getLIB_BOOK_ACTIVITY_COMPANY_NAME()%> 
     </TD>
   </TR>
</TBODY>
</TABLE> 
<%
   }while(detailsViewDBBean.next());
}
%>

<%--Close the connection--%>
<%detailsViewDBBean.close();%>
         
</FORM>
</body>
</HTML>