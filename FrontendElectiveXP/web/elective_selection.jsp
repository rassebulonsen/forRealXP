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
        <script src="js/jquery-2.0.3.js"></script>
        <script src="js/numbers.js"></script>
        <script src="js/dropdownScript.js"></script>
        <title>JSP Page</title>
        <script>
            $(document).ready(function() {
                $('#createNewSubject').click(function(e) {
                    var isValid = true;
                    $('input[type="text"]').each(function() {
                        if ($.trim($(this).val()) === '') {
                            isValid = false;
                            $(this).css({
                                "border": "1px solid red",
                                "background": "#FFCECE"
                            });
                        }
                        else {
                            $(this).css({
                                "border": "",
                                "background": ""
                            });
                        }
                    });
                    if (isValid === false)
                        e.preventDefault();
                });
            });
   </script>
    </head>
    <body>
        <h1>Select elective subjects</h1>
        <p>Make new subject:</p>
        <p>Name of the new subject:</p>
        <form name="createNewSubject" id="createNewSubject" method="post" action="FrontController">
            <input type="hidden" name="command" value="CreateNewSubjectCommand">
        <input type="text" name="newSubjectName" >
        
        <p>Description of the new subject:</p>
        <input type="text" name="newSubjectDescription" >
        
        <input type="submit" name="createNewSubject" value="Make new subject" >
        
        <br /><p style="color: green">${lool}</p>
        
        </form>
        <br /><br />
        <p>Choose from the list below:</p>
        <form name="electiveSelection" id="subjectSelection" method="post" action="FrontController">
            <input type="hidden" name="command" value="MakeSelectionCommand">
            <c:forEach items="${subjects}" var="subject">
            <input type="checkbox" name="${subject.id}"  value="${subject.id}">
            ${subject.name}<br />
            </c:forEach>
            <input type="submit" name="make_electivesubject_selection" value="Make selection" >
        </form>
    </body>
</html>
