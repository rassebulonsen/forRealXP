<%-- 
    Document   : round2
    Created on : Mar 18, 2014, 10:01:59 AM
    Author     : Rasmus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-2.0.3.js"></script>
        <script src="js/numbers.js"></script>
        <script src="js/dropdownScript.js"></script>
        <script>
            $(document).ready(function(){
                $('#makechoise2').click(function(e){
                    var isValid = true;
                    $('input[type="text"]').each(function(){
                        if($.trim($(this).val()) === '') {
                        isValid = false;
                        $(this).css({
                            "border": "1px solid red",
                            "background": "#FFCECE"
                        });
                    }
                    else {
                        $(this).css({
                            "border":"",
                            "background": ""
                        });
                    }
                });
                if (isValid === false)
                    e.preventDefault();
                });
                });
        
jQuery.validator.addMethod("unique", function(value, element, params) {
    var prefix = params;
    var selector = jQuery.validator.format("[name!='{0}'][name^='{1}'][unique='{1}']", element.name, prefix);
    var matches = new Array();
    $(selector).each(function(index, item) {
        if (value == $(item).val()) {
            matches.push(item);
        }
    });

    return matches.length == 0;
}, "Value is not unique.");

jQuery.validator.classRuleSettings.unique = {
    unique: true
};
$("#selectSubjects").validate();

$("#makechoise").click(function() {
    $("#selectSubjects").valid();
});
        </script>
        <title>Round 2</title>
    </head>
    <body>
        <h1>Round 2</h1>
        <p>You must make one first and one second priority in each pool:</p>
        <form name="selectPoolSubjects" id="selectSubjects" method="post" action="FrontController">
            <input type="hidden" name="command" value="makeChoises2_Command">
            <div>
                <h2>Pool A</h2>
                <c:forEach items="${PoolA}" var="pa">
                    <p>Subject name: ${pa.name}. Subject id: ${pa.id}</p>
                </c:forEach>
                
                <p style="display: inline">First priority(A)</p>
                <select name="firstpriA" onchange="callSave(this);">
                    <option value="-1">Vælg fag</option>
                    <c:forEach items="${PoolA}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <!--<input type="text" name="firstpriA" unique="currency" onkeypress="return onlyNumbers();">-->
                <p style="display: inline">Second priority(A)</p>
                <select name="secondpriA" onchange="callSave(this);">
                    <option value="-1">Vælg fag</option>
                    <c:forEach items="${PoolA}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <!--<input type="text" name="secondpriA" unique="currency" onkeypress="return onlyNumbers();">-->
            </div>
            <div>
                <h2>Pool B</h2>
                <c:forEach items="${PoolB}" var="poolB">
                    <p>Subject name: ${poolB.name}. Subject id: ${poolB.id}</p>
                </c:forEach>
                <p style="display: inline">First priority(B)</p>
                <select name="firstpriB" onchange="callSave(this);">
                    <option value="-1">Vælg fag</option>
                    <c:forEach items="${PoolB}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <!--<input type="text" name="firstpriB" unique="currency" onkeypress="return onlyNumbers();">-->
                <p style="display: inline">Second priority(B)</p>
                <select name="secondpriB" onchange="callSave(this);">
                    <option value="-1">Vælg fag</option>
                    <c:forEach items="${PoolB}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <!--<input type="text" name="secondpriB" unique="currency" onkeypress="return onlyNumbers();"></br>-->
                <p style="color: red">${error}</p>
                <input type="submit" name="makeChoises2" id="makechoise2" value="Make choises">
            </div>

        </form>
    </body>
</html>
