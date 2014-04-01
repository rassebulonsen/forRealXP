<%-- 
    Document   : studentList
    Created on : 28-03-2014, 11:19:34
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-2.0.3.js"></script>
        <title>Student List</title>
        
        <script>
            function moveToListe(fraListe,tilListe)
            {
                var a = document.getElementById(fraListe);
                var value = a.options[a.selectedIndex].value;
                var text = a.options[a.selectedIndex].text;
                $("#" + tilListe + "").append('<option value=' + value + '>' + text + '</option>');
                deleteItem(fraListe);
            }
            ;
            function deleteItem(elementId)
            {
                var a = document.getElementById(elementId);
                for (var count = a.options.length - 1; count >= 0; count--) {

                    //if the option is selected, delete the option
                    if (a.options[count].selected == true) {

                        try {
                            a.remove(count, null);

                        } catch (error) {

                            a.remove(count);
                        }
                    }
                }
            }
        </script>
    </head>
    
    <body>
        <h1>Fill Subjects with Students </h1>
        <div id="poolA" style="display: table-cell; width: 550px;background-color: aquamarine">
            <h3>Pool A</h3>
            <p>Main liste</p>
            <select id="poolAmain" multiple=""></select>
            <c:forEach items="${poolAList}" var="list"> 
                    <p>${list.subjName}</p>
                    <select id="${list.subjId}" multiple="">
                <c:forEach items="${list.students}" var="student">
                    <option value="${student.stuId}">
                            ${student.fName} ${student.lName}  ${student.firstPri1ElectiveSubjName} 
                            ${student.firstPri2ElectiveSubjName} ${student.secondPri1ElectiveSubjName} 
                            ${student.secondPri2ElectiveSubjName} 
                        </option>
                </c:forEach>    
                    </select>
                    <button onclick="moveToListe('${list.subjId}','poolAmain');">move to main</button>
                <button onclick="moveToListe('poolAmain','${list.subjId}');">move to List ${list.subjName}</button>
            </c:forEach>
        </div >
        <div id="poolB" style="display: table-cell; width: 550px;background-color: bisque">
            <h3>Pool B</h3>
            <p>Main liste</p>
            <select id="poolBmain" multiple=""></select>
            <c:forEach items="${poolBList}" var="list"> 
                    <p>${list.subjName}</p>
                    <select id="${list.subjId}" multiple="">
                <c:forEach items="${list.students}" var="student">
                    <option value="${student.stuId}">
                            ${student.fName} ${student.lName}  ${student.firstPri1ElectiveSubjName} 
                            ${student.firstPri2ElectiveSubjName} ${student.secondPri1ElectiveSubjName} 
                            ${student.secondPri2ElectiveSubjName} 
                        </option>
                </c:forEach>    
                    </select>
                    <button onclick="moveToListe('${list.subjId}','poolBmain');">move to main</button>
                
                <button onclick="moveToListe('poolBmain','${list.subjId}')">move to List ${list.subjName}</button>
            </c:forEach>
        </div>
        <button onclick="saveList();">Gem Liste</button>
    </body>
</html>
