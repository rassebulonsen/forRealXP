<%-- 
    Document   : main
    Created on : 05-03-2014, 11:39:25
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Start up Page</h1>
        <a href="FrontController?command=subject"> Round 1</a>
        <p><a href="FrontController?command=makePool"> make pools</a></p>
        <p><a href="FrontController?command=make_pool_subject_selections"> Round 2</a></p>
        <p><a href="FrontController?command=elective_selection">Select subjects</a></p>
        <p><a href="FrontController?command=makeStudentSubjectList"> Student-List</a></p>
    </body>
</html>
