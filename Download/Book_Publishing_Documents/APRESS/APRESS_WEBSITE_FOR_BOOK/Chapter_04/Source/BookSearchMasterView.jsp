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
%><TITLE>Search Results</TITLE>
<META name="GENERATOR" content="IBM WebSphere Studio">

<!--Styles-->
<STYLE TYPE="text/css">
<!--H1
{
text-align: center;
}-->
</STYLE>
</head> 
<body>

<%--Get the Data Access Bean--%>
<%@ page import="apress.wsad.db.BookSearchMasterViewBean" %>
<jsp:useBean id="masterViewDBBean" class="apress.wsad.db.BookSearchMasterViewBean" scope="request" />
<jsp:setProperty name="masterViewDBBean" property="username" value='<%=config.getInitParameter("username")%>'/>
<jsp:setProperty name="masterViewDBBean" property="password" value='<%=config.getInitParameter("password")%>'/>
<jsp:setProperty name="masterViewDBBean" property="dataSourceName" value='<%=config.getInitParameter("dataSourceName")%>'/>

<%--Store input filters into the session--%>
<%
if(request.getParameter("new_input") != null){
   if(request.getParameter("LOCATION") != null){
      session.setAttribute("LOCATION", request.getParameter("LOCATION"));
   }
}
%>


<%--Get host variables--%>
<%
masterViewDBBean.setLOCATION((String)session.getAttribute("LOCATION"));  
%>

<%--Execute the query--%>
<%
masterViewDBBean.execute();
%>


<!--Java Script-->
<SCRIPT LANGUAGE="JavaScript" TYPE="text/javascript">
<!--
function submitForm(nav){


   document.myForm.elements["command"].value = nav
   
   index = document.myForm.elements["selected_index"].value
   if(nav == "BookSearchDetailsView" && index == "-1"){
      alert("You must first make a selection")
   }
   else if(nav == "BookSearchDetailsView"){
      LIB_BOOK_CATALOG_CATALOG_NUMBER_ID = "LIB_BOOK_CATALOG_CATALOG_NUMBER" + index
      document.myForm.elements["LIB_BOOK_CATALOG_CATALOG_NUMBER"].value = document.myForm.elements[LIB_BOOK_CATALOG_CATALOG_NUMBER_ID].value 
      LIB_BOOK_ACTIVITY_TXN_DATE_ID = "LIB_BOOK_ACTIVITY_TXN_DATE" + index
      document.myForm.elements["LIB_BOOK_ACTIVITY_TXN_DATE"].value = document.myForm.elements[LIB_BOOK_ACTIVITY_TXN_DATE_ID].value 
      document.myForm.submit()
   }
   else{
      document.myForm.submit()
   }
}

function setSelectedIndex(index){
	document.myForm.elements["selected_index"].value = index
}
//-->
</SCRIPT>
<!--Banner-->
<H1>Search Results</H1>

<!--Navigation-->
<FORM name="myForm" action="BookSearchController" method="POST">

<A href="javascript:submitForm('BookSearchInputForm')">Back</A>

<A href="javascript:submitForm('BookSearchMasterView')">Refresh</A>

<A href="javascript:submitForm('BookSearchDetailsView')">Details</A>

<BR><BR>
	 
<!--Hidden Variables-->
<INPUT TYPE="hidden" NAME="command" VALUE="BookSearchMasterView"/>
<INPUT TYPE="hidden" NAME="selected_index" VALUE="-1"/>
<INPUT TYPE="hidden" NAME="LIB_BOOK_CATALOG_CATALOG_NUMBER" VALUE=""/>
<INPUT TYPE="hidden" NAME="LIB_BOOK_ACTIVITY_TXN_DATE" VALUE=""/>


<%
Vector hidden_names = new Vector();
Vector hidden_values = new Vector();
%>
<!--Table-->
<TABLE border="1">
<TBODY>
   <TR>  
      <TH>Select</TH>
      <TH>CATALOG_NUMBER</TH>
      <TH>AUTHOR</TH>
      <TH>BOOK_TITLE</TH>
      <TH>COMPANY_NAME</TH>
   </TR>
   <%
  int index = 0;
   if(masterViewDBBean.first()){
      do{
   %>
   <TR>
      <TD>
         <INPUT TYPE="radio" NAME="selection" onclick="setSelectedIndex('<%=index%>')"/>
      </TD>   
      <TD>
         <%=masterViewDBBean.getLIB_BOOK_CATALOG_CATALOG_NUMBER()%>
         <INPUT TYPE="hidden" NAME="LIB_BOOK_CATALOG_CATALOG_NUMBER<%=index%>" VALUE='<%=masterViewDBBean.getLIB_BOOK_CATALOG_CATALOG_NUMBER()%>'/>
      </TD> 
      <%
      hidden_names.add("LIB_BOOK_ACTIVITY_TXN_DATE" + index);
      hidden_values.add(masterViewDBBean.getLIB_BOOK_ACTIVITY_TXN_DATE());
      %>
      <TD>
         <%=masterViewDBBean.getLIB_BOOK_CATALOG_AUTHOR()%>
      </TD> 
      <TD>
         <%=masterViewDBBean.getLIB_BOOK_CATALOG_BOOK_TITLE()%>
      </TD> 
      <TD>
         <%=masterViewDBBean.getLIB_BOOK_ACTIVITY_COMPANY_NAME()%>
      </TD>      
   </TR>
   <%
         index++;
      } while(masterViewDBBean.next());
   }
   %>
</TBODY>
</TABLE>
<%
for(int i = 0; i < hidden_names.size(); i++){
%>
<INPUT TYPE="hidden" NAME="<%=hidden_names.get(i)%>" VALUE="<%=hidden_values.get(i)%>"/>    
<%
}
%>

<%--Close the connection--%>
<%masterViewDBBean.close();%>
         
</FORM>
</body>
</HTML>