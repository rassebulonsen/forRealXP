<%-- 
    Document   : elective_selection
    Created on : 26-03-2014, 13:11:54
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="electiveSelection" id="subjectSelection" method="post" action="FrontController">
            <input type="hidden" name="command" value="MakeSelectionCommand">
            <c:forEach items="${subjects}" var="subject">
            <input type="checkbox" name="vehicle" value="Car">
            </c:forEach>
        </form>
    </body>
</html>
