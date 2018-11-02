<%-- 
    Document   : machine
    Created on : 27 oct. 2018, 10:56:12
    Author     : a
--%>

<%@page import="java.text.SimpleDateFormat"%>


<%@page import="service.ServiceService"%>
<%@page import="beans.Service"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="script/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="script/services.js" type="text/javascript"></script>
        <script src="script/moment.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
        <title>Gestion Sercices</title>
    </head>
    <body>
        <%@include  file="menu.jsp" %>
        <div style="margin-left:20%;padding:1px 16px;height:1000px;">
            <fieldset>
                <legend>Ajouter Service</legend>
                <table border="0">
                    <input id="operation" type="hidden" name="operation" value="add" v="" />
                    <tr>
                        <td>Nom service : </td>
                        <td><input id="nomService" type="text" name="nomService" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td>Date Création service : </td>
                        <td><input id ="date" type="date" name="date" value="" /></td>
                    </tr>
                    <tr>
                        <td>Prix : </td>
                        <td><input id="prix" type="number" name="prix" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button id="save">Ajouter</button></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>Liste des services</legend>
                <table border="0" id="customers">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nom service</th>
                            <th>Date création service</th>
                            <th>Prix</th>
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody id="container">
                        <%
                            ServiceService ss = new ServiceService();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            for (Service m : ss.findAll()) {
                        %>
                        <tr>
                            <td><%= m.getId()%></td>
                            <td><%= m.getNomService()%></td>
                            
                            <td><%= sdf.format(m.getDate())%></td>
                            <td><%= m.getPrix()%></td>
                            <td><button class="delete" v="<%= m.getId()%>">Supprimer</button></td>
                            <td><button class="update" v="<%= m.getId()%>">Modifier</button></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </fieldset>
        </div>
    </body>
</html>