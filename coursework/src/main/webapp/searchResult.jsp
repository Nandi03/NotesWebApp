<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Notepad</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Search Result</h1>
  <%
    List<String> noteNames = (List<String>) request.getAttribute("result");
    if (noteNames.size() !=0)
    {
    %>
    <ul>
      <%
        for (String name : noteNames)
        {
          String href = "/noteLoad.jsp?name=" + name + "&number=1";
      %>
      <li><a href="<%=href%>"><%=name%></a></li>
     <% }
    } else
    {%>
      <p>Nothing found</p>
  <%}%>
  </ul>
  <form action="index.html" id="menu" method="get">
    <input form="menu" name="menu" type="submit" value="Back to homepage"/>
  </form>
  <form action="search.html" id="search" method="get">
    <input form="search" name="search" type="submit" value="Search again"/>
  </form>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>