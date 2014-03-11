<%-- 
    Document   : pool
    Created on : 05-03-2014, 12:34:34
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-2.0.3.js"></script>
        <title>Make Pools</title>
        <script>
            function sendPools()
            {
               var list = document.getElementById('poolA');
                var poolA="";
                for (var count = list.options.length - 1; count >= 0; count--) {
                    poolA = poolA+list.children[count].value;
                    if(count !==0)
                        {
                            poolA = poolA+",";
                        }
                }
                var list2 = document.getElementById('poolB');
                var poolB="";
                for (var count = list2.options.length - 1; count >= 0; count--) {
                    poolB = poolB+list2.children[count].value;
                    if(count !==0)
                        {
                            poolB = poolB+",";
                        }
                }
                $.ajax({
                    url: "/FrontendElectiveXP/AjaxController",
                    data: {
                        command :"getStat",
                        poolA: poolA,
                        poolB: poolB
                    },
                    success: detGikGodt
                });
            };
            function detGikGodt(data)
            {
               //alert(data);
               $("#statistics").html(data);
            }
            ;
            function savePools()
            {
               var list = document.getElementById('poolA');
                var poolA="";
                for (var count = list.options.length - 1; count >= 0; count--) {
                    poolA = poolA+list.children[count].value;
                    if(count !==0)
                        {
                            poolA = poolA+",";
                        }
                }
                var list2 = document.getElementById('poolB');
                var poolB="";
                for (var count = list2.options.length - 1; count >= 0; count--) {
                    poolB = poolB+list2.children[count].value;
                    if(count !==0)
                        {
                            poolB = poolB+",";
                        }
                }
                $.ajax({
                    url: "/FrontendElectiveXP/AjaxController",
                    data: {
                        command :"save",
                        poolA: poolA,
                        poolB: poolB
                    },
                    success: detGikGodt2
                });
            };
            function detGikGodt2(data)
            {
               //alert(data);
               $("#result").html(data);
            }
            ;
            function moveToListe(fraListe, tilListe)
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
        <div style="display: table-cell; width: 200px;height: 200px;background-color: aquamarine">
            <h3>All Subjects</h3>
            <select id="allefag" multiple="">
                
                <c:forEach items="${fagliste}" var="fag">
                    <option value="${fag.id}">
                        ${fag.name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div style="display: table-cell;width: 100px;height: 200px;background-color: bisque;">
            <button onclick="moveToListe('allefag', 'poolA');">Pool A</button> <br/>
            <button onclick="moveToListe('allefag', 'poolB');">Pool B</button>
        </div>
        <div style="display: table-cell;width: 200px;height: 200px;background-color: chartreuse;">
            <h3>Pool A</h3>
            <select id="poolA" multiple="">

            </select>
            <button onclick="moveToListe('poolA', 'allefag');">Back</button> <br/>
            <h3>Pool B</h3>
            <select id="poolB" multiple="">

            </select>
            <button onclick="moveToListe('poolB', 'allefag');">Back</button> <br/>
        </div>
        <div>
            <button onclick="sendPools();">Show Statistics</button>
            <table id="statistics" border="1">
                <tr>
                    <th>nr</th>
                    <th>(1,1)</th>
                    <th>(1,2)</th>
                    <th>(2,2)</th>
                    <th>(1,0)</th>
                    <th>(2,0)</th>
                    <th>(0,0)</th>
                </tr>
            </table>
            <button onclick="savePools();">Gem Pools</button>
            <p id="result"></p>
        </div>

    </body>
</html>
