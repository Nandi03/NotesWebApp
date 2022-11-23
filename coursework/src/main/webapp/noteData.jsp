<div class="noteData">
    <%
        String name = (String) request.getAttribute("name");
        String img = (String) request.getAttribute("img");
        String url = (String) request.getAttribute("url");
        String text = (String) request.getAttribute("text");
    %>

    <jsp:include page="footer.jsp" flush="true">
        <jsp:param name="name" value="<%name%>"/>
        <jsp:param name="img" value="<%img%>"/>
        <jsp:param name="url" value="<%url%>"/>
        <jsp:param name="text" value="<%text%>"/>
    </jsp:include>

    <h1><%=name%></h1>
    <% if (!img.equals("null")){%>
        <br/>
    <img src=<%=img%>>
    <%}%>
     <% if (!url.equals("null")){%>
         <br/>
    <a href=<%=url%>><%=url%></a>
     <%}%>
    <% if (!text.equals("null")){%>
    <p><%=text%></p>
    <%}%>


    <form action="noteLoad.jsp" id="itemform" method="get">
       <input form="itemform" name="submit" type="submit" value="Edit"/>
        <input form="itemform" name="name" type="hidden" value="<%=name%>"/>
        <input form="itemform" name="number" type="hidden" value="2"/>
    </form>
    <form action="deleteNote.jsp" id ="delete" method="get">
        <input form="delete" name="delete" type="submit" value="Delete Note"/>
        <input form="delete" name="name" type="hidden" value="<%=name%>"/>
    </form>
    <form action="noteList.html" id="index" method="get">

        <input form="index" name="back" type="submit" value="View all notes"/>
    </form>

</div>