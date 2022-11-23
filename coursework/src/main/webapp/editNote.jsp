<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notepad</title>
</head>
<body>
<div class = "editNote">

    <%
        String name = (String) request.getAttribute("name");
        String img = (String) request.getAttribute("img");
        String url = (String) request.getAttribute("url");
        String text = (String) request.getAttribute("text");
    %>

<form action="/noteEdit.jsp" id="itemform" method="get">
    <label for="name">Note Name:</label>
    <textarea cols="50" rows="1" id="name" name="newName"><%=name%></textarea><br><br>
    <label for="img">Image URL:</label>
    <textarea cols="50" rows="1" id="img" name="img"><%=img%></textarea><br><br>
    <label for="url">Associated URL:</label>
    <textarea cols="50" rows="1" id="url" name="url"><%=url%></textarea><br><br>
    <label for="text">Enter notes:</label>
    <textarea cols="100" id ="text" name="text" rows="10" form="itemform"><%=text%></textarea><br><br>
    <input form="itemform" name="name" type="hidden" value="<%=name%>"/>
    <input form="itemform" name="submit" type="submit" value="Save"/>
</form>
</div>
</body>
</html>