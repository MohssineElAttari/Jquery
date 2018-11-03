<%-- 
    Document   : professeur
    Created on : 3 nov. 2018, 19:38:55
    Author     : MAC
--%>

<%@page import="beans.Professeur"%>
<%@page import="service.ProfesseurService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="script/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="script/moment.js" type="text/javascript"></script>
        <script src="script/professeur.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
        <title>Gestion Ecoles</title>
    </head>
    <body>
        <%@include  file="menu.jsp" %>
        <div style="margin-left:20%;padding:1px 16px;height:1000px;">
            <fieldset>
                <legend>Ajouter Professeur</legend>
                <table border="0">
                    <input id="operation" type="hidden" name="operation" value="add" v="" />
                    <tr>
                        <td>Nom : </td>
                        <td><input id="nom" type="text" name="nom" value="" /></td>
                    </tr>
                    <tr>
                        <td>Prenom : </td>
                        <td><input id ="prenom" type="text" name="prenom" value="" /></td>
                    </tr>
                    <tr>
                        <td>Adresse :</td>
                        <td><input id="adresse" type="text" name="adresse" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button id="save">Ajouter</button></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>Liste des Professeurs</legend>
                <table border="0" id="customers">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Adresse</th>
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody id="container">
                        <%
                            ProfesseurService ps = new ProfesseurService();

                            for (Professeur p : ps.findAll()) {
                        %>
                        <tr>
                            <td><%= p.getId()%></td>
                            <td><%= p.getNom()%></td>        
                            <td><%= p.getPrenom()%></td>
                            <td><%= p.getAdresse()%></td>
                            <td><button class="delete" v="<%= p.getId()%>">Supprimer</button></td>
                            <td><button class="update" v="<%= p.getId()%>">Modifier</button></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </fieldset>
        </div>
    </body>
</html>