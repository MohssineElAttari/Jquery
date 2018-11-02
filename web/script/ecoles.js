$(document).ready(function () {

    $('#container').on('click', '.update', function () {
        var id = $(this).attr("v");
        $.ajax({
            url: "LoadEcole",
            type: 'GET',
            data: {id: id},
            success: function (data) {
                $("#nom").val(data.nom);
                $("#tel").val(data.tel);
                $("#adresse").val(data.adresse);
                $("#nbrEtudiant").val(data.nbrEtudiant);
                $("#save").html("Modifier");
                $("#operation").val("update");
                $("#operation").attr("v", id);
            },
            error: function (errorThrown) {
                console.log("erreur");
            }
        });
    });

    $('#container').on('click', '.delete', function () {
        var id = $(this).attr("v");
        if (confirm("Voulez-vous Vraiement supprimer cette ecole ?")) {
            $.ajax({
                url: "DeleteEcole",
                type: 'GET',
                cache: false,
                data: {id: id},
                success: function (data) {
                    $("#container").empty();
                    $("#container").html(remplir(data));
                },
                error: function (errorThrown) {
                    console.log("erreur");
                }
            });
            return true;
        } else {
            return false;
        }
    });


    $("#save").click(function () {
        var nom = $("#nom").val();
        var adresse = $("#adresse").val();
        var tel = $("#tel").val();
        var nbrEtudiant = $("#nbrEtudiant").val();
        var operation = $("#operation").val();
        var id = $("#operation").attr("v");
        $.ajax({
            url: "AddEcole",
            type: 'GET',
            data: {nom: nom, adresse: adresse, tel: tel, nbrEtudiant: nbrEtudiant, operation: operation, id: id},
            success: function (data) {
                init(); //vider les champs 
                $("#container").empty(); //vider le tableau
                $("#container").html(remplir(data)); // remplir le tableau
                $("#save").html("Ajouter");
            },
            error: function (errorThrown) {
                console.log("erreur");
            }
        });
    });

    function init() {
        $("#nom").val("");
        $("#adresse").val("");
        $("#tel").val("");
        $("#nbrEtudiant").val("");
    }

    function remplir(data) {
        var ligne = "";
        for (i = 0; i < data.length; i++) {
            ligne += '<tr><td>' + data[i].id + '</td><td>' + data[i].nom + '</td><td>' + data[i].adresse + '</td><td>' + data[i].tel + '</td><td>' + data[i].nbrEtudiant + '</td><td><button class="delete" v="' + data[i].id + '">Supprimer</button></td><td><button class="update" v="' + data[i].id + '">Modifier</button></td></tr>';
        }
        return ligne;
    }
});