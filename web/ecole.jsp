

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="beans.Ecole"%>
<%@page import="service.EcoleService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="script/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="script/ecoles.js" type="text/javascript"></script>
        <script src="script/moment.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
        <title>Gestion Ecoles</title>
    </head>
    <body>
        <%@include  file="menu.jsp" %>
        <div style="margin-left:20%;padding:1px 16px;height:1000px;">
            <fieldset>
                <legend>Ajouter Machine</legend>
                <table border="0">
                    <input id="operation" type="hidden" name="operation" value="add" v="" />
                    <tr>
                        <td>Nom : </td>
                        <td><input id="nom" type="text" name="nom" value="" /></td>
                    </tr>
                    <tr>
                        <td>Adresse :</td>
                        <td><input id="adresse" type="text" name="adresse" value="" /></td>
                    </tr>
                    <tr>
                        <td>Tel : </td>
                        <td><input id ="tel" type="text" name="tel" value="" /></td>
                    </tr>
                    <tr>
                        <td>Nombre des étudiants : </td>
                        <td><input id="nbrEtudiant" type="number" name="nbrEtudiant" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button id="save">Ajouter</button></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>Liste des Ecoles</legend>
                <table border="0" id="customers">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nom</th>
                            <th>Adresse</th>
                            <th>Tel</th>
                            <th>Nombre des etudiants</th>
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody id="container">
                        <%
                            EcoleService es = new EcoleService();

                            for (Ecole e : es.findAll()) {
                        %>
                        <tr>
                            <td><%= e.getId()%></td>
                            <td><%= e.getNom()%></td>
                            <td><%= e.getAdresse()%></td>
                            <td><%= e.getTel()%></td>
                            <td><%= e.getNbrEtudiant()%></td>
                            <td><button class="delete" v="<%= e.getId()%>">Supprimer</button></td>
                            <td><button class="update" v="<%= e.getId()%>">Modifier</button></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </fieldset>
        </div>
    </body>
</html>