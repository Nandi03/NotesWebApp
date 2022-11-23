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
    <h2>Notes:</h2>
    <ul>
        <%
            List<String> noteNames = (List<String>) request.getAttribute("noteNames");
            for (String name : noteNames)
            {
                String href = "/noteLoad.jsp?name=" + name + "&number=1";
        %>
        <li><a href="<%=href%>"><%=name%></a>
        </li>
        <% } %>
    </ul>
    <form action="noteList.html" id="sorted" method="get">
        <input form="sorted" name="sorted" type="submit" value="View notes sorted by time added"/>
    </form>
    <form action="index.html" id="menu" method="get">
        <input form="menu" name="menu" type="submit" value="Back to homepage"/>
    </form>
    <form action="search.html" id="search" method="get">
        <input form="search" name="searchpage" type="submit" value="Search for a note"/>
    </form>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
