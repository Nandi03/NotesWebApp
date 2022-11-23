<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notepad</title>
</head>
<body>
<div class="main">

    <form action="addNote.jsp" id="itemform" method="get">
        <p>Note of this name already exists or the name is invalid! Try again.</p>
        <label for="name">Enter a name for your new note: </label>
        <textarea cols="10" rows="1" id="name" name="name"></textarea><br><br>
        <input form="itemform" name="submit" type="submit" value="Create Note"/>
    </form>
    <form action="index.html" id="menu" method="get">
        <input form="menu" name="menu" type="submit" value="Back to homepage"/>
    </form>
</div>
</body>
</html>