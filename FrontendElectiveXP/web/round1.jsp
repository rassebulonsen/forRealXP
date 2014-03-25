<%-- 
    Document   : ChoiseRound1
    Created on : 04-03-2014, 12:48:21
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
        <title>Round 1 selection</title>
        <script>
            $(document).ready(function() {
                $('#makechoise').click(function(e) {
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

            var prev = -1;
            $("select").change(function() {
                if ($(this).val() > -1) {
                    $("select").not(this).find("option[value=" + $(this).val() + "]").attr('disabled', 'disabled');
                    $("select").not(this).find("option[value=" + previous + "]").removeAttr('disabled');
                } else {
                    $("select").not(this).find("option[value=" + previous + "]").removeAttr('disabled');
                }
            }).focus(function() {
                previous = $(this).val();
            });

//function selectedremoveFirstPri1()
//{
////    var list1 = document.getElementById("firstpri1");
////    var index = list1.options[list1.selectedIndex];
//    alert("Test");
//}
        </script>
    </head>
    <body>
        <h1 style="color: red">First round</h1>
        <div id="subjects">
            <h2>Choose 2 first and 2 second priorities</h2>

            <c:forEach items="${subjects}" var="subject">
                <p>Subject name: ${subject.name}. Subject id: ${subject.id}</p>

            </c:forEach>
            </br><p>Write the subjects id you wish in the boxes below:</p>
            <form name="selectSubjects" id="selectSubjects" method="post" action="FrontController">
                <input type="hidden" name="command" value="makeChoises_command">
                <p style="color: red">${error}</p>
                <p style="display: inline">First priority(1)</p>
                <select name="firstpri1" onchange="callSave(this);">
                    <option value="-1">Vælg fag</option>
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <p style="display: inline">First priority(2)</p>
                <select name="firstpri2" onchange="callSave(this);">
                    <option value="-1">Vælg fag</option>
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <p style="display: inline">Second priority(1)</p>
                <select name="secondpri1" onchange="callSave(this);">
                    <option value="-1">Vælg fag</option>
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <p style="display: inline">Second priority(2)</p>
                <select name="secondpri2" onchange="callSave(this);">
                    <option value="-1">Vælg fag</option>
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <!--            <p style="display: inline">First priority(1)</p>
                            <input type="text" name="firstpri1" value="{firstpri1}" unique="currency" onkeypress="return onlyNumbers();">
                            <p style="display: inline">First priority(2)</p>
                            <input type="text" name="firstpri2" value="{firstpri2}" unique="currency" onkeypress="return onlyNumbers();">
                            <p style="display: inline">Second priority(1)</p>
                            <input type="text" name="secondpri1" value="{secondpri1}" unique="currency" onkeypress="return onlyNumbers();">
                            <p style="display: inline">Second priority(2)</p>
                            <input type="text" name="secondpri2" value="{secondpri2}" unique="currency" onkeypress="return onlyNumbers();"></br>-->
                <input type="submit" name="makeChoises" id="makechoise" value="Make choises">

            </form>
        </div>
    </body>
</html>
